package controller;

import java.util.ArrayList;

import model.bo.ModalidadeBO;
import model.dao.ModalidadeDAO;
import model.vo.ModalidadeVO;

public class ModalidadeController {
	
	private ModalidadeBO bo = new ModalidadeBO();
	private ModalidadeDAO dao = new ModalidadeDAO();

	public String cadastrarModalidade(String nome, String valorMensal) {
		
		String mensagem = "";
		double mensal = 0;
		
		if(nome.isEmpty() || valorMensal.isEmpty()) {
			mensagem = "Todos os campos devem ser preenchidos";
		} else {
			try {
				mensal = Double.parseDouble(valorMensal);	
			} catch (NumberFormatException e) {
				mensagem = "A mensalidade deve ser um número";
			}			
		}
		
		
		if(mensagem == "") {
			ModalidadeVO novaModalidade = new ModalidadeVO(nome, mensal);
			mensagem = bo.cadastrarModalidade(novaModalidade);	
		}
		
		return mensagem;
	}

	public ArrayList<String> consultarNomeModalidade() {
		ArrayList<String> listaNomes = new ArrayList<String>();
		
		for(ModalidadeVO vo : dao.consultarModalidade()) {
			listaNomes.add(vo.getNome());
		}
		
		return listaNomes;		
	}
	
	public ModalidadeVO consultarPorNome(String nome) {		
		return bo.consultarPorNome(nome);
	}

}
