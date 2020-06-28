package controller;

import java.util.ArrayList;

import model.dao.InstrutorDAO;
import model.vo.InstrutorVO;

public class InstrutorController {
	
	InstrutorDAO dao = new InstrutorDAO();

	public String cadastrarInstrutor(InstrutorVO instrutor) {
		String mensagem = "";
		
		
		return mensagem;
	}

	public String cadastrarInstrutor(String cpf, String nome, String dataNascimento, String sexo, String telefone,
			String celular, String endereco, String bairro, String cep, String email, String modalidade,
			String observacoes, String formacao, String salario) {
		String mensagem = "";
		
		return mensagem;
	}

	public ArrayList<InstrutorVO> listarInstrutores() {
		return dao.consultarTodosInstrutores();
	}

}
