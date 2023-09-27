package br.edu.ipog.model;

public class Documentos {
	private Long id;
	private String nome;
	private String nomeArmazenamento;
	private Long idGrupo;
	
	public Documentos (Long id, String nome, String nomeArmazenamento, Long idGrupo) {
		this.id = id;
		this.nome = nome;
		this.nomeArmazenamento = nomeArmazenamento;
		this.idGrupo = idGrupo;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId (Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome (String nome) {
		this.nome = nome;
	}
	
	public String getNomeArmazenamento() {
		return nomeArmazenamento;
	}

	public void setNomeArmazenamento (String nomeArmazenamento) {
		this.nomeArmazenamento = nomeArmazenamento;
	}
	
	public Long getIdGrupo () {
		return idGrupo;
	}
	
	public void setIdGrupo (Long idGrupo) {
		this.idGrupo = idGrupo;
	}
}
