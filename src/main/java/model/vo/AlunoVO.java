package model.vo;

import java.time.LocalDate;

public class AlunoVO extends PessoaVO {
	
	private String observacoes;
	private LocalDate dtMatricula;
	private boolean situacao; 
	private LocalDate dtCancelamento; 
	
	public AlunoVO() {
		super();
	}

	public AlunoVO(int id, String cpf, String nome, LocalDate dtNascimento, String sexo, String telefone,
			String celular, String email, String bairro, String endereco, String cep, String cidade, String uf,
			ModalidadeVO modalidade, String observacoes, LocalDate dtMatricula, boolean situacao,
			LocalDate dtCancelamento) {
		super(id, cpf, nome, dtNascimento, sexo, telefone, celular, email, bairro, endereco, cep, cidade, uf, modalidade);
		this.observacoes = observacoes;
		this.dtMatricula = dtMatricula;
		this.situacao = situacao;
		this.dtCancelamento = dtCancelamento;
	}

	public AlunoVO(String cpf, String nome, LocalDate dtNascimento, String sexo, String telefone, String celular,
			String email, String bairro, String endereco, String cep, String cidade, String uf, ModalidadeVO modalidade,
			String observacoes, LocalDate dtMatricula, boolean situacao) {
		super(cpf, nome, dtNascimento, sexo, telefone, celular, email, bairro, endereco, cep, cidade, uf, modalidade);
		this.observacoes = observacoes;
		this.dtMatricula = dtMatricula;
		this.situacao = situacao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public LocalDate getDtMatricula() {
		return dtMatricula;
	}
	public void setDtMatricula(LocalDate dtMatricula) {
		this.dtMatricula = dtMatricula;
	}

	public boolean isSituacao() {
		return situacao;
	}
	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}
	
	public LocalDate getDtCancelamento() {
		return dtCancelamento;
	}
	public void setDtCancelamento(LocalDate dtCancelamento) {
		this.dtCancelamento = dtCancelamento;
	}
	
	
}