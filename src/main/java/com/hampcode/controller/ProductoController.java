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
import com.hampcode.business.CategoriaBusiness;
import com.hampcode.business.ProductoBusiness;
import com.hampcode.model.entity.Proveedor;
import com.hampcode.model.entity.Categoria;
import com.hampcode.model.entity.Producto;
import com.hampcode.util.Message;

@Named
@SessionScoped
public class ProductoController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ProductoBusiness productoBusiness;
	@Inject
	private ProveedorBusiness proveedorBusiness;
	@Inject
	private CategoriaBusiness categoriaBusiness;
	
	private List<Producto> listaProducto;
	private List<Proveedor> listaProveedor;
	private List<Categoria> listaCategoria;
	private Producto productoSeleccionado;
	private Producto producto;
	private Proveedor proveedorSeleccionado;
	private Categoria categoriaSeleccionada;
	private String filtroNombre;
	private int stockMinimo = 0;
	
	@PostConstruct
	public void inicializar() {
		this.producto = new Producto();
		this.listaProveedor = new ArrayList<Proveedor>();
		this.listaProducto = new ArrayList<Producto>();
		this.listaCategoria = new ArrayList<Categoria>();
		this.listarProducto();	
	}
	
	public void listarCategoria() {
		try {
			this.listaCategoria = this.categoriaBusiness.listarTodo();
		}catch (Exception e) {
			Message.messageError("Error al cargar lista de categorias: " + e.getMessage());
		}
	}
	
	public void listarProveedor() {
		try {
			this.listaProveedor = this.proveedorBusiness.listarTodo();
		}catch (Exception e) {
			Message.messageError("Error al cargar lista de proveedores: " + e.getMessage());
		}
	}
	
	public void listarProducto() {		
		try {
			this.listaProducto = this.productoBusiness.listarTodo();
		}catch (Exception e) {
			Message.messageError("Error al cargar lista de productos: " + e.getMessage());
		}
	}
	
	public void seleccionarProducto(SelectEvent e) {
		this.productoSeleccionado = (Producto)e.getObject();
	}
	
	public String nuevoProducto() {
		this.limpiarVariables();
		this.listarProveedor();
		this.listarCategoria();
		return "/producto/insert.xhtml";
	}
	
	public String editarProducto() {
		String view = "";				
		try {		
			this.listarProveedor();		
			this.listarCategoria();
			if(this.productoSeleccionado != null) {				
				this.producto = this.productoSeleccionado;							
				view = "/producto/update.xhtml";
			}else {
				Message.messageInfo("Debe seleccionar un producto");
			}						
		}catch (Exception e) {
			Message.messageError("Error producto: " + e.getMessage());
		}		
		return view;
	}
	
	public String irListaProducto() {
		return "/producto/lista.xhtml";
	}
	
	public void buscarProductoPorNombre() {
		try {
			this.listaProducto = this.productoBusiness.listarPorNombre(this.filtroNombre.trim());
			this.limpiarVariables();
			if(this.listaProducto.isEmpty()) {
				Message.messageInfo("No se encontraron productos");
			}			
		}catch (Exception e) {
			Message.messageError("Error al buscar Producto: " + e.getMessage());
		}
	}	
	
	public void buscarProductoPorStockMinimo() {
		try {
			this.listaProducto = this.productoBusiness.listarPorStockMinimo(this.stockMinimo);
			this.limpiarVariables();
			if(this.listaProducto.isEmpty()) {
				Message.messageInfo("No se encontraron productos");
			}
		}catch (Exception e) {
			Message.messageError("Error al buscar producto: " + e.getMessage());
		}
	}
	
	public String registrarProducto() {
		String view = "";
		
		try {						
			
			this.producto.setCategoria(this.categoriaSeleccionada);
			this.producto.setProveedor(this.proveedorSeleccionado);		
			
			if(this.productoBusiness.productoExiste(this.producto) == true) {						
				this.productoBusiness.modificar(this.producto);
				Message.messageInfo("Producto: " + this.producto.getCodigo() + " actualizado correctamente");
			}else {					
				this.productoBusiness.registrar(this.producto);
				Message.messageInfo("Producto registrado exitosamente...");
			}							
			this.listarProducto();
			this.limpiarVariables();
			view = "/producto/lista.xthml";
		}catch(Exception e) {
			Message.messageError("Error Producto :" + e.getMessage());
		}
		
		return view;
	}
	
	public void limpiarVariables() {
		this.filtroNombre = "";
		this.stockMinimo = 0;
		this.producto = new Producto();
	}

	public List<Producto> getListaProducto() {
		return listaProducto;
	}

	public void setListaProducto(List<Producto> listaProducto) {
		this.listaProducto = listaProducto;
	}

	public List<Proveedor> getListaProveedor() {
		return listaProveedor;
	}

	public void setListaProveedor(List<Proveedor> listaProveedor) {
		this.listaProveedor = listaProveedor;
	}

	public Producto getProductoSeleccionado() {
		return productoSeleccionado;
	}

	public void setProductoSeleccionado(Producto productoSeleccionado) {
		this.productoSeleccionado = productoSeleccionado;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Proveedor getProveedorSeleccionado() {
		return proveedorSeleccionado;
	}

	public void setProveedorSeleccionado(Proveedor proveedorSeleccionado) {
		this.proveedorSeleccionado = proveedorSeleccionado;
	}

	public String getFiltroNombre() {
		return filtroNombre;
	}

	public void setFiltroNombre(String filtroNombre) {
		this.filtroNombre = filtroNombre;
	}

	public List<Categoria> getListaCategoria() {
		return listaCategoria;
	}

	public void setListaCategoria(List<Categoria> listaCategoria) {
		this.listaCategoria = listaCategoria;
	}

	public Categoria getCategoriaSeleccionada() {
		return categoriaSeleccionada;
	}

	public void setCategoriaSeleccionada(Categoria categoriaSeleccionada) {
		this.categoriaSeleccionada = categoriaSeleccionada;
	}

	public int getStockMinimo() {
		return stockMinimo;
	}

	public void setStockMinimo(int stockMinimo) {
		this.stockMinimo = stockMinimo;
	}		
	
	
}
