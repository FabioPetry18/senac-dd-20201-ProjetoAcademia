package model.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.vo.PessoaVO;
import model.dao.Banco;

public class PessoaDAO {

	public PessoaVO cadastrarPessoa (PessoaVO novaPessoa) {
		Connection conexao = Banco.getConnection();
		String sql = " INSERT INTO PESSOA(NOME, IDADE, TELEFONE, CELULAR,BAIRRO, CEP, RUA, COMPLEMENTO,  EMAIL, ATUACAO, CIDADE, ESTADO, CPF, ) "
				+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?) ";
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql, 
				PreparedStatement.RETURN_GENERATED_KEYS);
		
		try {
			
			stmt.setString(1, novaPessoa.getNome());
			stmt.setInt(2, novaPessoa.getIdade());
			stmt.setString(3, novaPessoa.getTelefone());
			stmt.setString(4, novaPessoa.getCelular());
			stmt.setString(5, novaPessoa.getBairro());
			stmt.setString(6, novaPessoa.getCep());
			stmt.setString(7, novaPessoa.getRua());		
			stmt.setString(8, novaPessoa.getComplemento());	
			stmt.setString(9, novaPessoa.getEmail());
			stmt.setString(10, novaPessoa.getAtuacao());
			stmt.setString(11, novaPessoa.getCidade());
			stmt.setString(11, novaPessoa.getEstado());
			stmt.setString(12, novaPessoa.getCpf());
		
			stmt.execute();
			
			ResultSet rs = stmt.getGeneratedKeys();
			
			if(rs.next()) {
				int idGerado = rs.getInt(1);
				novaPessoa.setId(idGerado);
			}	
			
		} catch (SQLException e) {
			System.out.println("Erro ao inserir novo cliente.");
			System.out.println("Erro: " + e.getMessage());
		}
		
		return novaPessoa;
				
		
	}

	public Boolean verificarCpf(String cpf) {
		Connection conexao = Banco.getConnection();
		String sql = " select id from cliente c " + 
				"where c.cpf = '" + cpf + "'";
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
