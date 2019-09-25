package com.hampcode.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.swing.text.View;

import org.primefaces.component.inputtext.InputText;
import org.primefaces.expression.impl.FindComponentExpressionResolver;

import com.hampcode.business.UsuarioBusiness;
import com.hampcode.model.entity.Usuario;
import com.hampcode.util.Message;

@Named
@SessionScoped
public class UsuarioController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioBusiness usuarioBusiness;
	
	private List<Usuario> listaUsuario;
	private Usuario usuario;
	private String usuarioLogin;
	private String claveLogin;
	private String filtroNombre;	
	
	@PostConstruct
	public void inicializar() {		
		this.usuario = new Usuario();
		this.listaUsuario = new ArrayList<Usuario>();
		this.listarUsuario();
		
	}
	
	public void listarUsuario() {
		try {
			this.listaUsuario = this.usuarioBusiness.listarTodo();
		}catch (Exception e) {
			Message.messageError("Error al cargar lista: " + e.getMessage());
		}
	}
	
	public String ingresar() {
		String view = "";
		try {
			if(this.usuarioBusiness.usuarioCredenciales("admin", "admin")) {
				view = "/WEB-INF/templates/master.xhtml";
				Message.messageInfo("Bienvenido " + this.usuario.getUsuario());
			}else {
				Message.messageError("Credenciales incorrectas");
			}
			this.limpiarVariables();
		}catch (Exception e) {
			Message.messageError("Error al ingresar: " + e.getMessage());
		}
		
		return view;
	}

	public void limpiarVariables() {
		this.usuario  = new Usuario();
		this.usuarioLogin = "";
		this.claveLogin = "";
		this.filtroNombre = "";
	}
	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getFiltroNombre() {
		return filtroNombre;
	}

	public void setFiltroNombre(String filtroNombre) {
		this.filtroNombre = filtroNombre;
	}

	public String getUsuarioLogin() {
		return usuarioLogin;
	}

	public void setUsuarioLogin(String usuarioLogin) {
		this.usuarioLogin = usuarioLogin;
	}

	public String getClaveLogin() {
		return claveLogin;
	}

	public void setClaveLogin(String claveLogin) {
		this.claveLogin = claveLogin;
	}		
	
	

}
