package model.vo;

public class AlunoVO {
	
private ModalidadeAluno modalidadeAluno;
private String observacoes;
private String dtMatricula;
private int numMatricula;
private boolean situacao;  //true pra ATIVO e false pra INATIVO
private String dataCancelamento; //data que cancelou matricula na academia.

public static void checarProfessor() {
	
}

public static void checarHorario() {
	
}

public static void trocarModalidade() {
	
}

public static void editarAluno() {
	
}

public static void deletarAluno() {
	
}
public static void gerarPlanilha() {
	
}

public AlunoVO() {
	super();
}
public AlunoVO(ModalidadeAluno modalidadeAluno, String observacoes, String dtMatricula, int numMatricula,
		boolean situacao, String dataCancelamento) {
	super();
	this.modalidadeAluno = modalidadeAluno;
	this.observacoes = observacoes;
	this.dtMatricula = dtMatricula;
	this.numMatricula = numMatricula;
	this.situacao = situacao;
	this.dataCancelamento = dataCancelamento;
}
public ModalidadeAluno getModalidadeAluno() {
	return modalidadeAluno;
}
public void setModalidadeAluno(ModalidadeAluno modalidadeAluno) {
	this.modalidadeAluno = modalidadeAluno;
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


}
