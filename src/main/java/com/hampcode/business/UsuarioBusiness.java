package com.hampcode.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.hampcode.model.entity.Usuario;
import com.hampcode.model.repository.UsuarioRepository;

@Named
public class UsuarioBusiness implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioRepository usuarioRepository;
	
	@Transactional
	public Long registrar(Usuario usuario) throws Exception{		
		return this.usuarioRepository.registrar(usuario);
	}
	
	@Transactional
	public Long modificar(Usuario usuario) throws Exception{
		return this.usuarioRepository.modificar(usuario);
	}
	
	public List<Usuario> listarTodo() throws Exception{
		return this.usuarioRepository.listarTodo();
	}

	public boolean usuarioCredenciales(String usuario, String clave) throws Exception{
		return this.usuarioRepository.usuarioCredenciales(usuario, clave);
	}
}
