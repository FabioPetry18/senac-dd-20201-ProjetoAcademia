package model.vo;

public class TurmaVO {

	private int qntVagas;
	private String horarios;

	public static void checarVagasDisp() {

	}

	public static void validarLei() { // seguindo as normas do governo de 30% durant a pandemia.

	}

	public TurmaVO() {
		super();
	}

	public TurmaVO(int qntVagas, String horarios) {
		super();
		this.qntVagas = qntVagas;
		this.horarios = horarios;
	}

	public int getQntVagas() {
		return qntVagas;
	}

	public void setQntVagas(int qntVagas) {
		this.qntVagas = qntVagas;
	}

	public String getHorarios() {
		return horarios;
	}

	public void setHorarios(String horarios) {
		this.horarios = horarios;
	}

}
