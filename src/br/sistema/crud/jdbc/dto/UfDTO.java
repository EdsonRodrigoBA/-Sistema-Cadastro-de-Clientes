package br.sistema.crud.jdbc.dto;

public class UfDTO {
	private Integer idUF;
	private String siglaUF;
	public Integer getIdUF() {
		return idUF;
	}
	public void setIdUF(Integer idUF) {
		this.idUF = idUF;
	}
	public String getSiglaUF() {
		return siglaUF;
	}
	public void setSiglaUF(String siglaUF) {
		this.siglaUF = siglaUF;
	}
	public String getDescricao() {
		return descrcao;
	}
	public void setDescrcao(String descrcao) {
		this.descrcao = descrcao;
	}
	private String descrcao;

}
