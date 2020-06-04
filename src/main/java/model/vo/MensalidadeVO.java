package model.vo;

public class MensalidadeVO {

private String dataVencimento;
private double valorMensalidade;
private String dataUltimoPagamento;
private boolean estaPago;



public static void gerarMulta() {
	
}
private static void pagarMes() {
	
}

private static void pagarSemestre() {
	
}

public MensalidadeVO() {
	super();
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
public boolean isEstaPago() {
	return estaPago;
}
public void setEstaPago(boolean estaPago) {
	this.estaPago = estaPago;
}
public MensalidadeVO(String dataVencimento, double valorMensalidade, String dataUltimoPagamento, boolean estaPago) {
	super();
	this.dataVencimento = dataVencimento;
	this.valorMensalidade = valorMensalidade;
	this.dataUltimoPagamento = dataUltimoPagamento;
	this.estaPago = estaPago;
}




}
