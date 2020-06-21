package model.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import model.dao.Banco;
import model.vo.PessoaVO;
import model.vo.InstrutorVO;
public class InstrutorDAO {
	
	public InstrutorVO cadastrarInstrutor(InstrutorVO novoInstrutor) {
		
		Connection conn = Banco.getConnection();
		String sql = "INSERT INTO INSTRUTOR(idPessoa, formacao, dtAdmissao, dtPagamento, valSalario) VALUES(?, ?, ?, ?, ?)";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql, PreparedStatement.RETURN_GENERATED_KEYS);
		
		try {
			
			stmt.setInt(1, novoInstrutor.getId());
			stmt.setString(2, novoInstrutor.getFormacao());
			stmt.setDate(3, java.sql.Date.valueOf(novoInstrutor.getDtAdmissao()));
			stmt.setDate(4, java.sql.Date.valueOf(novoInstrutor.getDtPagamento()));
			stmt.setFloat(5, novoInstrutor.getValSalario());
			stmt.execute();
			
		} catch(SQLException e) {
			
			System.out.println("Erro ao cadastrar instrutor"
						   	  +"\nErro: "+e.getMessage());
			
		}
		
		return novoInstrutor;
	}
	
	public boolean excluir(int id) {
		
		Connection conn = Banco.getConnection();
		String sql = "DELETE FROM ALUNO WHERE ID = "+id
				  +"\nDELETE FROM PESSOA WHERE ID = "+id;
		Statement stmt = Banco.getStatement(conn);
		int quantidadeLinhasAfetadas = 0;
		
		try {
			
			quantidadeLinhasAfetadas = stmt.executeUpdate(sql);
			
		} catch(SQLException e) {
			
			System.out.println("Erro ao excluir Instrutor."
						      +"\nErro: "+e.getMessage());
			
		}
		boolean excluiu = quantidadeLinhasAfetadas > 0;
		
		return excluiu;
	}
	

}

