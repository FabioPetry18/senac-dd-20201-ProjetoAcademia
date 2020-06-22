package model.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import model.vo.TurnoVO;
import model.dao.Banco;

public class TurnoDAO {
	
	public TurnoVO cadastrarTurno(TurnoVO novoTurno) {	
		
		Connection conn = Banco.getConnection();
		String sql = "INSERT INTO TURNO(nome, horario, quantidadeVagas, idAluno, idInstrutor) VALUES(?, ?, ?, ?, ?)";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql, PreparedStatement.RETURN_GENERATED_KEYS);
		
		try {
			
			stmt.setString(1, novoTurno.getNome());
			stmt.setTime(2, java.sql.Time.valueOf(novoTurno.getHorario()));
			stmt.setInt(3, novoTurno.getQuantidadeVagas());
			
			ResultSet rs = stmt.getGeneratedKeys();
			
			if(rs.next()) {
				int idGerado = rs.getInt(1);
				novoTurno.setId(idGerado);
			}
			
			
		} catch(SQLException e) {
			
			System.out.println("Erro ao criar turno."
							  +"\nErro: "+e.getMessage());
		}
		return novoTurno;
				
	}
}
