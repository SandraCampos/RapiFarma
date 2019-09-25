package com.hampcode.model.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.hampcode.model.entity.Categoria;

@Named
public class CategoriaRepository implements Serializable{

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName="pwPU")
	private EntityManager em;
	
	public Long registrar(Categoria categoria) throws Exception{
		this.em.persist(categoria);
		return categoria.getCodigo();
	}
	
	public Long modificar(Categoria categoria) throws Exception{
		this.em.merge(categoria);
		return categoria.getCodigo();
	}
	
	public Long eliminar(Categoria categoria) throws Exception{
		this.em.remove(categoria);
		return categoria.getCodigo();
	}
	
	public List<Categoria> listarTodo() throws Exception{
		TypedQuery<Categoria> query = this.em.createQuery("FROM Categoria c",
				Categoria.class);
		return query.getResultList();
	}
}