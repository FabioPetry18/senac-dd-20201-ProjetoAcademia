package model.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.ArrayList;

import model.dao.Banco;
import model.vo.PessoaVO;
import model.vo.InstrutorVO;

public class InstrutorDAO {

	PessoaDAO pessoaDAO = new PessoaDAO();

	public InstrutorVO cadastrarInstrutor(InstrutorVO novoInstrutor) {

		Connection conn = Banco.getConnection();
		String query = "INSERT INTO INSTRUTOR(idInstrutor, formacao, dtAdmissao, valSalario) VALUES(?, ?, ?, ?)";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, query, PreparedStatement.RETURN_GENERATED_KEYS);

		try {

			stmt.setInt(1, pessoaDAO.salvar(novoInstrutor));
			stmt.setString(2, novoInstrutor.getFormacao());
			stmt.setDate(3, java.sql.Date.valueOf(novoInstrutor.getDtAdmissao()));
			stmt.setDouble(4, novoInstrutor.getValSalario());
			stmt.execute();

		} catch (SQLException e) {

			System.out.println("Erro ao cadastrar instrutor. \nErro: " + e.getMessage());

		}

		return novoInstrutor;
	}

	// Excluir Instrutor:
	public int excluir(int id) {

		int resultado = 0;
		pessoaDAO.excluir(id);

		Connection conn = Banco.getConnection();
		String query = "DELETE FROM INSTRUTOR WHERE idInstrutor = " + id;
		Statement stmt = Banco.getStatement(conn);

		try {

			resultado = stmt.executeUpdate(query);

		} catch (SQLException e) {

			System.out.println("Erro ao excluir Instrutor. \nErro: " + e.getMessage());

		} finally {
			Banco.closeConnection(conn);
			Banco.closeStatement(stmt);
		}

		return resultado;

	}

	public boolean existeInstrutorPorId(int id) {

		Connection conn = Banco.getConnection();
		String query = "SELECT idInstrutor FROM INSTRUTOR WHERE IdInstrutor = " + id;
		Statement stmt = Banco.getStatement(conn);
		ResultSet rs = null;

		try {

			rs = stmt.executeQuery(query);
			if (rs.next()) {

				return true;

			}

		} catch (SQLException e) {

			System.out.println("Erro ao verificar se existe instrutor por id. \nErro: " + e.getMessage());

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

			i.setId(rs.getInt("idInstrutor"));
			i.setNome(rs.getString("nome"));
			i.setCpf(rs.getString("cpf"));
			i.setDtNascimento(rs.getDate("dtNascimento").toLocalDate());
			i.setSexo(rs.getString("sexo"));
			i.setTelefone(rs.getString("telefone"));
			i.setCelular(rs.getString("celular"));
			i.setEmail(rs.getString("email"));
			i.setEndereco(rs.getString("endereco"));
			i.setBairro(rs.getString("bairro"));
			i.setCidade(rs.getString("cidade"));
			i.setUf(rs.getString("uf"));
			i.setCep(rs.getString("cep"));
			i.setFormacao(rs.getString("formacao"));
			i.setValSalario(rs.getDouble("valSalario"));

		} catch (SQLException e) {

			System.out.println("Erro ao construir instrutor a partir do ResultSet" + "\nErro: " + e.getMessage());

		}

		return i;

	}

	public ArrayList<InstrutorVO> consultarTodosInstrutores() {

		Connection conn = Banco.getConnection();
		String query = "SELECT * FROM instrutor i, pessoa p WHERE p.idPessoa = i.idInstrutor";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, query);
		ArrayList<InstrutorVO> instrutores = new ArrayList<InstrutorVO>();

		try {

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				InstrutorVO i = construirInstrutorDoResultSet(rs);
				instrutores.add(i);

			}

		} catch (SQLException e) {

			System.out.println("Erro ao consultar todos instrutores" + "\nErro: " + e.getMessage());

		} finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(stmt);
		}

		return instrutores;

	}

}
