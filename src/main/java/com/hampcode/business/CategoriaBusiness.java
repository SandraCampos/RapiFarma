package com.hampcode.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.hampcode.model.entity.Categoria;
import com.hampcode.model.repository.CategoriaRepository;

@Named
public class CategoriaBusiness implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Inject
	private CategoriaRepository categoriaRepository;
	
	@Transactional
	public Long registrar(Categoria categoria) throws Exception{
		return this.categoriaRepository.registrar(categoria);
	}
	
	@Transactional
	public Long modificar(Categoria categoria) throws Exception{
		return this.categoriaRepository.modificar(categoria);
	}
	
	@Transactional
	public Long eliminar(Categoria categoria) throws Exception{
		return this.categoriaRepository.eliminar(categoria);
	}
	
	public List<Categoria> listarTodo() throws Exception{
		return this.categoriaRepository.listarTodo();
	}
}
