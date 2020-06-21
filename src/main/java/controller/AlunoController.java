package controller;

import model.bo.AlunoBO	;
import model.bo.PessoaBO;
import model.vo.AlunoVO;
import model.vo.PessoaVO;


public class AlunoController {

	AlunoBO bo = new AlunoBO();

	public String cadastrarAluno(String cpf, String nome, String dataNascimento, String telefone,
			String celular, String endereco, String bairro, String cep, String email, String modalidade, String observacoes) {
		String mensagem = "";
		//validacoes dos campos
		if(bairro!= null && !bairro.isEmpty() && bairro.length()<5 || bairro.length()>225) {
			mensagem =("Bairro deve possuir pelo menos 3 caracteres e no máximo 255 caracteres!");
		}
		
		if(endereco!= null && !endereco.isEmpty() && endereco.length()<5 || endereco.length()>255) {
			mensagem =("Erro ao cadastrar endereco! Preencha com RUA,Numero da sua!");
		}
		
		if(dataNascimento!= null && !dataNascimento.isEmpty() && dataNascimento.length()!=10) {
			mensagem =("Data invalida! Preencha com o formato padrão (dd/mm/yyyy) ");
		}
			
		if(email.length()>0 && email.length()<6 || email.length()>255) {
			mensagem =("Erro ao cadastrar e-mail");
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
	

