package model.vo;

import java.time.LocalTime;

public class TurnoVO {

	private int id;
	private String nome;
	private LocalTime horario;
	private int quantidadeVagas;
	private AlunoVO[] alunos;
	private InstrutorVO[] instrutores;
	
	public TurnoVO(int id, String nome, LocalTime horario, int quantidadeVagas, AlunoVO[] alunos,
			InstrutorVO[] instrutores) {
		super();
		this.id = id;
		this.nome = nome;
		this.horario = horario;
		this.quantidadeVagas = quantidadeVagas;
		this.alunos = alunos;
		this.instrutores = instrutores;
	}
	public TurnoVO() {
		super();
	}
	
	public int getIdT() {
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
	public LocalTime getHorario() {
		return horario;
	}
	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}
	public int getQuantidadeVagas() {
		return quantidadeVagas;
	}
	public void setQuantidadeVagas(int quantidadeVagas) {
		this.quantidadeVagas = quantidadeVagas;
	}
	public AlunoVO[] getAlunos() {
		return alunos;
	}
	public void setAlunos(AlunoVO[] alunos) {
		this.alunos = alunos;
	}
	public InstrutorVO[] getInstrutores() {
		return instrutores;
	}
	public void setInstrutores(InstrutorVO[] instrutores) {
		this.instrutores = instrutores;
	}
	
	
}
