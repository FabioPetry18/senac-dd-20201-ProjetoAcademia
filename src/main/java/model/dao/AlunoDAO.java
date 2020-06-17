package model.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import model.vo.AlunoVO;
import model.dao.Banco;

public class AlunoDAO {
	
	public AlunoVO salvar(AlunoVO novoAluno) {
		
		Connection conn = Banco.getConnection();
		String sql = "INSERT INTO ALUNO()";
		return novoAluno;
	}
}
