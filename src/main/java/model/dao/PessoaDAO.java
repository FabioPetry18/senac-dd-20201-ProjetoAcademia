package model.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import model.vo.PessoaVO;
import model.dao.Banco;

public class PessoaDAO {

	DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	public int salvar(PessoaVO novaPessoa) {
		Connection conexao = Banco.getConnection();
		String sql = " INSERT INTO PESSOA(CPF, NOME, DTNASCIMENTO, SEXO, TELEFONE, CELULAR, EMAIL, BAIRRO, CIDADE, UF, CEP, IDMODALIDADE) "
				+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?) ";
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
			stmt.setString(8, novaPessoa.getBairro());
			stmt.setString(9, novaPessoa.getCidade());
			stmt.setString(10, novaPessoa.getUf());
			stmt.setString(11, novaPessoa.getCep());		
			stmt.setInt(12, novaPessoa.getModalidade().getId());
		
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

	
}
