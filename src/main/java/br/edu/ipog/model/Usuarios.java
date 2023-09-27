package br.edu.ipog.model;

import br.edu.ipog.exceptions.ValidationException;

public class Usuarios {
	private Long id;
	private String login;
	private String email;
	private String senha;
	private String tipo;
	private String status;
	
	public Usuarios(Long id, String login, String email, String senha, String tipo, String status) {
		
		
		if (login == null) throw new ValidationException("Login é Obrigatório");
		if (email == null) throw new ValidationException("Email é Obrigatório");
		if (senha == null) throw new ValidationException("Senha é Obrigatória");
		if (tipo == null) throw new ValidationException("Tipo é Obrigatório");
		if (status == null) throw new ValidationException("Status é Obrigatório");
		
		
		this.id = id;
		this.login = login;
		this.email = email;
		this.senha = senha;	
		this.tipo = tipo;
		this.status = status;		
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
