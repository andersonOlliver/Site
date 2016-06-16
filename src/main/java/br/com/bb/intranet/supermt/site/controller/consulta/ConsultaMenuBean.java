package br.com.bb.intranet.supermt.site.controller.consulta;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bb.intranet.supermt.site.model.Menu;
import br.com.bb.intranet.supermt.site.repository.Menus;

@Named
@ViewScoped
public class ConsultaMenuBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Menus menusRepository;
	
	private List<Menu> menus;
	
	public void consultar(){
		this.menus = menusRepository.todos();
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	
}
