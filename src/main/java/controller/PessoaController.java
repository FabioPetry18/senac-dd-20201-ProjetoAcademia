package controller;

public class PessoaController {

	public String validarCampos(String cpf, String nome, String dataNascimento, String sexo, String telefone,
			String celular, String endereco, String bairro, String cidade, String uf, String cep, String email) {
		
		String mensagem = "";
		
		if(bairro!= null && !bairro.isEmpty() && bairro.length()<5 || bairro.length()>225) {
			mensagem += ("Bairro deve possuir pelo menos 3 caracteres e no máximo 255 caracteres!");
		}
		
		if(endereco!= null && !endereco.isEmpty() && endereco.length()<5 || endereco.length()>255) {
			mensagem += ("\nErro ao cadastrar endereco! Preencha com RUA,Numero da sua!");
		}
		
		if(dataNascimento!= null && !dataNascimento.isEmpty() && dataNascimento.length()!=10) {
			mensagem += ("\nData invalida! Preencha com o formato padrão (dd/mm/yyyy) ");
		}
			
		if(email.length()>0 && email.length()<6 || email.length()>255) {
			mensagem += ("\nErro ao cadastrar e-mail");
		}
		
		return mensagem;
	}
	
	public String removerMascara(String campo) {
		campo = campo.replace("(", "");
		campo = campo.replace(")", "");
		campo = campo.replace(".", "");
		campo = campo.replace("-", "");
		return campo;
	}
	

}
