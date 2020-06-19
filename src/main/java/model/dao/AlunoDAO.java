package model.dao;
import java.sql.Connection	;	
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.dao.Banco;	
import model.vo.AlunoVO;
public class AlunoDAO {
/*	private String observacoes;
	private String dtMatricula;
	private int numMatricula;
	private boolean situacao; // true pra ATIVO e false pra INATIVO
	private String dataCancelamento; // data que cancelou matricula na academia.
	private String modalidade;*/


	
	public AlunoVO salvar(AlunoVO novoAluno) {
		Connection conexao = Banco.getConnection();
		String sql = " INSERT INTO ALUNO(idAluno,observacoes,dtMatricula,numMatricula,situacao,dataCancelamento,modalidade)"			 
				+" VALUES(?,?,?,?,?,?,?)";
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

	}



