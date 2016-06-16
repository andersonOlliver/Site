package br.com.bb.intranet.supermt.site.service.cadastro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.bb.intranet.supermt.site.model.Tag;
import br.com.bb.intranet.supermt.site.repository.Tags;
import br.com.bb.intranet.supermt.site.service.NegocioException;
import br.com.bb.intranet.supermt.site.util.Transactional;

public class CadastroTags implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Tags tags;
	
	@Transactional
	public void salvar(Tag tag) throws NegocioException{
		if(tag == null){
			throw new NegocioException("Tag inválida!");
		}
		
		this.tags.adicionar(tag);
	}
	
	@Transactional
	public Tag atualizar(Tag tag) throws NegocioException {
		tag = tags.porValor(tag);
		if(tag == null){
			throw new NegocioException("Tag inválida!");
		}
		
		return this.tags.atualizar(tag);
	}
	
	@Transactional
	public List<Tag> atualizar(List<Tag> tagParametro) throws NegocioException {
		List<Tag> tagValidacao = new ArrayList<>();
		if(tagParametro == null){
			throw new NegocioException("Não há tags cadastradas!");
		}
		for(Tag tag:tagParametro){
			tagValidacao.add(tags.porValor(tag));
		}
		
		return this.tags.atualizar(tagValidacao);
	}

}
