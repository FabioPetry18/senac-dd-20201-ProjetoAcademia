package model.vo;

public class MensalidadeVO {

	private String dataVencimento;
	private String dataUltimoPagamento;
	private boolean estaPago;

	public MensalidadeVO(String dataVencimento, String dataUltimoPagamento, boolean estaPago) {
		super();
		this.dataVencimento = dataVencimento;
		this.dataUltimoPagamento = dataUltimoPagamento;
		this.estaPago = estaPago;
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


}
