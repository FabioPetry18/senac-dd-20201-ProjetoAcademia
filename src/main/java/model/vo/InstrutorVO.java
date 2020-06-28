package model.vo;

import java.time.LocalDate;

public class InstrutorVO extends PessoaVO {


	public String formacao;
	private LocalDate dtAdmissao;
	private float valSalario;
	private LocalDate dtPagamento;
	
	public InstrutorVO() {
		super();
	}

	public InstrutorVO(int id, String cpf, String nome, LocalDate dtNascimento, String sexo, String telefone,
			String celular, String email, String bairro, String endereco, String cep, String cidade, String uf,
			ModalidadeVO modalidade, String formacao, LocalDate dtAdmissao, float valSalario, LocalDate dtPagamento) {
		super(id, cpf, nome, dtNascimento, sexo, telefone, celular, email, bairro, endereco, cep, cidade, uf, modalidade);
		this.formacao = formacao;
		this.dtAdmissao = dtAdmissao;
		this.valSalario = valSalario;
		this.dtPagamento = dtPagamento;
	}

	public InstrutorVO(String cpf, String nome, LocalDate dtNascimento, String sexo, String telefone, String celular,
			String email, String bairro, String endereco, String cep, String cidade, String uf, ModalidadeVO modalidade,
			String formacao, LocalDate dtAdmissao, float valSalario, LocalDate dtPagamento) {
		super(cpf, nome, dtNascimento, sexo, telefone, celular, email, bairro, endereco, cep, cidade, uf, modalidade);
		this.formacao = formacao;
		this.dtAdmissao = dtAdmissao;
		this.valSalario = valSalario;
		this.dtPagamento = dtPagamento;
	}

	public String getFormacao() {
		return formacao;
	}
	public LocalDate getDtAdmissao() {
		return dtAdmissao;
	}
	public void setDtAdmissao(LocalDate dtAdmissao) {
		this.dtAdmissao = dtAdmissao;
	}
	public float getValSalario() {
		return valSalario;
	}
	public void setValSalario(float valSalario) {
		this.valSalario = valSalario;
	}
	public LocalDate getDtPagamento() {
		return dtPagamento;
	}
	public void setDtPagamento(LocalDate dtPagamento) {
		this.dtPagamento = dtPagamento;
	}
	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}
	
	
}