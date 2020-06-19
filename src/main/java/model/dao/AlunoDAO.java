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

	
	
	public int cadastrarAluno(AlunoVO a) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "INSERT INTO ALUNO (observacoes,dtMatricula,numMatricula,situacao,dataCancelamento,modalidade) VALUES (" 
				+ a.getObservacoes() + ", '" 
				+ a.getDtMatricula() + "', '" 
				+ a.getNumMatricula() + "', '"
				+ a.getSituacao() + "', '"
				+ a.getDataCancelamento() + "', '"
				+ a.getModalidade() + "')";
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Cadastro do ALUNO.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}
	
	
	
	public AlunoVO salvar(AlunoVO novoAluno) {
		Connection conexao = Banco.getConnection();
		String sql = " INSERT INTO ALUNO(idAluno,observacoes,dtMatricula,numMatricula,situacao,dataCancelamento,modalidade)"			 
				+" VALUES(?,?,?,?,?,?)";
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql, 
				PreparedStatement.RETURN_GENERATED_KEYS);
		try {
			stmt.setInt(1, novoAluno.getIdAluno());
			stmt.setString(2, novoAluno.getObservacoes());
			stmt.setString(3, novoAluno.getDtMatricula());
			stmt.setInt(4, novoAluno.getNumMatricula());
			stmt.setString(5,novoAluno.getSituacao());
			stmt.setString(6, novoAluno.getDataCancelamento());
			stmt.setString(7, novoAluno.getModalidade());
			
			stmt.execute();
			ResultSet rs = stmt.getGeneratedKeys();
			
		} catch (SQLException e) {
			System.out.println("Erro ao inserir novo Aluno.");
			System.out.println("Erro: " + e.getMessage());
		}
		
		return novoAluno;
	}

	public boolean verificarCpf(String cpf) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT cpf FROM aluno WHERE cpf = '" + cpf + "'";
		
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()){
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query que verifica existência de Usuário por CPF.");
			System.out.println("Erro: " + e.getMessage());
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
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

	
	public int excluirUsuarioDAO(AlunoVO a) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "DELETE FROM aluno WHERE idaluno = " + a.getIdAluno();
		try{
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e){
			System.out.println("Erro ao executar a Query de Exclusão do Usuário.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}


}



