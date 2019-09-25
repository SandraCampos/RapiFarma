package com.hampcode.model.entity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.ws.rs.DefaultValue;

@Entity
@Table(name = "pedidos")
public class Pedido implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "codigo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;	
	
	@Column(name = "fch_emision", nullable = false)
	private Date fch_emision;
	
	@Column(name = "fch_recepcion", nullable = false)
	private Date fch_recepcion;
	
	@Column(name = "estado", nullable = false, length = 1)
	@DefaultValue(value = "R")
	private String estado;
	
	@OneToMany(mappedBy = "pedido", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE}, fetch = FetchType.LAZY)
	private List<PedidoDetalle> pedidoDetalle;
	
	@PrePersist
	public void inicializar() {
		this.fch_recepcion = new Date();
		this.estado = "R";
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Date getFch_emision() {
		return fch_emision;
	}

	public void setFch_emision(Date fch_emision) {
		this.fch_emision = fch_emision;
	}

	public Date getFch_recepcion() {
		return fch_recepcion;
	}

	public void setFch_recepcion(Date fch_recepcion) {
		this.fch_recepcion = fch_recepcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public List<PedidoDetalle> getPedidoDetalle() {
		return pedidoDetalle;
	}
	
	public void setPedidoDetalle(List<PedidoDetalle> pedidoDetalle) {
		this.pedidoDetalle = pedidoDetalle;
	}
}
