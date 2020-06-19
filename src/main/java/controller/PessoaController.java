package controller;

import model.bo.PessoaBO;	
import model.vo.PessoaVO;

public class PessoaController {
	
	private PessoaBO bo = new PessoaBO();

	public void salvar(String nome, String idade, String endereco, String bairro, String cep, String telefone, String celular,
			String email, String observacoes) {
		
		
	}

	public void inserirPessoa(PessoaVO p) {
		PessoaBO PBO = new PessoaBO();
		PBO.salvar(p);
	}
	

}
