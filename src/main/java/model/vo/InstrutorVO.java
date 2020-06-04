package model.vo;

public class InstrutorVO extends PessoaVO{


private String observacoes;
private double salario;

public static void checarAlunos(){
	
}
public static void checarHorario(){
	
}




public InstrutorVO() {
	super();
}
public InstrutorVO(String observacoes,double salario) {
	super();

	this.observacoes = observacoes;
	this.salario = salario;
}



public InstrutorVO(double salario) {
	super();
	this.salario = salario;
}

public String getObservacoes() {
	return observacoes;
}
public void setObservacoes(String observacoes) {
	this.observacoes = observacoes;
}
public double getSalario() {
	return salario;
}
public void setSalario(double salario) {
	this.salario = salario;
}


}