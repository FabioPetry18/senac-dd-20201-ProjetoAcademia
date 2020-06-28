package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.bo.AlunoBO	;
import model.bo.PessoaBO;
import model.dao.AlunoDAO;
import model.vo.AlunoVO;
import model.vo.PessoaVO;


public class AlunoController {
	
	DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	AlunoBO bo = new AlunoBO();

	public String salvar(String cpf, String nome, String dataNascimento, String sexo, String telefone,
			String celular, String endereco, String bairro, String cidade, String uf, String cep, String email, String modalidade, String observacoes) {
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

		if(mensagem == "") {
			bo.salvar(criarNovoAluno(nome, cpf, dataNascimento, sexo, telefone, celular, endereco, bairro, cidade, uf, cep, email, modalidade, observacoes));			
		}
		
		
		return mensagem;
	}
	

	public void excluir(AlunoVO aluno) {
		AlunoBO bo = new AlunoBO();
		bo.excluir(aluno);
		
	}

	  public ArrayList<AlunoVO> consultarTodosAlunos() {
		return bo.consultarTodosAlunos();
	}

	private AlunoVO criarNovoAluno(String nome, String cpf, String dataNascimento, String sexo, String telefone, String celular,
			String endereco, String bairro, String cidade, String uf, String cep, String email, String modalidade, String observacoes) {
		
		ModalidadeController controller = new ModalidadeController();
		LocalDate dtNasc = LocalDate.parse(dataNascimento, dataFormatter);
		AlunoVO vo = new AlunoVO(removerMascara(cpf), nome, dtNasc, sexo, removerMascara(telefone), removerMascara(celular), email, bairro,
				endereco, removerMascara(cep), cidade, uf, controller.consultarPorNome(modalidade),
				observacoes, LocalDate.now(), true);
		
		return vo;
	}

	private String removerMascara(String campo) {
		campo = campo.replace("(", "");
		campo = campo.replace(")", "");
		campo = campo.replace(".", "");
		campo = campo.replace("-", "");
		return campo;
	}
	
}
	

