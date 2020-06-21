package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.vo.ModalidadeVO;
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

	public boolean verificarNome() {
		// TODO Auto-generated method stub
		return false;
	}
}