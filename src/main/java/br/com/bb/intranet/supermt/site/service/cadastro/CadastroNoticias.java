package br.com.bb.intranet.supermt.site.service.cadastro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.bb.intranet.supermt.site.model.Noticia;
import br.com.bb.intranet.supermt.site.model.Registro;
import br.com.bb.intranet.supermt.site.model.Tag;
import br.com.bb.intranet.supermt.site.repository.Noticias;
import br.com.bb.intranet.supermt.site.repository.Registros;
import br.com.bb.intranet.supermt.site.service.NegocioException;
import br.com.bb.intranet.supermt.site.util.Transactional;

public class CadastroNoticias implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Noticias noticias;
	
	@Inject
	private Registros cadastros;
	
	@Inject
	private CadastroTags cadastroTags;
	
	/**
	 * 
	 * @param noticia
	 * @throws NegocioException
	 */
	@Transactional
	public void salvar(Noticia noticia) throws NegocioException{
		if(noticia == null){
			throw new NegocioException("Noticia inválida!");
		}else if(noticia.getUsuario() == null){
			throw new NegocioException("Usuario inválido!");
		}else if(noticia.getTags() == null && !noticia.getTags().isEmpty()){
			List<Tag> paraSalvar = noticia.getTags();
			noticia.setTags(new ArrayList<>());
			noticia.setTags(this.cadastroTags.atualizar(paraSalvar));
		}
		
		Registro cadastro = new Registro();
		cadastro.setConteudo(noticia);
		cadastro.setUsuario(noticia.getUsuario());
		
//		this.cadastros.adicionar(cadastro);//registrando log
		this.noticias.adicionar(noticia);
	}
	

}
