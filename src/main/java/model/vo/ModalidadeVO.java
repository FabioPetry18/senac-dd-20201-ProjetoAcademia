package model.vo;

public class ModalidadeVO {
	
	private int id;
	private String nome;
	private int numeroAlunos;
	private double valorMensal;
	
	public ModalidadeVO(int id, String nome, int numeroAlunos, double valorMensal) {
		super();
		this.id = id;
		this.nome = nome;
		this.numeroAlunos = numeroAlunos;
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

	public int getNumeroAlunos() {
		return numeroAlunos;
	}

	public void setNumeroAlunos(int numeroAlunos) {
		this.numeroAlunos = numeroAlunos;
	}

	public double getValorMensal() {
		return valorMensal;
	}

	public void setValorMensal(double valorMensal) {
		this.valorMensal = valorMensal;
	}
	
}
