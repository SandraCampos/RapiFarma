package com.hampcode.model.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.hampcode.model.entity.Pedido;
import com.hampcode.model.entity.PedidoDetalle;

@Named
public class PedidoRepository implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "pwPU")
	private EntityManager em;
	
	public Long registrar(Pedido pedido) throws Exception{
		this.em.persist(pedido);
		return pedido.getCodigo();
	}
	
	public Long modificar(Pedido pedido) throws Exception{
		this.em.merge(pedido);
		return pedido.getCodigo();
	}	
	
	public Long eliminar(Pedido pedido) throws Exception{
		this.em.remove(pedido);
		return pedido.getCodigo();
	}
	
	public List<Pedido> listarTodo() throws Exception{
		TypedQuery<Pedido> query = this.em.createQuery("FROM Pedido p",
				Pedido.class);
	
		return query.getResultList();
	}
		
	public List<PedidoDetalle> listarPedidoDetalle(Pedido pedido) throws Exception{
		TypedQuery<PedidoDetalle> query = this.em.createQuery("FROM PedidoDetalle pd WHERE pd.pedido = ?1",
				PedidoDetalle.class);
		query.setParameter(1, pedido);
		return query.getResultList();
	}

}