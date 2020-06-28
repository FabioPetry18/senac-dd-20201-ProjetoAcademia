package model.vo;

import java.time.LocalDate;

public abstract class PessoaVO {
	
	protected int id;
	protected String cpf;
	protected String nome;
	protected LocalDate dtNascimento;
	protected String sexo;
	protected String telefone;
	protected String celular;
	protected String email;
	protected String bairro;
	protected String endereco;
	protected String cep;
	protected String cidade;
	protected String uf;
	private ModalidadeVO modalidade;


	public PessoaVO() {
		super();
	}

	public PessoaVO(int id, String cpf, String nome, LocalDate dtNascimento, String sexo, String telefone,
			String celular, String email, String bairro, String endereco, String cep, String cidade, String uf,
			ModalidadeVO modalidade) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.dtNascimento = dtNascimento;
		this.sexo = sexo;
		this.telefone = telefone;
		this.celular = celular;
		this.email = email;
		this.bairro = bairro;
		this.endereco = endereco;
		this.cep = cep;
		this.cidade = cidade;
		this.uf = uf;
		this.modalidade = modalidade;
	}

	public PessoaVO(String cpf, String nome, LocalDate dtNascimento, String sexo, String telefone, String celular,
			String email, String bairro, String endereco, String cep, String cidade, String uf, ModalidadeVO modalidade) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.dtNascimento = dtNascimento;
		this.sexo = sexo;
		this.telefone = telefone;
		this.celular = celular;
		this.email = email;
		this.bairro = bairro;
		this.endereco = endereco;
		this.cep = cep;
		this.cidade = cidade;
		this.uf = uf;
		this.modalidade = modalidade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(LocalDate dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public ModalidadeVO getModalidade() {
		return modalidade;
	}

	public void setModalidade(ModalidadeVO modalidade) {
		this.modalidade = modalidade;
	}
	
}
