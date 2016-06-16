package br.com.bb.intranet.supermt.site.service.cadastro;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.bb.intranet.supermt.site.model.Comentario;
import br.com.bb.intranet.supermt.site.repository.Comentarios;
import br.com.bb.intranet.supermt.site.service.NegocioException;
import br.com.bb.intranet.supermt.site.util.Transactional;

public class CadastroComentarios implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Comentarios comentarios;
	
	@Transactional
	public void salvar(Comentario comentario) throws NegocioException {
		if(comentario == null){
			throw new NegocioException("Pagina inválida!");
		}
		
		this.comentarios.adicionar(comentario);
	}
	
	
}
