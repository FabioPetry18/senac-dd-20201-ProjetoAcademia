package model.bo;

import java.util.ArrayList;

import model.dao.AlunoDAO;
import model.dao.PessoaDAO;
import model.vo.AlunoVO;

public class AlunoBO {

	AlunoDAO dao = new AlunoDAO();
	PessoaDAO pDAO = new PessoaDAO();

	public String salvar(AlunoVO novoAluno) {
		String mensagem = "";

		if (pDAO.verificarCpf(novoAluno.getCpf())) {
			mensagem = "CPF informado (" + novoAluno.getCpf() + ") já foi utilizado";
		} else {
			novoAluno = dao.cadastrarAluno(novoAluno);
		}
		
		if(novoAluno.getId() > 0) {
			mensagem = "Aluno cadastrado com sucesso!";
		}
		return mensagem;
	}

	public String excluir(int id) {
		
		String mensagem = "";
		
		if (mensagem == "" && dao.existeAlunoPorId(id)) {			
			dao.excluir(id);
			mensagem = "Aluno excluído com sucesso.";							
		} else {
			mensagem = "Aluno não existe na base de dados.";
		}
		
		return mensagem;		
	}

	public ArrayList<AlunoVO> consultarTodosAlunos() {
		ArrayList<AlunoVO> alunos = dao.consultarTodosAlunos();

		if (alunos.isEmpty()) {
			System.out.println("Sem alunos na base da dados.");
		}	

		return alunos;

	}

	public AlunoVO verificarAlunoPorCpf(String cpf) {
		return dao.verificarAlunoPorCpf(cpf);
	}

	public String alterar(AlunoVO aluno) {
		String mensagem = "";
		
		if(dao.alterar(aluno)) {
			mensagem = "Alterações feitas com sucesso";
		}
		
		return mensagem;
	}

}
