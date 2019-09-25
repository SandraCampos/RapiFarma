package com.hampcode.model.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.hampcode.model.entity.Producto;

@Named
public class ProductoRepository implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pwPU")
	private EntityManager em;
	
	public String registrar(Producto producto) throws Exception{
		this.em.persist(producto);
		return producto.getCodigo();
	}
	
	public String modificar(Producto producto) throws Exception{
		this.em.merge(producto);
		return producto.getCodigo();
	}
	
	public String eliminar(Producto producto) throws Exception{
		this.em.remove(producto);
		return producto.getCodigo();
	}
	
	public boolean productoExiste(Producto producto) throws Exception{
		TypedQuery<Producto> query = em.createQuery("FROM Producto p WHERE p.nombre = ?1",
				Producto.class);
		query.setParameter(1, producto.getNombre());
		
		if(query.getResultList().isEmpty())
			return false;
		else
			return true;		
	}
	
	public List<Producto> listarTodo() throws Exception{
		TypedQuery<Producto> query = em.createQuery("FROM Producto p",
				Producto.class);
		return query.getResultList();
	}
	
	public List<Producto> listarPorNombre(String nombre) throws Exception{
		TypedQuery<Producto> query = em.createQuery("FROM Producto p WHERE p.nombre LIKE ?1",
				Producto.class);
		query.setParameter(1, "%" + nombre + "%");
		return query.getResultList();
	}
	
	public List<Producto> listarPorStockMinimo(int stock_minimo) throws Exception{
		TypedQuery<Producto> query = em.createQuery("FROM Producto p WHERE p.stock_minimo <= ?1",
				Producto.class);
		query.setParameter(1, stock_minimo);
		return query.getResultList();
	}
}
