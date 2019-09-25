package com.hampcode.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.event.SelectEvent;

import com.hampcode.business.PedidoBusiness;
import com.hampcode.business.ProductoBusiness;
import com.hampcode.model.entity.Pedido;
import com.hampcode.model.entity.PedidoDetalle;
import com.hampcode.model.entity.Producto;
import com.hampcode.model.entity.Proveedor;
import com.hampcode.util.Message;

@Named
@ViewScoped
public class PedidoController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject 
	private PedidoBusiness pedidoBusiness;	
	@Inject
	private ProductoBusiness productoBusiness;
	
	private List<Pedido> listaPedido;
	private List<Producto> listaProducto;
	private List<PedidoDetalle> listaPedidoDetalle;
	private Producto producto;
	private Pedido pedido;
	private Pedido pedidoSeleccionado;
	private PedidoDetalle pedidoDetalle;
	private PedidoDetalle pedidoDetalleSeleccionado;
	private Proveedor proveedorSeleccionado;
	private String filtroNombre;
	
	@PostConstruct
	public void inicializar() {
		this.listaPedido = new ArrayList<Pedido>();		
		this.listaProducto = new ArrayList<Producto>();
		this.listaPedidoDetalle = new ArrayList<PedidoDetalle>();
		this.producto = new Producto();
		this.pedido = new Pedido();
		this.pedidoDetalle = new PedidoDetalle();
		this.listarPedido();
		this.listarProducto();
	}
	
	public void listarPedido() {
		try {
			this.listaPedido = this.pedidoBusiness.listarTodo();
		}catch (Exception e) {
			Message.messageError("Error al cargar lista pedido: " + e.getMessage());
		}
	}
	
	public void listarProducto() {
		try {
			this.listaProducto = this.productoBusiness.listarTodo();
		}catch (Exception e) {
			Message.messageError("Error al cargar lista producto: " + e.getMessage());
		}
	}
	
	public void seleccionarPedidoDetalle(SelectEvent e) {
		this.pedidoDetalleSeleccionado = (PedidoDetalle)e.getObject();
	}
	
	public String nuevoPedido() {
		this.listarPedido();
		this.limpiarVariables();
		return "/pedido/insert.xhtml";
	}	
	
	public void limpiarVariables() {
		this.filtroNombre = "";
		this.pedido = new Pedido();
		this.listaPedidoDetalle.clear();
		this.producto = new Producto();
		this.pedidoDetalle = new PedidoDetalle();
	}
	
	public String irListaPedido() {
		return "/pedido/lista.xhtml";
	}
	
	public String editarPedido() {
		String view = "";
		try {
			if(this.pedidoSeleccionado != null) {	
				this.pedido = this.pedidoSeleccionado;
				this.pedido.setPedidoDetalle(this.pedidoBusiness.listarPedidoDetalle(this.pedidoSeleccionado));
				this.listaPedidoDetalle = this.pedido.getPedidoDetalle();
				view = "/pedido/update.xhtml";
			}else {
				Message.messageInfo("Debe seleccionar un pedido");
			}
		}catch (Exception e) {
			Message.messageError("Error al editar pedido: " + e.getMessage());
		}
		return view;
	}
	
	public String registrarPedido() {
		String view = "";
		try {			
			
			if(this.pedido.getCodigo() != null) {
				
				Message.messageInfo("Pedido: " + this.pedido.getCodigo() + " modificado correctamente" );
			}else {
				
				if(!this.listaPedidoDetalle.isEmpty()) {
					this.pedido.setPedidoDetalle(this.listaPedidoDetalle);			
					this.pedidoBusiness.registrar(pedido);
					Message.messageInfo("Pedido: " + this.pedido.getCodigo() + " registrado correctamente" );
				}else {
					Message.messageError("Debe registrar productos para el pedido");
				}
			}
			
			this.listarPedido();
			this.limpiarVariables();
			view = "/pedido/lista.xhtml";
		}catch (Exception e) {
			Message.messageError("Error pedido: " + e.getMessage());
		}
		return view;
	}		
	
	public void agregarPedidoDetalle() {
		this.pedidoDetalle.setProducto(this.producto);
		this.listaPedidoDetalle.add(this.pedidoDetalle);
		this.pedidoDetalle = new PedidoDetalle();
	}	
	
	public void eliminarPedidoDetalle() {
		
	}

	public void buscarPedidoPorNombre() {
		
	}
	
	public void seleccionarPedido(SelectEvent e) {
		this.pedidoSeleccionado = (Pedido) e.getObject();
	}

	public List<Pedido> getListaPedido() {
		return listaPedido;
	}

	public void setListaPedido(List<Pedido> listaPedido) {
		this.listaPedido = listaPedido;
	}
	
	public List<Producto> getListaProducto() {
		return listaProducto;
	}
	
	public void setListaProducto(List<Producto> listaProducto) {
		this.listaProducto = listaProducto;
	}
	
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Pedido getPedidoSeleccionado() {
		return pedidoSeleccionado;
	}

	public void setPedidoSeleccionado(Pedido pedidoSeleccionado) {
		this.pedidoSeleccionado = pedidoSeleccionado;
	}
    
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	public Producto getProducto() {
		return producto;
	}
	
	public String getFiltroNombre() {
		return filtroNombre;
	}

	public void setFiltroNombre(String filtroNombre) {
		this.filtroNombre = filtroNombre;
	}
	
	public Proveedor getProveedorSeleccionado() {
		return proveedorSeleccionado;
	}
	
	public void setProveedorSeleccionado(Proveedor proveedorSeleccionado) {
		this.proveedorSeleccionado = proveedorSeleccionado;
	}
	
	public void setListaPedidoDetalle(List<PedidoDetalle> listaPedidoDetalle) {
		this.listaPedidoDetalle = listaPedidoDetalle;
	}
	
	public List<PedidoDetalle> getListaPedidoDetalle() {
		return listaPedidoDetalle;
	}
	
	public void setPedidoDetalle(PedidoDetalle pedidoDetalle) {
		this.pedidoDetalle = pedidoDetalle;
	}
	
	public PedidoDetalle getPedidoDetalle() {
		return pedidoDetalle;
	}
	
	public void setPedidoDetalleSeleccionado(PedidoDetalle pedidoDetalleSeleccionado) {
		this.pedidoDetalleSeleccionado = pedidoDetalleSeleccionado;
	}
	
	public PedidoDetalle getPedidoDetalleSeleccionado() {
		return pedidoDetalleSeleccionado;
	}
}
