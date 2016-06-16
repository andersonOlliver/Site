package br.com.bb.intranet.supermt.site.controller.cadastro;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bb.intranet.supermt.site.model.Acesso;
import br.com.bb.intranet.supermt.site.service.NegocioException;
import br.com.bb.intranet.supermt.site.service.cadastro.CadastroRegistroAcesso;

@Named
@ViewScoped
public class CadastroNavegacaoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroRegistroAcesso cadastro;

	private Acesso navegacao;

	public void salvar() {
		FacesContext context = FacesContext.getCurrentInstance();

		try {

			this.cadastro.salvar(this.navegacao);

			context.addMessage(null, new FacesMessage("Navegacao salva com sucesso!"));

		} catch (NegocioException e) {

			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}
	}

	public Acesso getNavegacao() {
		return navegacao;
	}

	public void setNavegacao(Acesso navegacao) {
		this.navegacao = navegacao;
	}

}
