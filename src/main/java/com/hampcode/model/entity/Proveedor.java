package com.hampcode.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.ws.rs.DefaultValue;

@Entity
@Table(name="proveedores")
public class Proveedor {

	@Id
	@Column(name = "codigo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(name = "nombre", nullable = false, length = 100)
	@DefaultValue(value = "")
	private String nombre;

	@Column(name = "direccion", nullable = false, length = 100)
	@DefaultValue(value = "")
	private String direccion;
	
	@Column(name = "email", nullable = false, length = 100)
	@DefaultValue(value = "")
	private String email;
	
	@Column(name = "telefono", nullable = false, length = 100)
	@DefaultValue(value = "")
	private String telefono;
	
	@Column(name = "contacto", nullable = false, length = 100)
	@DefaultValue(value = "")
	private String contacto;
	
	@Column(name = "ruc", nullable = false, length = 11)
	@DefaultValue(value = "")
	private String ruc;

	public Long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}	
}
