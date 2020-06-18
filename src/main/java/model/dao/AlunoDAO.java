package model.dao;
import java.sql.Connection;	
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.dao.Banco;	
import model.vo.AlunoVO;
public class AlunoDAO {

	
	public AlunoVO salvar(AlunoVO novoAluno) {
		Connection conexao = Banco.getConnection();
		String sql = " INSERT INTO ALUNO(alunoNome,alunoIdade,alunoEndereco,alunoBairro,alunoCep,alunoTelefone,alunoEmail,alunoObservacoes) "			 
				+" VALUES(?,?,?,?,?,?,?,?) ";
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql, 
				PreparedStatement.RETURN_GENERATED_KEYS);
		try {
			stmt.setString(1, novoAluno.getAlunoNome());
			stmt.setInt(2, novoAluno.getAlunoIdade());
			stmt.setString(3, novoAluno.getAlunoEndereco());
			stmt.setString(4, novoAluno.getAlunoBairro());
			stmt.setString(5, novoAluno.getAlunoCep());
			stmt.setString(6, novoAluno.getAlunoTelefone());
			stmt.setString(7, novoAluno.getAlunoEmail());
			stmt.setString(8, novoAluno.getAlunoObservacoes()));
			
			stmt.execute();
			ResultSet rs = stmt.getGeneratedKeys();
			
		} catch (SQLException e) {
			System.out.println("Erro ao inserir novo Aluno.");
			System.out.println("Erro: " + e.getMessage());
		}
		
		return novoAluno;
	}

	}

