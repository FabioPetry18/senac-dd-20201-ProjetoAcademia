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
	
	public boolean excluir(InstrutorVO instrutor) {
		
		InstrutorDAO dao = new InstrutorDAO();
		boolean result = true;
		if(dao.existeInstrutorPrId(instrutor.getId()) == true) {
			System.out.println("\nInstrutor excluído com sucesso.");
			result = true;
		}else if(dao.existeInstrutorPrId(instrutor.getId()) == false){
			System.out.println("\nNão foi possível excluir o Instrutor.");
			result = false;
		}
		return result;
	}
	
}
