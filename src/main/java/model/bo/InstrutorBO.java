package model.bo;

import java.util.ArrayList;

import model.dao.InstrutorDAO;
import model.dao.PessoaDAO;
import model.vo.InstrutorVO;

public class InstrutorBO {
	
	InstrutorDAO dao = new InstrutorDAO();
	PessoaDAO pDAO = new PessoaDAO();

	public String salvar(InstrutorVO novoInstrutor) {

		String mensagem = "";

		if (pDAO.verificarCpf(novoInstrutor.getCpf())) {
			mensagem = "CPF informado (" + novoInstrutor.getCpf() + ") já foi utilizado";
		} else {
			novoInstrutor = dao.cadastrarInstrutor(novoInstrutor);
		}
		
		if(novoInstrutor.getId() > 0) {
			mensagem = "Instrutor cadastrado com sucesso";
		}
		return mensagem;
	}

	public ArrayList<InstrutorVO> consultarTodosInstrutores() {
		ArrayList<InstrutorVO> instrutores = dao.consultarTodosInstrutores();

		if (instrutores.isEmpty()) {
			System.out.println("\nSem instrutores na na base da dados.");
		}
		return instrutores;
	}

}
