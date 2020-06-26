package model.dao;

import java.sql.Connection	;	
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import model.dao.Banco;	
import model.vo.AlunoVO;
import model.vo.PessoaVO;
import model.vo.ModalidadeVO;

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
	public int excluir(AlunoVO aluno) {
		
		AlunoVO alunoVO = new AlunoVO();
		ModalidadeVO modalidadeVO = new ModalidadeVO();
		
		Connection conn = Banco.getConnection();
		String delete = "DELETE FROM ALUNO WHERE idAluno = "+alunoVO.getId()
				  +"\nDELETE FROM PESSOA WHERE idPessoa = "+alunoVO.getId()
				  +"\nDELETE FROM MODALIDADE WHERE idModalidade "+modalidadeVO.getId();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
			
			
		try {
			 
			resultado = stmt.executeUpdate(delete);
			
		} catch(SQLException e) {
			
			System.out.println("Erro ao excluir Aluno. \nErro: "+e.getMessage());	
			
		} finally {
			
			Banco.closeConnection(conn);
			Banco.closeStatement(stmt);
			
		}
		
		return resultado;
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
	
	//Contruir alunos do ResultSet:
	public AlunoVO construirAlunoDoResultSet(ResultSet rs) {
		
		AlunoVO a = new AlunoVO();
		
		try {
			
			a.setNome(rs.getString("nome"));
			a.setCpf(rs.getString("cpf"));
			a.setId(rs.getInt("id"));
			
		} catch(SQLException e) {
			
			System.out.println("Erro ao construir aluno a partir do ResultSet"
					         +"\nErro: "+e.getMessage());
			
		}
		return a;
	}
	
	//Consultar todos Alunos:
	public ArrayList<AlunoVO> consultarTodosAlunos(){
		
		Connection conn = Banco.getConnection();
		String sql = "SELECT nome, cpf, idAluno"
				  +"\nFROM ALUNO"
				  +"\nORDER BY nome ASC";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		ArrayList<AlunoVO> alunos = new ArrayList<AlunoVO>();
		
		try {
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				AlunoVO a = construirAlunoDoResultSet(rs);
				alunos.add(a);
				
			}
			
		} catch(SQLException e) {
			
			System.out.println("Erro ao consultar alunos."
					          +"\nErro: "+e.getMessage());
		}
		
		return alunos;
	}
	
	public boolean verificarCpf(String cpf) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;		
		String query = "SELECT CPF FROM aluno WHERE CPF = " + cpf;
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()){
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query que verifica existência de Registro por CPF.");
			System.out.println("Erro: " + e.getMessage());
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return false;
	}
	
	public boolean existeAlunoPorId(int id) {
		
		Connection conn = Banco.getConnection();
		String sql = "SELECT idAluno FROM ALUNO WHERE ID "+id;
		Statement stmt = Banco.getStatement(conn);
		ResultSet result = null;
		
		try {
			
			result = stmt.executeQuery(sql);
			
			if(result.next()) {
				
				return true;
				
			}
			
			
		} catch(SQLException e) {
			
			System.out.println("Erro ao verificar existência do aluno. \nErro: "+e.getMessage());
			
		} finally {
			
			Banco.closeConnection(conn);
			Banco.closeStatement(stmt);
			Banco.closeResultSet(result);
			
		}
		return false;
		
	}
	


}
