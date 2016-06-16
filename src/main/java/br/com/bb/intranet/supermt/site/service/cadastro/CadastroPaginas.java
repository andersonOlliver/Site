package br.com.bb.intranet.supermt.site.service.cadastro;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.bb.intranet.supermt.site.model.Pagina;
import br.com.bb.intranet.supermt.site.repository.Paginas;
import br.com.bb.intranet.supermt.site.service.NegocioException;
import br.com.bb.intranet.supermt.site.util.Transactional;

public class CadastroPaginas implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Paginas paginas;

	@Transactional
	public void salvar(Pagina pagina) throws NegocioException {
		if(pagina == null){
			throw new NegocioException("Pagina inválida!");
		}
		
		this.paginas.adicionar(pagina);
	}

	@Transactional
	public void atualizar(Pagina pagina) throws NegocioException {
		if(pagina == null){
			throw new NegocioException("Pagina inválida!");
		}else if(paginas.porId(pagina.getId()) == null){
			throw new NegocioException("Pagina não existe!");
		}
		
		this.paginas.atualizar(pagina);
	}
	
	@Transactional
	public void excluir(Pagina pagina) throws NegocioException{
		pagina = this.paginas.porId(pagina.getId());
		
		if(pagina == null){
			throw new NegocioException("Pagina não existe!");
		}
		
		this.paginas.excluir(pagina);
		
	}
}

