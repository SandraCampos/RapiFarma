package com.hampcode.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.hampcode.model.entity.Pedido;
import com.hampcode.model.entity.PedidoDetalle;
import com.hampcode.model.repository.PedidoRepository;

@Named
public class PedidoBusiness implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PedidoRepository pedidoRepository;
	
	@Transactional
	public Long registrar(Pedido pedido) throws Exception{
		
		pedido.getPedidoDetalle().forEach(item ->
		item.setPedido(pedido));
		
		return this.pedidoRepository.registrar(pedido);
	}
	
	@Transactional
	public Long modificar(Pedido pedido) throws Exception{
		return this.pedidoRepository.modificar(pedido);
	}	
	
	@Transactional
	public Long eliminar(Pedido pedido) throws Exception{
		return this.pedidoRepository.eliminar(pedido);
	}
	
	public List<Pedido> listarTodo() throws Exception{
		return this.pedidoRepository.listarTodo();
	}
	
	public List<PedidoDetalle> listarPedidoDetalle(Pedido pedido) throws Exception{
		return this.pedidoRepository.listarPedidoDetalle(pedido);
	}

}