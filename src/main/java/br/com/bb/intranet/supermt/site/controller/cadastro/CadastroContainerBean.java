package br.com.bb.intranet.supermt.site.controller.cadastro;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bb.intranet.supermt.site.model.Container;
import br.com.bb.intranet.supermt.site.model.Pagina;
import br.com.bb.intranet.supermt.site.repository.Paginas;
import br.com.bb.intranet.supermt.site.service.NegocioException;
import br.com.bb.intranet.supermt.site.service.cadastro.CadastroContainers;

@Named
@ViewScoped
public class CadastroContainerBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroContainers cadastro;
	
	@Inject
	private Paginas paginas;
	
	private Container container;
	private List<Pagina> listaPaginas;
	
	public void prepararCadastro(){
		this.container = new Container();
		this.listaPaginas = paginas.todas();
	}
	
	public void salvar(){
		FacesContext context = FacesContext.getCurrentInstance();

		try {

			this.cadastro.salvar(this.container);

			this.container = new Container();
			context.addMessage(null, new FacesMessage("Pagina salva com sucesso!"));

		} catch (NegocioException e) {

			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}
	}

	public List<Pagina> getListaPaginas() {
		return listaPaginas;
	}

	public Container getContainer() {
		return container;
	}

	public void setContainer(Container container) {
		this.container = container;
	}

	
}
