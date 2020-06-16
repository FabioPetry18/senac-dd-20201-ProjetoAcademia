package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.vo.ModalidadeVO;
import model.vo.ModalidadeVO;

public class ModalidadeDAO {


	public ModalidadeVO cadastrarModalidade (ModalidadeVO novaModalidade) {
		Connection conexao = Banco.getConnection();
		String sql = " INSERT INTO MODALIDADE(NOME) "
				+ " VALUES (?) ";
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql, 
				PreparedStatement.RETURN_GENERATED_KEYS);
		
		try {
			stmt.setString(1, novaModalidade.getNome());
			stmt.execute();
			
			ResultSet rs = stmt.getGeneratedKeys();
			
			
		} catch (SQLException e) {
			System.out.println("Erro ao inserir nova Modalidade.");
			System.out.println("Erro: " + e.getMessage());
		}
		
		return novaModalidade;
  }

	public boolean verificarNome() {
		// TODO Auto-generated method stub
		return false;
	}
}