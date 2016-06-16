package br.com.bb.intranet.supermt.site.controller.cadastro;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.bb.intranet.supermt.site.model.Tag;
import br.com.bb.intranet.supermt.site.service.NegocioException;
import br.com.bb.intranet.supermt.site.service.cadastro.CadastroTags;

public class CadastroTagBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroTags cadastro;
	
	private Tag tag;
	
	public void prepararCadastro(){
		this.tag = new Tag();
	}
	
	public void salvar(){
		FacesContext context = FacesContext.getCurrentInstance();

		try {

			this.cadastro.salvar(this.tag);

			this.tag = new Tag();
			context.addMessage(null, new FacesMessage("Menu salvo com sucesso!"));

		} catch (NegocioException e) {

			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

}
