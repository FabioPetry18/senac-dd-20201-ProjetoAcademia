package model.bo;

import model.dao.AlunoDAO;
import model.vo.AlunoVO;

public class AlunoBO {

	
	AlunoDAO DAO= new AlunoDAO();
	public String salvar(AlunoVO alunoVO) {
	
		String mensagem = "";

	if (DAO.verificarCpf(alunoVO.getCpf())) {
			mensagem = "CPF informado (" + alunoVO.getCpf() + ") já foi utilizado";
		} else {
			alunoVO = DAO.salvar(alunoVO);
			mensagem = "Cadastro realizado com sucesso!";

		}
	return mensagem;
		


	}
	
}
