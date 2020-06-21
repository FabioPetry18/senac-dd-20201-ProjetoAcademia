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
	public InstrutorVO(int id, String cpf, String nome, int idade, char sexo, String telefone, String celular,
			String email, String bairro, String rua, String cep, String cidade, String estado, String complemento,
			String atuacao, String formacao, LocalDate dtAdmissao, LocalDate dtPagamento, float valSalario) {
		super(id, cpf, nome, idade, sexo, telefone, celular, email, bairro, rua, cep, cidade, estado, complemento, atuacao);
		this.formacao = formacao;
		this.dtAdmissao = dtAdmissao;
		this.dtPagamento = dtPagamento;
		this.valSalario = valSalario;
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