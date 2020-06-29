package model.bo;

import model.dao.ModalidadeDAO;
import model.vo.ModalidadeVO;

public class ModalidadeBO {
	
	private ModalidadeDAO dao = new ModalidadeDAO();

	public String cadastrarModalidade(ModalidadeVO novaModalidade) {
		String mensagem = "";
		
		novaModalidade = dao.cadastrarModalidade(novaModalidade);
		if(novaModalidade.getId() > 0) {
			mensagem = "Modalidade cadastrada com sucesso";
		}
		
		return mensagem;
	}

	public ModalidadeVO consultarPorNome(String nome) {
		return dao.consultarPorNome(nome);
	}
	

	
}
