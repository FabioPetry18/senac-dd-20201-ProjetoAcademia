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
	

