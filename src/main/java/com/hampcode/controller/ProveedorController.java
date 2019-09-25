package com.hampcode.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.hampcode.business.ProveedorBusiness;
import com.hampcode.model.entity.Proveedor;
import com.hampcode.util.Message;

@Named
@SessionScoped
public class ProveedorController implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private ProveedorBusiness proveedorBusiness;
	
	private List<Proveedor> listaProveedor;
	private Proveedor proveedorSeleccionado;
	private Proveedor proveedor;
	private String filtroNombre;
	
	
	@PostConstruct
	public void inicializar() {		
		this.proveedor = new Proveedor();
		this.listaProveedor = new ArrayList<Proveedor>();
		this.listarProveedor();;	
	}
	
	public void listarProveedor() {
		try {
			this.listaProveedor = this.proveedorBusiness.listarTodo();
		}catch (Exception e) {
			Message.messageError("Error al cargar lista: " + e.getMessage());
		}
	}
	
	public void seleccionarProveedor(SelectEvent e) {
		this.proveedorSeleccionado = (Proveedor)e.getObject();
	}
	
	public String nuevoProveedor() {
		this.limpiarVariables();
		this.listarProveedor();
		return "/proveedor/insert.xhtml";
	}
	
	public String editarProveedor(){
		
		String view = "";		
		try {			
			if(this.proveedorSeleccionado != null) {
				this.proveedor = this.proveedorSeleccionado;
				view = "/proveedor/update.xhtml";
			}else {
				Message.messageInfo("Debe seleccionar un proveedor");
			}			
		}catch (Exception e) {
			Message.messageError("Error proveedor: " + e.getMessage());
		}
		
		return view;
	}
	
	public String irListaProveedor() {
		return "/proveedor/lista.xhtml";
	}
	
	public void buscarProveedorPorNombre() {
		try {
			this.listaProveedor = this.proveedorBusiness.listarPorNombre(this.filtroNombre);
			this.limpiarVariables();
			if(this.listaProveedor.isEmpty()) {
				Message.messageInfo("No se encontraron proveedores");
			}
		}catch (Exception e) {
			Message.messageError("Error al buscar proveedor: " + e.getMessage());
		}
	}
	
	public String registrarProveedor() {
		String view ="";
		try {
						
			if(this.proveedor.getCodigo() != null) {
				this.proveedorBusiness.modificar(this.proveedor);
				Message.messageInfo("Proveedor: " + this.proveedor.getCodigo() + " actualizado correctamente");
			}else {
				this.proveedorBusiness.registrar(this.proveedor);
				Message.messageInfo("Proveedor registrado correctamente");
			}
			this.listarProveedor();
			this.limpiarVariables();
			view = "/proveedor/lista.xhtml";
		}catch(Exception e) {
			Message.messageError("Error Proveedor: " + e.getMessage());
		}		
		return view;
	}
	
	public void limpiarVariables() {
		this.proveedor = new Proveedor();
		this.filtroNombre = "";
	}

	public List<Proveedor> getListaProveedor() {
		return listaProveedor;
	}

	public void setListaProveedor(List<Proveedor> listaProveedor) {
		this.listaProveedor = listaProveedor;
	}

	public Proveedor getProveedorSeleccionado() {
		return proveedorSeleccionado;
	}

	public void setProveedorSeleccionado(Proveedor proveedorSeleccionado) {
		this.proveedorSeleccionado = proveedorSeleccionado;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public String getFiltroNombre() {
		return filtroNombre;
	}

	public void setFiltroNombre(String filtroNombre) {
		this.filtroNombre = filtroNombre;
	}
	
}
