package model.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import model.vo.AlunoVO;
import model.vo.PessoaVO;
import model.dao.Banco;

public class PessoaDAO {

	DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	public int salvar(PessoaVO novaPessoa) {
		Connection conexao = Banco.getConnection();
		String sql = " INSERT INTO PESSOA(CPF, NOME, DTNASCIMENTO, SEXO, TELEFONE, CELULAR, EMAIL, ENDERECO, BAIRRO, CIDADE, UF, CEP, IDMODALIDADE) "
				+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?) ";
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql, 
				PreparedStatement.RETURN_GENERATED_KEYS);
		
		try {
			
			stmt.setString(1, novaPessoa.getCpf());
			stmt.setString(2, novaPessoa.getNome());
			stmt.setDate(3, java.sql.Date.valueOf(novaPessoa.getDtNascimento()));
			stmt.setString(4, novaPessoa.getSexo());
			stmt.setString(5, novaPessoa.getTelefone());
			stmt.setString(6, novaPessoa.getCelular());
			stmt.setString(7, novaPessoa.getEmail());
			stmt.setString(8, novaPessoa.getEndereco());
			stmt.setString(9, novaPessoa.getBairro());
			stmt.setString(10, novaPessoa.getCidade());
			stmt.setString(11, novaPessoa.getUf());
			stmt.setString(12, novaPessoa.getCep());		
			stmt.setInt(13, novaPessoa.getModalidade().getId());
		
			stmt.execute();
			
			ResultSet rs = stmt.getGeneratedKeys();
			
			if(rs.next()) {
				int idGerado = rs.getInt(1);
				novaPessoa.setId(idGerado);
			}	
			
		} catch (SQLException e) {
			System.out.println("Erro ao inserir pessoa.");
			System.out.println("Erro: " + e.getMessage());
		}
		
		return novaPessoa.getId();		
	}
	
	public int excluir(int id) {

		Connection conn = Banco.getConnection();
		String delete = "DELETE FROM PESSOA WHERE idPessoa = " + id;
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;

		try {

			resultado = stmt.executeUpdate(delete);

		} catch (SQLException e) {

			System.out.println("Erro ao excluir pessoa. \nErro: " + e.getMessage());

		} finally {

			Banco.closeConnection(conn);
			Banco.closeStatement(stmt);

		}

		return resultado;
	}

	public Boolean verificarCpf(String cpf) {
		Connection conexao = Banco.getConnection();
		String sql = " select idPessoa from pessoa p " + 
				"where p.cpf = '" + cpf + "'";
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);
		boolean cpfUsado = false;
		
		try {
			ResultSet rs = stmt.executeQuery();
			cpfUsado = rs.next();
		} catch (SQLException e) {
			System.out.println("Erro ao verificar se CPF já foi usado. Causa: " + e.getMessage());
		}
		
		return cpfUsado;
		
	}

	public void alterar(PessoaVO pessoa) {

		Connection conn = Banco.getConnection();
		String query = "UPDATE PESSOA "
				+ "SET cpf = ?, nome = ?, dtNascimento = ?, sexo = ?, telefone = ?, celular = ?, "
				+ "email = ?, endereco = ?, bairro = ?, cidade = ?, uf = ?, cep = ?, idModalidade = ? "
				+ "WHERE idPessoa = ?";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, query);
		int registrosAlterados = 0;

		try {

			stmt.setString(1, pessoa.getCpf());
			stmt.setString(2, pessoa.getNome());
			stmt.setDate(3, java.sql.Date.valueOf(pessoa.getDtNascimento()));
			stmt.setString(4, pessoa.getSexo());
			stmt.setString(5, pessoa.getTelefone());
			stmt.setString(6, pessoa.getCelular());
			stmt.setString(7, pessoa.getEmail());
			stmt.setString(8, pessoa.getEndereco());
			stmt.setString(9, pessoa.getBairro());
			stmt.setString(10, pessoa.getCidade());
			stmt.setString(11, pessoa.getUf());
			stmt.setString(12, pessoa.getCep());		
			stmt.setInt(13, pessoa.getModalidade().getId());
						
			stmt.setInt(14, pessoa.getId());
			registrosAlterados = stmt.executeUpdate();

		} catch (SQLException e) {

			System.out.println("Erro ao alterar informaçoes do aluno" + "\nErro: " + e.getMessage());
		}

		boolean alterado = registrosAlterados > 0;
	}

	
}
