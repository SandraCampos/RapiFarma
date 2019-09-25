package com.hampcode.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.hampcode.business.CategoriaBusiness;
import com.hampcode.model.entity.Categoria;
import com.hampcode.util.Message;

@Named
@SessionScoped
public class CategoriaController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CategoriaBusiness categoriaBusiness;
	
	private List<Categoria> listaCategoria;
	private Categoria categoria;
	private Categoria categoriaSeleccionada;
	private String filtroNombre; 
	
	@PostConstruct
	public void inicializar() {
		this.categoria = new Categoria();
		this.listaCategoria = new ArrayList<Categoria>();
		this.listarCategoria();
	}
	
	public void listarCategoria() {		
		try {
			this.listaCategoria = this.categoriaBusiness.listarTodo();			
		}catch (Exception e) {
			Message.messageError("Error al cargar lista de categorias: " + e.getMessage());
		}
	}
	
	public String nuevaCategoria() {
		this.listarCategoria();
		this.limpiarVariables();
		return "/categoria/insert.xhtml";
	}
	
	public String irListaCategoria() {
		return "/categoria/lista.xhtml";
	}
	
	public String registrarCategoria() {		
		String view = "";		
		try {
			if(this.categoria.getCodigo() != null) {
				this.categoriaBusiness.modificar(this.categoria);
				Message.messageInfo("Categoria: " + this.categoria.getCodigo() + " actualizada correctamente" );
			}else {
				this.categoriaBusiness.registrar(this.categoria);
				Message.messageInfo("Categoria: " + this.categoria.getCodigo() + " registrada correctamente");
			}			
			this.listarCategoria();
			this.limpiarVariables();
			view = "/categoria/lista.xhtml";
		}catch (Exception e) {
			Message.messageError("Error categoria: " + e.getMessage());
		}
		return view;
	}
	
	public String editarCategoria() {
		String view = "";
		try {
			if(this.categoriaSeleccionada != null) {
				this.categoria = this.categoriaSeleccionada;
				view = "/categoria/update.xhtml";
			}else {
				Message.messageInfo("Debe seleccionar una categoria");
			}
		}catch (Exception e) {
			Message.messageError("Error categoria: " + e.getMessage());
		}		
		return view;
	}
	
	public void buscarCategoriaPorNombre() {
		
	}
	
	public void seleccionarCategoria(SelectEvent e) {
		this.categoriaSeleccionada = (Categoria) e.getObject();
	}
	
	public void limpiarVariables() {
		this.filtroNombre = "";
		this.categoria = new Categoria();
	}

	public List<Categoria> getListaCategoria() {
		return listaCategoria;
	}

	public void setListaCategoria(List<Categoria> listaCategoria) {
		this.listaCategoria = listaCategoria;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Categoria getCategoriaSeleccionada() {
		return categoriaSeleccionada;
	}

	public void setCategoriaSeleccionada(Categoria categoriaSeleccionada) {
		this.categoriaSeleccionada = categoriaSeleccionada;
	}

	public String getFiltroNombre() {
		return filtroNombre;
	}

	public void setFiltroNombre(String filtroNombre) {
		this.filtroNombre = filtroNombre;
	}
	
	
}