package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.vo.ModalidadeVO;

public class ModalidadeDAO {

	public ModalidadeVO cadastrarModalidade(ModalidadeVO novaModalidade) {
		
		Connection conn = Banco.getConnection();
		String sql = "INSERT INTO MODALIDADE(nome, valorMensal) VALUES(?, ?)";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql, PreparedStatement.RETURN_GENERATED_KEYS);
		
		try {
			
			stmt.setString(1, novaModalidade.getNome());
			stmt.setDouble(2, novaModalidade.getValorMensal());
			stmt.execute();
			
			ResultSet rs = stmt.getGeneratedKeys();
			
			if(rs.next()) {
				
				int idGerado = rs.getInt(1);
				novaModalidade.setId(idGerado);
				
			}
		
		} catch(SQLException e){
			
			System.out.println("Erro ao cadastrarModalidade");
		}
		
		return novaModalidade;
		
	}
	
	public ArrayList<ModalidadeVO> consultarModalidade() {
		String sql = " SELECT * FROM modalidade ";

		Connection conexao = Banco.getConnection();
		PreparedStatement preparedStatement = Banco.getPreparedStatement(conexao, sql);
		
		ArrayList<ModalidadeVO> modalidades = new ArrayList<ModalidadeVO>();
		try {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				ModalidadeVO modalidadeConsultada = construirModalidadeDoResultSet(rs);
				modalidades.add(modalidadeConsultada);
			}
		} catch (SQLException e) {
			System.out.println(" Erro ao consultar modalidades. Causa: " + e.getMessage());
		}
		return modalidades;
	}

	private ModalidadeVO construirModalidadeDoResultSet(ResultSet rs) {
		ModalidadeVO modalidade = new ModalidadeVO();
		
		try {
			modalidade.setId(rs.getInt("idModalidade"));
			modalidade.setNome(rs.getString("nomeModalidade"));
			modalidade.setValorMensal(rs.getDouble("valorModalidade"));
		} catch (Exception e) {
			System.out.println(" Erro ao construir modalidade a partir do ResultSet. Causa: " + e.getMessage());
		}
		
		return modalidade;
	}

	public boolean verificarNome() {
		// TODO Auto-generated method stub
		return false;
	}
}