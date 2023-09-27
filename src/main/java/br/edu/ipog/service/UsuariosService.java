package br.edu.ipog.service;

import java.util.ArrayList;
import java.util.List;

import br.edu.ipog.model.Usuarios;

public class UsuariosService {

	    private List<Usuarios> usuarios = new ArrayList<>();

	    public void adicionarUsuarios(Usuarios usuarios1) {
	    	usuarios.add(usuarios1);
	    }

	    public Usuarios buscarUsariosPorId(long id) {
	        for (Usuarios usuarios : usuarios) {
	            if (usuarios.getId() == id) {
	                return usuarios;
	            }
	        }
	        return null;
	    }

	    public List<Usuarios> listarUsuarios() {
	        return usuarios;
	    }

	    public void atualizarUsuarios(Usuarios usuarios) {
	        Usuarios usuariosExistente = buscarUsariosPorId(usuarios.getId());
	        if (usuariosExistente != null) {
	        	usuariosExistente.setLogin(usuarios.getLogin());
	        	usuariosExistente.setEmail(usuarios.getEmail());
	        	usuariosExistente.setSenha(usuarios.getSenha());
       	    	usuariosExistente.setTipo(usuarios.getTipo());
	        	usuariosExistente.setStatus(usuarios.getStatus());
	        }
	    }

	    public void excluirUsuarios(long id) {
	    	Usuarios usuariosExistente = buscarUsariosPorId(id);
	        if (usuariosExistente != null) {
	        	usuarios.remove(usuariosExistente);	        	
	        }
	    }
}
