package model.vo;

public class ModalidadeVO {
	
	private int id;
	private String nome;
	private double valorMensal;
	
	public ModalidadeVO(String nome, int id, double valorMensal) {
		super();
		this.id = id;
		this.nome = nome;
		this.valorMensal = valorMensal;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValorMensal() {
		return valorMensal;
	}

	public void setValorMensal(double valorMensal) {
		this.valorMensal = valorMensal;
	}
	
}
