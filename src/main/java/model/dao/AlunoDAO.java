package model.dao;

import java.sql.Connection	;	
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.dao.Banco;	
import model.vo.AlunoVO;
import model.vo.PessoaVO;
public class AlunoDAO {

	
	//Cadastrar Aluno:
	public AlunoVO cadastrarAluno(AlunoVO novoAluno) {
		
		Connection conn = Banco.getConnection();
		String sql = "INSERT INTO (idPessoa, observacoes, dtMatricula, matricula, situacao, dtCancelamento,idModalidade) VALUES(?, ?, ?, ?)";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql, PreparedStatement.RETURN_GENERATED_KEYS);
		
		try {
			
		stmt.setInt(1, novoAluno.getId());
		stmt.setString(2,  novoAluno.getObservacoes());
		stmt.setDate(3, java.sql.Date.valueOf(novoAluno.getDtMatricula()));
		stmt.setInt(4, novoAluno.getMatricula());
		stmt.setString(5, novoAluno.isSituacao()?"1":"2");
		stmt.setDate(6, java.sql.Date.valueOf(novoAluno.getDtCancelamento()));
		stmt.setInt(7, novoAluno.getModalidade().getId());
		stmt.execute();
		
		} catch(SQLException e) {
			
			System.out.println("Erro ao cadastrar aluno."
							 +"\nErro: "+e.getMessage());
		}
		
		return novoAluno;
	}
	
	//Excluir Aluno:
	public boolean excluir(int id) {
		
		AlunoVO aluno = new AlunoVO();
		Connection conn = Banco.getConnection();
		String sql = "DELETE FROM PESSOA, ALUNO WHERE ID = "+id;
		Statement stmt = Banco.getStatement(conn);
		int quantidadeLinhasAfetadas = 0;
		
		try {
			
			quantidadeLinhasAfetadas = stmt.executeUpdate(sql);
			
		} catch(SQLException e) {
			
			System.out.println("Erro ao excluir aluno"
					          +"\nErro: "+e.getMessage());
		}
		boolean excluiu = quantidadeLinhasAfetadas > 0;
		
		return excluiu;
	}
	
	public boolean alterar(AlunoVO aluno) {
		
		Connection conn = Banco.getConnection();
		String sql = "UPDATE ALUNO "
				    +"\nSET idPessoa = ?, observacoes = ?, dtMatricula = ?, matricula = ?, situacao = ?, dtCancelamento = ?, idModalidade"
				    +"\nWHERE ID = ?";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		int registrosAlterados = 0;
		
		try {
			
			stmt.setInt(1, aluno.getId());
			stmt.setString(2,  aluno.getObservacoes());
			stmt.setDate(3, java.sql.Date.valueOf(aluno.getDtMatricula()));
			stmt.setInt(4, aluno.getMatricula());
			stmt.setString(5, aluno.isSituacao()?"1":"2");
			stmt.setDate(6, java.sql.Date.valueOf(aluno.getDtCancelamento()));
			stmt.setInt(7, aluno.getModalidade().getId());
			registrosAlterados = stmt.executeUpdate();
			
		} catch(SQLException e) {
			
			System.out.println("Erro ao alterar informaçoes do aluno"
					          +"\nErro: "+e.getMessage());
		}
		
		boolean alterado = registrosAlterados > 0;
		return alterado;
	}
	
	public boolean existeRegistroPorIdAlunoDAO(int idAluno) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT idaluno FROM aluno WHERE idaluno = " + idAluno;
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()){
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query que verifica existência de Registro por Id.");
			System.out.println("Erro: " + e.getMessage());
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	


}
