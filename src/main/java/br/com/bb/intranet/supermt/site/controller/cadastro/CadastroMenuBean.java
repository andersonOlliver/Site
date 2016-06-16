package br.com.bb.intranet.supermt.site.controller.cadastro;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bb.intranet.supermt.site.model.Menu;
import br.com.bb.intranet.supermt.site.model.Pagina;
import br.com.bb.intranet.supermt.site.repository.Menus;
import br.com.bb.intranet.supermt.site.repository.Paginas;
import br.com.bb.intranet.supermt.site.service.NegocioException;
import br.com.bb.intranet.supermt.site.service.cadastro.CadastroMenus;

@Named
@ViewScoped
public class CadastroMenuBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Menus menus;
	
	@Inject
	private CadastroMenus cadastro;
	
	@Inject
	private Paginas paginas;
	
	private List<Menu> listaMenu;
	private List<Pagina> listaPagina;
	private Menu menu;
	
	public void prepararCadastro(){
		this.menu = new Menu();
		this.listaMenu = menus.todos();
		this.listaPagina = paginas.todas();
	}
	
	public void salvar(){
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {

			this.cadastro.salvar(this.menu);

			this.menu = new Menu();
			context.addMessage(null, new FacesMessage("Menu salvo com sucesso!"));

		} catch (NegocioException e) {

			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public List<Menu> getListaMenu() {
		return listaMenu;
	}

	public List<Pagina> getListaPagina() {
		return listaPagina;
	}
	
	
	
}
