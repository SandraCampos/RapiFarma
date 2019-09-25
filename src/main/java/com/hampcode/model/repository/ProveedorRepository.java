package com.hampcode.model.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.hampcode.model.entity.Proveedor;

@Named
public class ProveedorRepository implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "pwPU")
	private EntityManager em;
	
	public Long registrar(Proveedor proveedor) throws Exception{
		em.persist(proveedor);
		return proveedor.getCodigo();
	}
	
	public Long modificar(Proveedor proveedor) throws Exception{
		em.merge(proveedor);
		return proveedor.getCodigo();
	}
	
	public Long eliminar(Proveedor proveedor) throws Exception{
		em.remove(proveedor);
		return proveedor.getCodigo();
	}
	
	public List<Proveedor> listarTodo() throws Exception{
		TypedQuery<Proveedor> query = em.createQuery("FROM Proveedor p",
				Proveedor.class);
		return query.getResultList();
	}	
	
	public List<Proveedor> listarPorNombre(String nombre) throws Exception{
		TypedQuery<Proveedor> query = em.createQuery("FROM Proveedor p WHERE p.nombre LIKE ?1",
				Proveedor.class);
		query.setParameter(1, "%" + nombre + "%");		
		return query.getResultList();
	}
}






