package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.bo.AlunoBO	;
import model.bo.PessoaBO;
import model.dao.AlunoDAO;
import model.vo.AlunoVO;
import model.vo.PessoaVO;


public class AlunoController extends PessoaController{
	
	DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	AlunoBO bo = new AlunoBO();

	public String salvar(String cpf, String nome, String dataNascimento, String sexo, String telefone,
			String celular, String endereco, String bairro, String cidade, String uf, String cep, String email, String modalidade, String observacoes) {
		
		String mensagem = validarCampos(cpf, nome, dataNascimento, sexo, telefone, celular, 
				endereco, bairro, cidade, uf, cep, email);

		if(mensagem == "") {
			mensagem = bo.salvar(criarNovoAluno(nome, cpf, dataNascimento, sexo, telefone, celular,
					endereco, bairro, cidade, uf, cep, email, modalidade, observacoes));			
		}
		
		
		return mensagem;
	}
	

	public String excluir(String idSelecionado) {
		
		String mensagem = "";
		int id = 0;
		
		try {
			
			id = Integer.parseInt(idSelecionado);
			
		} catch (NumberFormatException e) {
			mensagem = "Insira um número inteiro";
		}
		
		if (mensagem == "") {
			mensagem = bo.excluir(id);
		}
		
		return mensagem;		
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


	public AlunoVO verificarAlunoPorCpf(String cpfInformado) {
		String cpf = removerMascara(cpfInformado);
		return bo.verificarAlunoPorCpf(cpf);
	}


	public String alterar(int id, String cpf, String nome, String dataNascimento, String sexo, String telefone,
			String celular, String endereco, String bairro, String cidade, String uf, String cep, String email, String modalidade, String observacoes) {

		String mensagem = validarCampos(cpf, nome, dataNascimento, sexo, telefone, celular, 
				endereco, bairro, cidade, uf, cep, email);
		
		if(mensagem == "") {
			AlunoVO aluno = criarNovoAluno(nome, cpf, dataNascimento, sexo, telefone, celular,
					endereco, bairro, cidade, uf, cep, email, modalidade, observacoes);
			aluno.setId(id);
			mensagem = bo.alterar(aluno);			
		}
		
		return mensagem;
	}
	
}
	

