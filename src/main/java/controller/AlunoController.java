package controller;

import java.util.ArrayList;

import model.bo.AlunoBO	;
import model.bo.PessoaBO;
import model.dao.AlunoDAO;
import model.vo.AlunoVO;
import model.vo.PessoaVO;


public class AlunoController {

	AlunoBO bo = new AlunoBO();

	public String salvar(String cpf, String nome, String dataNascimento, String telefone,
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
	
	public void excluir(AlunoVO aluno) {
		AlunoBO bo = new AlunoBO();
		bo.excluir(aluno);
		
	}

	  public ArrayList<AlunoVO> consultarTodosAlunos(AlunoVO aluno) {
		// TODO Auto-generated method stub
		 AlunoBO bo = new AlunoBO();
	     ArrayList<AlunoVO> alunos = new ArrayList<AlunoVO>();
		bo.consultarTodosAlunos(aluno);
		
		return alunos;
	}

	public ArrayList<AlunoVO> consultarTodosAlunos(ArrayList<AlunoVO> alunos) {
		// TODO Auto-generated method stub
		return null;
	}


}
	

