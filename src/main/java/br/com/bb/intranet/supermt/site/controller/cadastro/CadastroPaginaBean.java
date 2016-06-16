package br.com.bb.intranet.supermt.site.controller.cadastro;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bb.intranet.supermt.site.model.Menu;
import br.com.bb.intranet.supermt.site.model.Mercado;
import br.com.bb.intranet.supermt.site.model.Pagina;
import br.com.bb.intranet.supermt.site.repository.Menus;
import br.com.bb.intranet.supermt.site.repository.Mercados;
import br.com.bb.intranet.supermt.site.service.NegocioException;
import br.com.bb.intranet.supermt.site.service.cadastro.CadastroPaginas;

@Named
@ViewScoped
public class CadastroPaginaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroPaginas cadastro;

	@Inject
	private Menus menus;
	
	@Inject
	private Mercados mercados;

	private Pagina pagina;
	private List<Menu> listaMenu;
	private List<Mercado> listaMercado;

	public void prepararCadastro() {
		this.listaMenu = menus.todos();
		this.listaMercado = mercados.todos();
		
		if(this.pagina == null){
			this.pagina = new Pagina();
		}
	}

	public void salvar() {
		FacesContext context = FacesContext.getCurrentInstance();

		try {

			this.cadastro.salvar(this.pagina);

			this.pagina = new Pagina();
			context.addMessage(null, new FacesMessage("Pagina salva com sucesso!"));

		} catch (NegocioException e) {

			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}

	}
	
	public Pagina getPagina() {
		return pagina;
	}

	public void setPagina(Pagina pagina) {
		this.pagina = pagina;
	}

	public List<Menu> getListaMenu() {
		return listaMenu;
	}

	public List<Mercado> getListaMercado() {
		return listaMercado;
	}

	
	
}
