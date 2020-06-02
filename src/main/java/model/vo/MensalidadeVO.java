package model.vo;

public class MensalidadeVO {

private String dataVencimento;
private double valorMensalidade;
private String dataUltimoPagamento;
private double multa;



public MensalidadeVO() {
	super();
}



public MensalidadeVO(String dataVencimento, double valorMensalidade, String dataUltimoPagamento, double multa) {
	super();
	this.dataVencimento = dataVencimento;
	this.valorMensalidade = valorMensalidade;
	this.dataUltimoPagamento = dataUltimoPagamento;
	this.multa = multa;
	//teste
	
}



public String getDataVencimento() {
	return dataVencimento;
}



public void setDataVencimento(String dataVencimento) {
	this.dataVencimento = dataVencimento;
}



public double getValorMensalidade() {
	return valorMensalidade;
}



public void setValorMensalidade(double valorMensalidade) {
	this.valorMensalidade = valorMensalidade;
}



public String getDataUltimoPagamento() {
	return dataUltimoPagamento;
}



public void setDataUltimoPagamento(String dataUltimoPagamento) {
	this.dataUltimoPagamento = dataUltimoPagamento;
}



public double getMulta() {
	return multa;
}



public void setMulta(double multa) {
	this.multa = multa;
}


}
