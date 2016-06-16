package br.com.bb.intranet.supermt.site.service.cadastro;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.bb.intranet.supermt.site.model.Sugestao;
import br.com.bb.intranet.supermt.site.repository.Sugestoes;
import br.com.bb.intranet.supermt.site.service.NegocioException;
import br.com.bb.intranet.supermt.site.util.Transactional;

public class CadastroSugestoes implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Sugestoes sugestoes;
	
	@Transactional
	public void salvar(Sugestao sugestao) throws NegocioException{
		if(sugestao == null ){
			throw new NegocioException("Objeto Nulo");
		}
		this.sugestoes.adicionar(sugestao);
	}
	
}
