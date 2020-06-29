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
	
	//Excluir Instrutor:
	public int excluir(InstrutorVO instrutor) {
		
		InstrutorVO instrutorVO = new InstrutorVO();
		Connection conn = Banco.getConnection();
		String delete = "DELETE FROM INSTRUTOR WHERE idInstrutor = "+instrutorVO.getId()
				    +"\nDELETE FROM PESSOA WHERE idPessoa = "+instrutorVO.getId();
		Statement stmt = Banco.getStatement(conn);
		int result = 0;
		
		try {
			
			result = stmt.executeUpdate(delete);
			
			
		} catch(SQLException e) {
			
			System.out.println("Erro ao excluir Instrutor. \nErro: "+e.getMessage());
			
		} finally {
			
			Banco.closeConnection(conn);
			Banco.closeStatement(stmt);
			
		}
		
		return result;
		
	}
	
	public boolean existeInstrutorPrId(int id) {
		
		Connection conn = Banco.getConnection();
		String query = "SELECT idInstrutor FROM INSTRUTOR WHERE ID = "+id;
		Statement stmt = Banco.getStatement(conn);
		ResultSet rs = null;
		
		try {
			
			rs = stmt.executeQuery(query);
			if(rs.next()) {
				
				return true;
				
			}
			
		} catch(SQLException e) {
			
			System.out.println("Erro ao verificar se existe instrutor por id. \nErro: "+e.getMessage());
			
		} finally {
			
			Banco.closeConnection(conn);
			Banco.closeStatement(stmt);
			Banco.closeResultSet(rs);
			
		}
		
		return false;
		
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
			
		} finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(stmt);
		}
		
		return instrutores;
		
	}
	
	
}
























