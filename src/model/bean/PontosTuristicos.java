package model.bean;

public class PontosTuristicos {
	private int idPonto;
	private String nome;
	private String cidade;
	private String ingresso;
	private boolean guia;
	private boolean chuva;
	
	
	public int getIdPonto() {
		return idPonto;
	}
	public void setIdPonto(int idPonto) {
		this.idPonto = idPonto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getIngresso() {
		return ingresso;
	}
	public void setIngresso(String ingresso) {
		this.ingresso = ingresso;
	}
	public boolean isGuia() {
		return guia;
	}
	public void setGuia(boolean guia) {
		this.guia = guia;
	}
	public boolean isChuva() {
		return chuva;
	}
	public void setChuva(boolean chuva) {
		this.chuva = chuva;
	}

}
