package br.com.bb.intranet.supermt.site.controller.cadastro;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bb.intranet.supermt.site.model.TipoUsuario;
import br.com.bb.intranet.supermt.site.model.Usuario;
import br.com.bb.intranet.supermt.site.service.NegocioException;
import br.com.bb.intranet.supermt.site.service.cadastro.CadastroUsuarios;

@Named
@ViewScoped
public class CadastroUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario;

	@Inject
	private CadastroUsuarios cadastro;

	public void prepararCadastro() {
		if (this.usuario == null) {
			this.usuario = new Usuario();
		}
	}

	public void atualizar() {
		FacesContext context = FacesContext.getCurrentInstance();

		try {

			this.cadastro.atualizar(this.usuario);

			this.usuario = new Usuario();
			context.addMessage(null, new FacesMessage("Usuario salvo com sucesso!"));

		} catch (NegocioException e) {

			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}
	}

	public void salvar() {
		FacesContext context = FacesContext.getCurrentInstance();

		try {

			this.cadastro.salvar(this.usuario);

			this.usuario = new Usuario();
			context.addMessage(null, new FacesMessage("Usuario salvo com sucesso!"));

		} catch (NegocioException e) {

			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public TipoUsuario[] getTiposUsuarios() {
		return TipoUsuario.values();
	}
}
