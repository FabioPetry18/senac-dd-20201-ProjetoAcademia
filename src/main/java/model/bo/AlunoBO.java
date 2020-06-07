package model.bo;

import model.dao.AlunoDAO;
import model.vo.AlunoVO;

public class AlunoBO {

	AlunoDAO dao = new AlunoDAO();
	
//	public String salvar(AlunoVO aluno) {
//		String mensagem = "";

//		if (dao.verificarCpf(aluno.getCpf())) {
//			mensagem = "CPF informado (" + aluno.getCpf() + ") já foi utilizado";
//		} else {
//			aluno = dao.salvar(aluno);
//			mensagem = "Cadastro realizado com sucesso!";
//
//		}
//		return mensagem;
//	}
	
}
