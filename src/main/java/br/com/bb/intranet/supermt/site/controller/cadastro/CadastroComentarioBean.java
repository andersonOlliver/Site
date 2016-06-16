package br.com.bb.intranet.supermt.site.controller.cadastro;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bb.intranet.supermt.site.model.Comentario;
import br.com.bb.intranet.supermt.site.service.NegocioException;
import br.com.bb.intranet.supermt.site.service.cadastro.CadastroComentarios;

@Named
@ViewScoped
public class CadastroComentarioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroComentarios cadastro;
	
	private Comentario comentario;
	
	public void prepararCadastro(){
		this.comentario = new Comentario();
	}

	public void salvar(){
		FacesContext context = FacesContext.getCurrentInstance();

		try {

			this.cadastro.salvar(this.comentario);

			this.comentario = new Comentario();
			context.addMessage(null, new FacesMessage("Pagina salva com sucesso!"));

		} catch (NegocioException e) {

			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}
	}
	
	public Comentario getComentario() {
		return comentario;
	}

	public void setComentario(Comentario comentario) {
		this.comentario = comentario;
	}

	
	
}
