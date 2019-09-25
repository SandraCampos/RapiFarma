package com.hampcode.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.ws.rs.DefaultValue;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "codigo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(name = "usuario", nullable = false, length = 20)
	@DefaultValue(value = "")
	private String usuario;
	
	@Column(name = "clave", nullable = false, length = 10)
	@DefaultValue(value = "")
	private String clave;
	
	@Column(name = "vigente", nullable = false)
	@DefaultValue(value = "S")
	private String vigente;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getVigente() {
		return vigente;
	}

	public void setVigente(String vigente) {
		this.vigente = vigente;
	}	

}
