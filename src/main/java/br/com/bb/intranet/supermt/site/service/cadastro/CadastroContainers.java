package br.com.bb.intranet.supermt.site.service.cadastro;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.bb.intranet.supermt.site.model.Container;
import br.com.bb.intranet.supermt.site.repository.Containers;
import br.com.bb.intranet.supermt.site.service.NegocioException;
import br.com.bb.intranet.supermt.site.util.Transactional;

public class CadastroContainers implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Containers containers;
	
	@Transactional
	public void salvar(Container container) throws NegocioException {
		if(container == null){
			throw new NegocioException("Pagina inválida!");
		}
		
		this.containers.adicionar(container);
	}

}
