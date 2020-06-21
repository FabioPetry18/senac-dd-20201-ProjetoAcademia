package controller;

import model.bo.ModalidadeBO;
import model.vo.ModalidadeVO;

public class ModalidadeController {
	
	private ModalidadeBO bo = new ModalidadeBO();

	public String cadastrarModalidade(String nome, int totalAlunos, String valorMensal) {
		
		String mensagem = "";
		double mensal = 0;
		
		try {
			mensal = Double.parseDouble(valorMensal);			
		} catch (NumberFormatException e) {
			mensagem = "A mensalidade deve ser um número";
		}
		
		if(mensagem == "") {
			ModalidadeVO novaModalidade = new ModalidadeVO(nome, totalAlunos, mensal);
			mensagem = bo.cadastrarModalidade(novaModalidade);	
		}
		
		return mensagem;
	}

}
