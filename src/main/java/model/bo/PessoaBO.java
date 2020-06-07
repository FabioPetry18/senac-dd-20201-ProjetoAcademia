package model.bo;

import model.dao.PessoaDAO;
import model.vo.PessoaVO;

public class PessoaBO {
	private PessoaDAO dao = new PessoaDAO();

	public String salvar(PessoaVO pessoa) {
		String mensagem = "";

		if (dao.verificarCpf(pessoa.getCpf())) {
			mensagem = "CPF informado (" + pessoa.getCpf() + ") já foi utilizado";
		} else {
			pessoa = dao.salvar(pessoa);
			mensagem = "Cadastro realizado com sucesso!";

		}
		return mensagem;
	}
}
