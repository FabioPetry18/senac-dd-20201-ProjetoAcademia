package model.bo;

import java.util.ArrayList;

import model.dao.AlunoDAO;
import model.dao.PessoaDAO;
import model.vo.AlunoVO;

public class AlunoBO {

	AlunoDAO dao = new AlunoDAO();
	PessoaDAO pDAO = new PessoaDAO();

	public String salvar(AlunoVO alunoVO) {

		String mensagem = "";

		if (pDAO.verificarCpf(alunoVO.getCpf())) {
			mensagem = "CPF informado (" + alunoVO.getCpf() + ") já foi utilizado";
		} else {
			alunoVO = dao.cadastrarAluno(alunoVO);
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
		AlunoDAO alunoDAO = new AlunoDAO();
		ArrayList<AlunoVO> alunos = dao.consultarTodosAlunos();

		if (alunos.isEmpty()) {
			System.out.println("\nSem alunos na na base da dados.");
		}
		

		return alunos;

	}

}
