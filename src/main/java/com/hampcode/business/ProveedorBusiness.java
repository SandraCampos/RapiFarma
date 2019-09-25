package com.hampcode.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import javax.transaction.Transactional;

import com.hampcode.model.entity.Proveedor;
import com.hampcode.model.repository.ProveedorRepository;

@Named
public class ProveedorBusiness implements Serializable{

private static final long serialVersionUID = 1L;
	
	@Inject
	private ProveedorRepository proveedorRepository;
	
	@Transactional
	public Long registrar(Proveedor laboratorio) throws Exception{
		return this.proveedorRepository.registrar(laboratorio);
	}
	
	@Transactional
	public Long modificar(Proveedor laboratorio) throws Exception{
		return this.proveedorRepository.modificar(laboratorio);
	}
	
	@Transactional
	public Long eliminar(Proveedor laboratorio) throws Exception{
		return this.proveedorRepository.eliminar(laboratorio);
	}
	
	public List<Proveedor> listarTodo() throws Exception{
		return this.proveedorRepository.listarTodo();
	}
	
	public List<Proveedor> listarPorNombre(String nombre) throws Exception{
		return this.proveedorRepository.listarPorNombre(nombre);
	}
	
}
