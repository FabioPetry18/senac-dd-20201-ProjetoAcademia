package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.vo.AlunoVO;
import model.vo.PessoaVO;

public class AlunoDAO {

	PessoaDAO pessoaDAO = new PessoaDAO();
	AlunoVO a = new AlunoVO();

	public AlunoVO cadastrarAluno(AlunoVO novoAluno) {
		 int idPessoa = pessoaDAO.salvar(novoAluno);
		Connection conn = Banco.getConnection();
		String query = "INSERT INTO ALUNO(idPessoa, observacoes, dtMatricula, situacao) VALUES(?, ?, ?, ?)";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, query, PreparedStatement.RETURN_GENERATED_KEYS);

		try {
			stmt.setInt(1, idPessoa);
			stmt.setString(2, novoAluno.getObservacoes());
			stmt.setDate(3, java.sql.Date.valueOf(novoAluno.getDtMatricula()));
			stmt.setBoolean(4, novoAluno.isSituacao());

			stmt.execute();

		} catch (SQLException e) {

			System.out.println("Erro ao cadastrar aluno. \nErro: " + e.getMessage());
		}

		return novoAluno;
	}

	// Excluir Aluno:
	public int excluir(int id) {

		int resultado = 0;
		pessoaDAO.excluir(id);

		Connection conn = Banco.getConnection();
		String query = "DELETE FROM ALUNO WHERE idAluno = " + id;
		Statement stmt = Banco.getStatement(conn);

		try {

			resultado = stmt.executeUpdate(query);

		} catch (SQLException e) {

			System.out.println("Erro ao excluir Aluno. \nErro: " + e.getMessage());

		} finally {
			Banco.closeConnection(conn);
			Banco.closeStatement(stmt);
		}

		return resultado;
	}

	public boolean alterar(AlunoVO aluno) {
		
		
		pessoaDAO.alterar(aluno);

		Connection conn = Banco.getConnection();
		String query = "UPDATE ALUNO "
				+ "SET observacoes = ? "
				+ "WHERE idAluno = ?";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, query);
		int registrosAlterados = 0;

		try {

			stmt.setString(1, aluno.getObservacoes());
			stmt.setInt(2, aluno.getId());

			registrosAlterados = stmt.executeUpdate();

		} catch (SQLException e) {

			System.out.println("Erro ao alterar informaçoes do aluno" + "\nErro: " + e.getMessage());
		}

		boolean alterado = registrosAlterados > 0;
		return alterado;
	}

	// Contruir alunos do ResultSet:
	public AlunoVO construirAlunoDoResultSet(ResultSet rs) {

		AlunoVO a = new AlunoVO();

		try {

			a.setId(rs.getInt("idAluno"));
			a.setNome(rs.getString("nome"));
			a.setCpf(rs.getString("cpf"));
			a.setDtNascimento(rs.getDate("dtNascimento").toLocalDate());
			a.setSexo(rs.getString("sexo"));
			a.setTelefone(rs.getString("telefone"));
			a.setCelular(rs.getString("celular"));
			a.setEmail(rs.getString("email"));
			a.setEndereco(rs.getString("endereco"));
			a.setBairro(rs.getString("bairro"));
			a.setCidade(rs.getString("cidade"));
			a.setUf(rs.getString("uf"));
			a.setCep(rs.getString("cep"));
			a.setObservacoes(rs.getString("observacoes"));
			// System.out.println(rs.);

		} catch (SQLException e) {

			System.out.println("Erro ao construir aluno a partir do ResultSet" + "\nErro: " + e.getMessage());

		}
		return a;
	}

	// Consultar todos Alunos:
	public ArrayList<AlunoVO> consultarTodosAlunos() {

		Connection conn = Banco.getConnection();
		String query = "SELECT * FROM ALUNO a, PESSOA p WHERE a.idAluno = p.idPessoa ORDER BY p.nome ASC";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, query);
		ArrayList<AlunoVO> alunos = new ArrayList<AlunoVO>();

		try {

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				AlunoVO a = construirAlunoDoResultSet(rs);
				alunos.add(a);
			}

		} catch (SQLException e) {

			System.out.println("Erro ao consultar alunos." + "\nErro: " + e.getMessage());

		} finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(stmt);
		}

		return alunos;
	}

	public boolean existeAlunoPorId(int id) {

		Connection conn = Banco.getConnection();
		String query = "SELECT idAluno FROM ALUNO WHERE idAluno = " + id;
		Statement stmt = Banco.getStatement(conn);
		ResultSet result = null;

		try {

			result = stmt.executeQuery(query);

			if (result.next()) {

				return true;

			}

		} catch (SQLException e) {

			System.out.println("Erro ao verificar existência do aluno. \nErro: " + e.getMessage());

		} finally {

			Banco.closeConnection(conn);
			Banco.closeStatement(stmt);
			Banco.closeResultSet(result);

		}
		return false;

	}

	public AlunoVO verificarAlunoPorCpf(String cpf) {
		
		AlunoVO aluno = null;
		String query = "SELECT * FROM ALUNO, PESSOA p WHERE p.cpf = " + cpf;
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet result = null;

		try {

			result = stmt.executeQuery(query);

			if (result.next()) {
				aluno = construirAlunoDoResultSet(result);
			}

		} catch (SQLException e) {

			System.out.println("Erro ao verificar existência do aluno por cpf. \nErro: " + e.getMessage());

		} finally {
			Banco.closeConnection(conn);
			Banco.closeStatement(stmt);
			Banco.closeResultSet(result);
		}
		return aluno;

	}

}