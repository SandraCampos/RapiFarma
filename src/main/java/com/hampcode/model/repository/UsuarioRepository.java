package com.hampcode.model.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.hampcode.model.entity.Usuario;

@Named
public class UsuarioRepository implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "pwPU")
	private EntityManager em;
	
	public Long registrar(Usuario usuario) throws Exception{
		this.em.persist(usuario);
		return usuario.getCodigo();
	}
	
	public Long modificar(Usuario usuario) throws Exception{
		this.em.merge(usuario);
		return usuario.getCodigo();
	}
	
	public List<Usuario> listarTodo() throws Exception{
		TypedQuery<Usuario> query = this.em.createQuery("FROM Usuario u",
				Usuario.class);
		return query.getResultList();
	}
	
	public boolean usuarioCredenciales(String usuario, String clave) throws Exception{
		TypedQuery<Usuario> query = this.em.createQuery("FROM Usuario u WHERE u.usuario = ?1 AND u.clave = ?2 AND u.vigente = ?3",
				Usuario.class);
		query.setParameter(1, usuario);
		query.setParameter(2, clave);
		query.setParameter(3, "S");
		if(query.getResultList().isEmpty())
			return false;
		else
			return true;		
	}
}
