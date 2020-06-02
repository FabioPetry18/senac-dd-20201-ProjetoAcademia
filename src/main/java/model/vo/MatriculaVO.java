package model.vo;


public class MatriculaVO {
private String dtMatricula;
private int numMatricula;
private boolean situacao;
private String dataCancelamento;

//a

public MatriculaVO() {
	super();
}
public MatriculaVO(String dtMatricula, int numMatricula, boolean situacao, String dataCancelamento) {
	super();
	this.dtMatricula = dtMatricula;
	this.numMatricula = numMatricula;
	this.situacao = situacao;
	this.dataCancelamento = dataCancelamento;
}
public String getDtMatricula() {
	return dtMatricula;
}
public void setDtMatricula(String dtMatricula) {
	this.dtMatricula = dtMatricula;
}
public int getNumMatricula() {
	return numMatricula;
}
public void setNumMatricula(int numMatricula) {
	this.numMatricula = numMatricula;
}
public boolean isSituacao() {
	return situacao;
}
public void setSituacao(boolean situacao) {
	this.situacao = situacao;
}
public String getDataCancelamento() {
	return dataCancelamento;
}
public void setDataCancelamento(String dataCancelamento) {
	this.dataCancelamento = dataCancelamento;
}


}
