package br.com.bb.intranet.supermt.site.service.cadastro;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.bb.intranet.supermt.site.model.Acesso;
import br.com.bb.intranet.supermt.site.repository.Acessos;
import br.com.bb.intranet.supermt.site.service.NegocioException;
import br.com.bb.intranet.supermt.site.util.Transactional;

public class CadastroRegistroAcesso implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Acessos navegacoes;
	
	@Transactional
	public void salvar(Acesso acesso) throws NegocioException{
		if(acesso == null){
			throw new NegocioException("Navegação inválida!");
		}else if(acesso.getUsuario() == null){
			throw new NegocioException("Usuário inválido!");
		}else if(acesso.getPagina() == null){
			throw new NegocioException("Página inválida!");
		}
		
		this.navegacoes.adicionar(acesso);
	}

}
