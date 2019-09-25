package com.hampcode.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.ws.rs.DefaultValue;

@Entity
@Table(name = "productos")
public class Producto {

	@Id
	@Column(name = "codigo", nullable = false, length = 50)
	private String codigo;	
	
	@ManyToOne
	@JoinColumn(name = "categorias_codigo")
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name = "proveedores_codigo")
	private Proveedor proveedor;
	
	@Column(name = "nombre", nullable = false, length = 50)
	@DefaultValue(value = "")
	private String nombre;
			
	@Column(name = "und_med", nullable = false, length = 10)
	@DefaultValue(value = "")
	private String und_med;
	
	@Column(name = "ubicacion", nullable = false, length = 30)
	@DefaultValue(value = "")
	private String ubicacion;
	
	@Column(name = "precio_venta", nullable = false)
	@DefaultValue(value = "0.00")
	private double precio_venta;
	
	@Column(name = "stock", nullable = false)
	@DefaultValue(value = "0")
	private int stock;
	
	@Column(name = "stock_minimo", nullable = false)
	@DefaultValue(value = "0")
	private int stock_minimo;
		
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public Proveedor getProveedor() {
		return proveedor;
	}
	
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUnd_med() {
		return und_med;
	}

	public void setUnd_med(String und_med) {
		this.und_med = und_med;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public double getPrecio_venta() {
		return precio_venta;
	}

	public void setPrecio_venta(double precio_venta) {
		this.precio_venta = precio_venta;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	} 	
	
	public int getStock_minimo() {
		return stock_minimo;
	}
	
	public void setStock_minimo(int stock_minimo) {
		this.stock_minimo = stock_minimo;
	}
	
	
}
