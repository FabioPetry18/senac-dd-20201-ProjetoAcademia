package model.vo;

public class AlunoVO extends PessoaVO {
	private int idAluno;
	private String observacoes;
	private String dtMatricula;
	private int numMatricula;
	private String situacao; // Y - ATIVO F- INATIVO
	private String dataCancelamento; // data que cancelou matricula na academia.
	private String modalidade;
	
	
	
	public AlunoVO() {
		super();
	}
	public AlunoVO(int idAluno,String observacoes, String dtMatricula, int numMatricula, String situacao, String dataCancelamento,
			String modalidade) {
		super();
		this.observacoes = observacoes;
		this.dtMatricula = dtMatricula;
		this.numMatricula = numMatricula;
		this.situacao = situacao;
		this.dataCancelamento = dataCancelamento;
		this.modalidade = modalidade;
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
	public String isSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public String getDataCancelamento() {
		return dataCancelamento;
	}
	public void setDataCancelamento(String dataCancelamento) {
		this.dataCancelamento = dataCancelamento;
	}
	public String getModalidade() {
		return modalidade;
	}
	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}
	public int getIdAluno() {
		return idAluno;
	}
	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}


}