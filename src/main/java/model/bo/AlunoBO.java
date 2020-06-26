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
			alunoVO = DAO.cadastrarAluno(alunoVO);
			mensagem = "Cadastro realizado com sucesso!";

		}
	return mensagem;
	}
	
	
	public boolean excluir(AlunoVO aluno) {
		AlunoDAO alunoDAO = new AlunoDAO();
		
		if(alunoDAO.existeAlunoPorId(aluno.getId()) == true) {
			
				System.out.println("\nUsuario excluído com sucesso.");
				
		}else if(alunoDAO.existeAlunoPorId(aluno.getId()) == false ){
			
				System.out.println("\nNão foi possível excluir o Usuário");
	
		}else {
			
			System.out.println("\nUsuário não existe na base da dados.");
			
		}
		
		return false;
		
	}

}
