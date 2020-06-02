package model.vo;

public class Salario {
private String dataSalario;
private double valorSalario;

//a

public Salario() {
	super();
}
public Salario(String dataSalario, double valorSalario) {
	super();
	this.dataSalario = dataSalario;
	this.valorSalario = valorSalario;
}
public String getDataSalario() {
	return dataSalario;
}
public void setDataSalario(String dataSalario) {
	this.dataSalario = dataSalario;
}
public double getValorSalario() {
	return valorSalario;
}
public void setValorSalario(double valorSalario) {
	this.valorSalario = valorSalario;
}


}
