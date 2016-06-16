package br.com.bb.intranet.supermt.site.controller.cadastro;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bb.intranet.supermt.site.model.Mercado;
import br.com.bb.intranet.supermt.site.service.NegocioException;
import br.com.bb.intranet.supermt.site.service.cadastro.CadastroMercados;

@Named
@ViewScoped
public class CadastroMercadoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroMercados cadastro;

	private Mercado mercado;

	public void prepararCadastro() {
		this.mercado = new Mercado();
	}

	public void salvar() {
		FacesContext context = FacesContext.getCurrentInstance();

		try {

			this.cadastro.salvar(this.mercado);

			this.mercado = new Mercado();
			context.addMessage(null, new FacesMessage("Mercado salvo com sucesso!"));

		} catch (NegocioException e) {

			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}
	}

	public Mercado getMercado() {
		return mercado;
	}

	public void setMercado(Mercado mercado) {
		this.mercado = mercado;
	}

}
