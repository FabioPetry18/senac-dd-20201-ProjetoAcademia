package controller;

import model.bo.AlunoBO;
import model.bo.PessoaBO;
import model.vo.AlunoVO;
import model.vo.PessoaVO;

public class AlunoController {

	AlunoBO bo = new AlunoBO();

	public String cadastrarAluno(String cpf, String nome, String dataNascimento, String telefone,
			String celular, String endereco, String bairro, String cep, String email, String modalidade, String observacoes) {
		String mensagem = "";
		//validacoes dos campos
		if(bairro!= null && !bairro.isEmpty() && bairro.length()<3) {
			mensagem =("Bairro deve possuir pelo menos 3 caracteres!");
		}
		
		if(endereco!= null && !endereco.isEmpty() && endereco.length()<3) {
			mensagem =("endereco deve possuir pelo menos 3 caracteres!");
		}
		
		if(dataNascimento!= null && !dataNascimento.isEmpty() && dataNascimento.length()!=8) {
			mensagem =("Data invalida! Preencha com o formato padrão (dd/mm/yyyy) ");
		}
			
		if(email.length()>0 && email.length()<6) {
			mensagem =("email deve possuir pelo menos 6 caracteres!");
		}
		
		return mensagem;
	}
	
	public void inserirAluno(AlunoVO a) {
		AlunoBO ABO = new AlunoBO();
		ABO.salvar(a);
	}
	
	public void deletarAluno(AlunoVO a) {
		AlunoBO ABO = new AlunoBO();
		ABO.deletar(a);
		
	}

}
	

