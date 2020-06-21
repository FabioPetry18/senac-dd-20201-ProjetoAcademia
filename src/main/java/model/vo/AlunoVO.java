package model.vo;

import java.time.LocalDate;

public class AlunoVO extends PessoaVO {
	
	private String observacoes;
	private LocalDate dtMatricula;
	private int matricula;
	private boolean situacao; // Y - ATIVO F- INATIVO
	private LocalDate dtCancelamento; // data que cancelou matricula na academia.
	private ModalidadeVO modalidade;
	
	public AlunoVO() {
		super();
	}
	public AlunoVO(int id, String cpf, String nome, int idade, char sexo, String telefone, String celular, String email,
			String bairro, String rua, String cep, String cidade, String estado, String complemento, String atuacao, String observacoes, LocalDate dtMatricula, int matricula, boolean situacao,
			LocalDate dtCancelamento, ModalidadeVO modalidade) {
		super(id, cpf, nome, idade, sexo, telefone, celular, email, bairro, rua, cep, cidade, estado, complemento, atuacao);
		this.observacoes = observacoes;
		this.dtMatricula = dtMatricula;
		this.matricula = matricula;
		this.situacao = situacao;
		this.dtCancelamento = dtCancelamento;
		this.modalidade = modalidade;
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
	
	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
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

	public ModalidadeVO getModalidade() {
		return modalidade;
	}

	public void setModalidade(ModalidadeVO modalidade) {
		this.modalidade = modalidade;
	}
	
	
}