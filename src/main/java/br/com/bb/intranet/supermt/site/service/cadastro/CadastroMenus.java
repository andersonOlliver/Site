package br.com.bb.intranet.supermt.site.service.cadastro;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.bb.intranet.supermt.site.model.Menu;
import br.com.bb.intranet.supermt.site.repository.Menus;
import br.com.bb.intranet.supermt.site.service.NegocioException;
import br.com.bb.intranet.supermt.site.util.Transactional;

public class CadastroMenus implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Menus menus;
	
	@Transactional
	public void salvar(Menu menu) throws NegocioException{
		if(menu == null){
			throw new NegocioException("Menu inválido!");
		}
		
		this.menus.adicionar(menu);
	}
	
	@Transactional
	public void atualizar(Menu menu) throws NegocioException {
		if(menu == null){
			throw new NegocioException("Menu inválido!");
		}else if(menus.porId(menu.getId()) == null){
			throw new NegocioException("Menu não existe!");
		}
		
		this.menus.atualizar(menu);
	}
	
	@Transactional
	public void excluir(Menu menu) throws NegocioException{
		menu = this.menus.porId(menu.getId());
		
		if(menu == null){
			throw new NegocioException("Menu não existe!");
		}
		
		this.menus.excluir(menu);
		
	}
	
}
