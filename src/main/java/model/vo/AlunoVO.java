package model.vo;

public class AlunoVO {
	
	//a
private String alunoNome;
private int alunoIdade;
private String alunoEndereco;
private String alunoBairro;
private String alunoCep;
private String alunoCelular;
private String alunoEmail;
private String alunoObservacoes;



public AlunoVO() {
	super();
}
public AlunoVO(String alunoNome, int alunoIdade, String alunoEndereco, String alunoBairro, String alunoCep,
		String alunoCelular, String alunoEmail, String alunoObservacoes) {
	super();
	this.alunoNome = alunoNome;
	this.alunoIdade = alunoIdade;
	this.alunoEndereco = alunoEndereco;
	this.alunoBairro = alunoBairro;
	this.alunoCep = alunoCep;
	this.alunoCelular = alunoCelular;
	this.alunoEmail = alunoEmail;
	this.alunoObservacoes = alunoObservacoes;
}
public String getAlunoNome() {
	return alunoNome;
}
public void setAlunoNome(String alunoNome) {
	this.alunoNome = alunoNome;
}
public int getAlunoIdade() {
	return alunoIdade;
}
public void setAlunoIdade(int alunoIdade) {
	this.alunoIdade = alunoIdade;
}
public String getAlunoEndereco() {
	return alunoEndereco;
}
public void setAlunoEndereco(String alunoEndereco) {
	this.alunoEndereco = alunoEndereco;
}
public String getAlunoBairro() {
	return alunoBairro;
}
public void setAlunoBairro(String alunoBairro) {
	this.alunoBairro = alunoBairro;
}
public String getAlunoCep() {
	return alunoCep;
}
public void setAlunoCep(String alunoCep) {
	this.alunoCep = alunoCep;
}
public String getAlunoCelular() {
	return alunoCelular;
}
public void setAlunoCelular(String alunoCelular) {
	this.alunoCelular = alunoCelular;
}
public String getAlunoEmail() {
	return alunoEmail;
}
public void setAlunoEmail(String alunoEmail) {
	this.alunoEmail = alunoEmail;
}
public String getAlunoObservacoes() {
	return alunoObservacoes;
}
public void setAlunoObservacoes(String alunoObservacoes) {
	this.alunoObservacoes = alunoObservacoes;
}







}
