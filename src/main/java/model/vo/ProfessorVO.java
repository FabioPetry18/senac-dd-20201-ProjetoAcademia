package model.vo;

public class ProfessorVO extends PessoaVO {

	private String formacao;
	private double salario;


	public ProfessorVO() {
		super();
	}

	

	public ProfessorVO(String formacao, double salario) {
		super();
		this.formacao = formacao;
		this.salario = salario;
	}



	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public static void checarAlunos() {
		
	}
	
	public static void checarHorario() {
		
	}
	
}