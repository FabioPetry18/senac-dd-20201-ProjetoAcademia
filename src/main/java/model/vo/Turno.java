package model.vo;

public enum Turno {
Manha("manha"), TARDE ("tarde"), NOITE("noite");
private String horario;

//classe ENUM pra escolher turno e horario desejado.

private Turno() {
}

private Turno(String horario) {
	this.horario = horario;
}

public String getHorario() {
	return horario;
}

public void setHorario(String horario) {
	this.horario = horario;
}


}
