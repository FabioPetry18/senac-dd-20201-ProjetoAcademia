package model.bo;

public enum MolidadeBO {
//classe ENUM pra escolher uma das modalidades, add tambem uma opcao pra obs.caso necessario.
 MANHA("manhã"), TARDE("tarde"), NOITE("noite");	
		
private String observacoesModalide;

private MolidadeBO(String observacoesModalide) {
	this.observacoesModalide = observacoesModalide;
}

public String getObservacoesModalide() {
	return observacoesModalide;
}

public void setObservacoesModalide(String observacoesModalide) {
	this.observacoesModalide = observacoesModalide;
}

}
