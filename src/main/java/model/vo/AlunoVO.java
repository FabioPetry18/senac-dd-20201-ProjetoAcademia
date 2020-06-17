package model.vo;

public class AlunoVO extends PessoaVO {
	
	private String observacoes;
	private String dtMatricula;
	private int numMatricula;
	private boolean situacao; // true pra ATIVO e false pra INATIVO
	private String dataCancelamento; // data que cancelou matricula na academia.


	public AlunoVO() {
		super();
	}

	public AlunoVO(String cpf, String nome, int idade, String telefone, String celular, String email, String bairro,
			String cep, String atuacao, String modalidade, String observacoes, String dtMatricula,
			int numMatricula, boolean situacao, String dataCancelamento) {
		super(cpf, nome, idade, telefone, celular, email, bairro, cep, atuacao, modalidade);
		this.observacoes = observacoes;
		this.dtMatricula = dtMatricula;
		this.numMatricula = numMatricula;
		this.situacao = situacao;
		this.dataCancelamento = dataCancelamento;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
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

	public static void checarProfessor() {
		
	}
	
	public static void checarHorario() {
		
	}
	
	public static void trocarModalidade() {
		
	}
	
}
