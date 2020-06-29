package model.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.ArrayList;

import model.dao.Banco;
import model.vo.PessoaVO;
import model.vo.InstrutorVO;

public class InstrutorDAO {
	
	PessoaDAO dao = new PessoaDAO();
	
	public InstrutorVO cadastrarInstrutor(InstrutorVO novoInstrutor) {
		
		Connection conn = Banco.getConnection();
		String sql = "INSERT INTO INSTRUTOR(idInstrutor, formacao, dtAdmissao, valSalario) VALUES(?, ?, ?, ?)";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql, PreparedStatement.RETURN_GENERATED_KEYS);
		
		try {
			
			stmt.setInt(1, dao.salvar(novoInstrutor));
			stmt.setString(2, novoInstrutor.getFormacao());
			stmt.setDate(3, java.sql.Date.valueOf(novoInstrutor.getDtAdmissao()));
			stmt.setDouble(4, novoInstrutor.getValSalario());
			stmt.execute();
			
		} catch(SQLException e) {
			
			System.out.println("Erro ao cadastrar instrutor. Erro: "+e.getMessage());
			
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
	
	public InstrutorVO construirInstrutorDoResultSet(ResultSet rs) {
		
		InstrutorVO i = new InstrutorVO();
		
		try {
			
			i.setNome(rs.getString("nome"));
			i.setCpf(rs.getString("cpf"));
			i.setId(rs.getInt("id"));
			i.setValSalario(rs.getDouble("valSalario"));
			
			
		} catch(SQLException e) {
			
			System.out.println("Erro ao construir instrutor a partir do ResultSet"
					          +"\nErro: "+e.getMessage());
			
		}
		
		return i;
		
	}
	
	public ArrayList<InstrutorVO> consultarTodosInstrutores(){
		
		Connection conn = Banco.getConnection();
		String sql = "SELECT pessoa.nome, pessoa.cpf, instrutor.valSalario, instrutor.idInstrutor"
					+"\nFROM instrutor, pessoa"
				    +"\nORDER BY nome ASC";		
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		ArrayList<InstrutorVO> instrutores = new ArrayList<InstrutorVO>();

		try {
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				InstrutorVO i = construirInstrutorDoResultSet(rs);
				instrutores.add(i);
				
			}
			
		} catch(SQLException e) {
			
			System.out.println("Erro ao consultar todos instrutores"
					          +"\nErro: "+e.getMessage());
			
		}
		
		return instrutores;
		
	}
	
	
}
























