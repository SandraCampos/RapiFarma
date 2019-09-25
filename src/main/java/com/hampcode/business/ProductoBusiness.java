package com.hampcode.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.hampcode.model.entity.Producto;
import com.hampcode.model.repository.ProductoRepository;

@Named
public class ProductoBusiness implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private ProductoRepository productoRepository;
	
	@Transactional
	public String registrar(Producto producto) throws Exception{
		return this.productoRepository.registrar(producto);
	}
	
	public List<Producto> listarTodo() throws Exception{
		return this.productoRepository.listarTodo();
	}
	
	public boolean productoExiste(Producto producto) throws Exception{
		return this.productoRepository.productoExiste(producto);		
	}	
	
	public List<Producto> listarPorNombre(String nombre) throws Exception{
		return this.productoRepository.listarPorNombre(nombre);
	}
	
	public List<Producto> listarPorStockMinimo(int stock_minimo) throws Exception{
		return this.productoRepository.listarPorStockMinimo(stock_minimo);
	}
}
