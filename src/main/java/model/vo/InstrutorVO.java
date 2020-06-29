package model.vo;

import java.time.LocalDate;

public class InstrutorVO extends PessoaVO {

	public String formacao;
	private LocalDate dtAdmissao;
	private Double valSalario;

	public InstrutorVO() {
		super();
	}

	public InstrutorVO(int id, String cpf, String nome, LocalDate dtNascimento, String sexo, String telefone,
			String celular, String email, String bairro, String endereco, String cep, String cidade, String uf,
			ModalidadeVO modalidade, String formacao, LocalDate dtAdmissao, Double valSalario) {
		super(id, cpf, nome, dtNascimento, sexo, telefone, celular, email, bairro, endereco, cep, cidade, uf,
				modalidade);
		this.formacao = formacao;
		this.dtAdmissao = dtAdmissao;
		this.valSalario = valSalario;
	}

	public InstrutorVO(String cpf, String nome, LocalDate dtNascimento, String sexo, String telefone, String celular,
			String email, String bairro, String endereco, String cep, String cidade, String uf, ModalidadeVO modalidade,
			String formacao, LocalDate dtAdmissao, Double valSalario) {
		super(cpf, nome, dtNascimento, sexo, telefone, celular, email, bairro, endereco, cep, cidade, uf, modalidade);
		this.formacao = formacao;
		this.dtAdmissao = dtAdmissao;
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

	public Double getValSalario() {
		return valSalario;
	}

	public void setValSalario(Double valSalario) {
		this.valSalario = valSalario;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

}