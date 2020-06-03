package model.vo;

public class InstrutorVO {

private ModalidadeInstrutor modalidadeInstrutor;
private String observacoes;

public static void checarAlunos(){
	
}
public static void checarHorario(){
	
}

public static void editarHorario(){
	
}

public static void editarCadastro(){
	
}

public static void deletarCadastro(){
	
}
public static void gerarPlanilha(){
	
}


public InstrutorVO() {
	super();
}
public InstrutorVO(ModalidadeInstrutor modalidadeInstrutor, String observacoes) {
	super();
	this.modalidadeInstrutor = modalidadeInstrutor;
	this.observacoes = observacoes;
}
public ModalidadeInstrutor getModalidadeInstrutor() {
	return modalidadeInstrutor;
}
public void setModalidadeInstrutor(ModalidadeInstrutor modalidadeInstrutor) {
	this.modalidadeInstrutor = modalidadeInstrutor;
}
public String getObservacoes() {
	return observacoes;
}
public void setObservacoes(String observacoes) {
	this.observacoes = observacoes;
}


}