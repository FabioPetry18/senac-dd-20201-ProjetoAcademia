package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.vo.AlunoVO;

public class AlunoDAO {

	PessoaDAO pessoaDAO = new PessoaDAO();

	public AlunoVO cadastrarAluno(AlunoVO novoAluno) {

		Connection conn = Banco.getConnection();
		String sql = "INSERT INTO ALUNO(idAluno, observacoes, dtMatricula, situacao) VALUES(?, ?, ?, ?)";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql, PreparedStatement.RETURN_GENERATED_KEYS);

		try {
			stmt.setInt(1, pessoaDAO.salvar(novoAluno));
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
		String delete = "DELETE FROM ALUNO WHERE idAluno = " + id;
		Statement stmt = Banco.getStatement(conn);

		try {

			resultado = stmt.executeUpdate(delete);

		} catch (SQLException e) {

			System.out.println("Erro ao excluir Aluno. \nErro: " + e.getMessage());

		} finally {
			Banco.closeConnection(conn);
			Banco.closeStatement(stmt);
		}

		return resultado;
	}

	public boolean alterar(AlunoVO aluno) {

		Connection conn = Banco.getConnection();
		String sql = "UPDATE ALUNO "
				+ "\nSET idPessoa = ?, observacoes = ?, dtMatricula = ?, matricula = ?, situacao = ?, dtCancelamento = ?, idModalidade"
				+ "\nWHERE ID = ?";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		int registrosAlterados = 0;

		try {

			stmt.setInt(1, aluno.getId());
			stmt.setString(2, aluno.getObservacoes());
			stmt.setDate(3, java.sql.Date.valueOf(aluno.getDtMatricula()));
			stmt.setString(4, aluno.isSituacao() ? "1" : "2");
			stmt.setDate(5, java.sql.Date.valueOf(aluno.getDtCancelamento()));
			stmt.setInt(6, aluno.getModalidade().getId());
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

		} catch (SQLException e) {

			System.out.println("Erro ao construir aluno a partir do ResultSet" + "\nErro: " + e.getMessage());

		}
		return a;
	}

	// Consultar todos Alunos:
	public ArrayList<AlunoVO> consultarTodosAlunos() {

		Connection conn = Banco.getConnection();
		String sql = "SELECT * FROM ALUNO, PESSOA p ORDER BY p.nome ASC";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
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
		String sql = "SELECT idAluno FROM ALUNO WHERE idAluno = " + id;
		Statement stmt = Banco.getStatement(conn);
		ResultSet result = null;

		try {

			result = stmt.executeQuery(sql);

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

}
