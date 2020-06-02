package model.vo;

public class TurmaVO {
private int qntVagas;
private Turno turno;


public TurmaVO() {
	super();
}
public TurmaVO(int qntVagas, Turno turno) {
	super();
	this.qntVagas = qntVagas;
	this.turno = turno;
}
public int getQntVagas() {
	return qntVagas;
}
public void setQntVagas(int qntVagas) {
	this.qntVagas = qntVagas;
}
public Turno getTurno() {
	return turno;
}
public void setTurno(Turno turno) {
	this.turno = turno;
}


}
