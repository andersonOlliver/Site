package br.com.bb.intranet.supermt.site.service.cadastro;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.bb.intranet.supermt.site.model.Mercado;
import br.com.bb.intranet.supermt.site.repository.Mercados;
import br.com.bb.intranet.supermt.site.service.NegocioException;
import br.com.bb.intranet.supermt.site.util.Transactional;

public class CadastroMercados implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Mercados mercados;
	
	@Transactional
	public void salvar(Mercado mercado) throws NegocioException{
		if(mercado == null){
			throw new NegocioException("Mercado inválida!");
		}
		
		this.mercados.adicionar(mercado);
	}
	
}
