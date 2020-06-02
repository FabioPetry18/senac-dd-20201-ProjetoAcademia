package model.vo;

public class ProfessorVO {

private String professorNome;
private String professorTelefone;
private String professorCelular;
private String professorEmail;


public ProfessorVO() {
	super();
}



public ProfessorVO(String professorNome, String professorTelefone, String professorCelular, String professorEmail) {
	super();
	this.professorNome = professorNome;
	this.professorTelefone = professorTelefone;
	this.professorCelular = professorCelular;
	this.professorEmail = professorEmail;
}



public String getProfessorNome() {
	return professorNome;
}



public void setProfessorNome(String professorNome) {
	this.professorNome = professorNome;
}



public String getProfessorTelefone() {
	return professorTelefone;
}



public void setProfessorTelefone(String professorTelefone) {
	this.professorTelefone = professorTelefone;
}



public String getProfessorCelular() {
	return professorCelular;
}



public void setProfessorCelular(String professorCelular) {
	this.professorCelular = professorCelular;
}



public String getProfessorEmail() {
	return professorEmail;
}



public void setProfessorEmail(String professorEmail) {
	this.professorEmail = professorEmail;
}


	
}
