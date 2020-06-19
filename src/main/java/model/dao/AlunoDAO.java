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

	
	public AlunoVO salvar(AlunoVO novoAluno) {
		Connection conexao = Banco.getConnection();
		String sql = " INSERT INTO ALUNO(observacoes,dtMatricula,numMatricula,situacao,dataCancelamento,modalidade)"			 
				+" VALUES(?,?,?,?,?,?)";
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql, 
				PreparedStatement.RETURN_GENERATED_KEYS);
		try {
			stmt.setString(1, novoAluno.getObservacoes());
			stmt.setString(2, novoAluno.getDtMatricula());
			stmt.setInt(3, novoAluno.getNumMatricula());
			stmt.setString(4,novoAluno.getSituacao());
			stmt.setString(5, novoAluno.getDataCancelamento());
			stmt.setString(6, novoAluno.getModalidade());
			
			stmt.execute();
			ResultSet rs = stmt.getGeneratedKeys();
			
		} catch (SQLException e) {
			System.out.println("Erro ao inserir novo Aluno.");
			System.out.println("Erro: " + e.getMessage());
		}
		
		return novoAluno;
	}

}



