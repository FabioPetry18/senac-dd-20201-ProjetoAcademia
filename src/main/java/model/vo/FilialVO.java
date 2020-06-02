package model.vo;

public class FilialVO {
	private String filialNome;
	private String filialEndereco;
	private String filialBairro;
	private String filialCep;
	private String filialTelefone;

	//a

	public FilialVO() {
		super();
	}
	public FilialVO(String filialNome, String filialEndereco, String filialBairro, String filialCep,
			String filialTelefone) {
		super();
		this.filialNome = filialNome;
		this.filialEndereco = filialEndereco;
		this.filialBairro = filialBairro;
		this.filialCep = filialCep;
		this.filialTelefone = filialTelefone;
	}
	public String getFilialNome() {
		return filialNome;
	}
	public void setFilialNome(String filialNome) {
		this.filialNome = filialNome;
	}
	public String getFilialEndereco() {
		return filialEndereco;
	}
	public void setFilialEndereco(String filialEndereco) {
		this.filialEndereco = filialEndereco;
	}
	public String getFilialBairro() {
		return filialBairro;
	}
	public void setFilialBairro(String filialBairro) {
		this.filialBairro = filialBairro;
	}
	public String getFilialCep() {
		return filialCep;
	}
	public void setFilialCep(String filialCep) {
		this.filialCep = filialCep;
	}
	public String getFilialTelefone() {
		return filialTelefone;
	}
	public void setFilialTelefone(String filialTelefone) {
		this.filialTelefone = filialTelefone;
	}

}
