package model.vo;

public class InstrutorVO extends PessoaVO {

	private String formacao;
	private double salario;


	public InstrutorVO() {
		super();
	}

	public InstrutorVO(String cpf, String nome, int idade, String telefone, String celular, String endereco,
			String bairro, String cep, String email, String atuacao, String modalidade, String formacao,
			double salario) {
		super(cpf, nome, idade, telefone, celular, endereco, bairro, cep, email, atuacao, modalidade);
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