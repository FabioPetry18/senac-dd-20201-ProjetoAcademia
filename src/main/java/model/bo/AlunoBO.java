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
			mensagem = "Cadastro realizado com sucesso!";
		}
		return mensagem;
	}

	public boolean excluir(AlunoVO aluno) {
		AlunoDAO alunoDAO = new AlunoDAO();

		if (alunoDAO.existeAlunoPorId(aluno.getId()) == true) {

			System.out.println("\nUsuario excluído com sucesso.");

		} else if (alunoDAO.existeAlunoPorId(aluno.getId()) == false) {

			System.out.println("\nNão foi possível excluir o Usuário");

		} else {

			System.out.println("\nUsuário não existe na base da dados.");

		}

		return false;

	}

	public ArrayList<AlunoVO> consultarTodosAlunos() {
		ArrayList<AlunoVO> alunos = dao.consultarTodosAlunos();

		if (alunos.isEmpty()) {
			System.out.println("\nSem alunos na na base da dados.");
		}	

		return alunos;

	}

}
