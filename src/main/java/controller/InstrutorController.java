package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.bo.InstrutorBO;
import model.dao.InstrutorDAO;
import model.vo.InstrutorVO;

public class InstrutorController extends PessoaController{
	
	DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	InstrutorBO bo = new InstrutorBO();

	public String cadastrarInstrutor(String cpf, String nome, String dataNascimento, String sexo, 
			String telefone, String celular, String endereco, String bairro, String cidade, 
			String uf, String cep, String email, String modalidade, String formacao, String salario) {
		
		String mensagem = validarCampos(cpf, nome, dataNascimento, sexo, telefone, celular, 
				endereco, bairro, cidade, uf, cep, email);
		
		Double sal = 0.0;
		try {
			sal = Double.parseDouble(salario);
		} catch (NumberFormatException e) {
			mensagem += "Salário deve conter apenas números";
		}
		
		if(mensagem == "") {
			mensagem = bo.salvar(criarNovoInstrutor(cpf, nome, dataNascimento, sexo, telefone, celular, endereco,
					bairro, cidade, uf, cep, email, modalidade, formacao, sal));
		}
		
		return mensagem;
	}


	public ArrayList<InstrutorVO> listarInstrutores() {
		return bo.consultarTodosInstrutores();
	}
	
	private InstrutorVO criarNovoInstrutor(String cpf, String nome, String dataNascimento, String sexo, String telefone,
			String celular, String endereco, String bairro, String cidade, String uf, String cep, String email,
			String modalidade, String formacao, Double salario) {
		
		ModalidadeController controller = new ModalidadeController();
		LocalDate dtNasc = LocalDate.parse(dataNascimento, dataFormatter);
		
		InstrutorVO vo = new InstrutorVO(removerMascara(cpf), nome, dtNasc, sexo, removerMascara(telefone), removerMascara(celular),
				email, bairro, endereco, removerMascara(cep), cidade, uf, controller.consultarPorNome(modalidade),
				formacao, LocalDate.now(), salario);
		
		return vo;
	}
	
	public void excluir(InstrutorVO instrutor) {
		InstrutorBO bo = new InstrutorBO();
		bo.excluir(instrutor);
	}

}
