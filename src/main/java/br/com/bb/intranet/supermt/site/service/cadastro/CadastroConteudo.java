package br.com.bb.intranet.supermt.site.service.cadastro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.bb.intranet.supermt.site.model.Conteudo;
import br.com.bb.intranet.supermt.site.model.Registro;
import br.com.bb.intranet.supermt.site.model.Tag;
import br.com.bb.intranet.supermt.site.repository.Conteudos;
import br.com.bb.intranet.supermt.site.repository.Registros;
import br.com.bb.intranet.supermt.site.service.NegocioException;
import br.com.bb.intranet.supermt.site.util.Transactional;

public class CadastroConteudo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Conteudos conteudos;

	@Inject
	private Registros cadastros;

	@Inject
	private CadastroTags cadastroTags;

	@Transactional
	public void salvar(Conteudo conteudo) throws NegocioException {

		if (conteudo == null) {
			throw new NegocioException("Conteudo inválido!");
		} else if (conteudo.getUsuario() == null) {
			throw new NegocioException("Usuario inválido!");
		} else if (conteudo.getTags() == null && !conteudo.getTags().isEmpty()) {

			List<Tag> paraSalvar = conteudo.getTags();
			conteudo.setTags(new ArrayList<>());
			conteudo.setTags(this.cadastroTags.atualizar(paraSalvar));
		}

		Registro cadastro = new Registro();
		cadastro.setConteudo(conteudo);
		cadastro.setUsuario(conteudo.getUsuario());

//		this.cadastros.adicionar(cadastro);// registrando log
		this.conteudos.adicionar(conteudo);
	}

}
