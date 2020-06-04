package model.vo;


public class PessoaVO {

protected String nome;
protected int idade;
protected String telefone;
protected String celuar;
protected String endereco;
protected String bairro;
protected String cep;
protected String email;
protected Atuacao atuacao;
protected Modalidade modalidade;


public static void realizarCadastro(){
	
}


public PessoaVO() {
	super();
}
public PessoaVO(String nome, int idade, String telefone, String celuar, String endereco, String bairro, String cep,
		String email, Atuacao atuacao) {
	super();
	this.nome = nome;
	this.idade = idade;
	this.telefone = telefone;
	this.celuar = celuar;
	this.endereco = endereco;
	this.bairro = bairro;
	this.cep = cep;
	this.email = email;
	this.atuacao = atuacao;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public int getIdade() {
	return idade;
}
public void setIdade(int idade) {
	this.idade = idade;
}
public String getTelefone() {
	return telefone;
}
public void setTelefone(String telefone) {
	this.telefone = telefone;
}
public String getCeluar() {
	return celuar;
}
public void setCeluar(String celuar) {
	this.celuar = celuar;
}
public String getEndereco() {
	return endereco;
}
public void setEndereco(String endereco) {
	this.endereco = endereco;
}
public String getBairro() {
	return bairro;
}
public void setBairro(String bairro) {
	this.bairro = bairro;
}
public String getCep() {
	return cep;
}
public void setCep(String cep) {
	this.cep = cep;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Atuacao getAtuacao() {
	return atuacao;
}
public void setAtuacao(Atuacao atuacao) {
	this.atuacao = atuacao;
}



}
