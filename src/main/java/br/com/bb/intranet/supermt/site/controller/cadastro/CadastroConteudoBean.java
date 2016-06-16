package br.com.bb.intranet.supermt.site.controller.cadastro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bb.intranet.supermt.site.model.Container;
import br.com.bb.intranet.supermt.site.model.Conteudo;
import br.com.bb.intranet.supermt.site.model.Tag;
import br.com.bb.intranet.supermt.site.model.Usuario;
import br.com.bb.intranet.supermt.site.repository.Containers;
import br.com.bb.intranet.supermt.site.repository.Usuarios;
import br.com.bb.intranet.supermt.site.service.NegocioException;
import br.com.bb.intranet.supermt.site.service.cadastro.CadastroConteudo;

@Named
@ViewScoped
public class CadastroConteudoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroConteudo cadastro;
	
	@Inject
	private Usuarios usuarioRepository;

	@Inject
	private Containers containerRepository;

	private Conteudo conteudo;
	private Tag tag;
	private List<Tag> tags;
	private List<Container> listaContainer;
	private List<Usuario> listaUsuario;

	public void prepararCadastro() {
		this.conteudo = new Conteudo();
		this.tag = new Tag();
		this.tags = new ArrayList<Tag>();
		this.listaContainer = containerRepository.todos();
		this.listaUsuario = usuarioRepository.todos();
	}

	public void criarNovo() {
		if (tags.contains(tag)) {
			FacesMessage msg = new FacesMessage("Duplicado", "Esta tag já foi adicionada");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} else {
			tags.add(tag);
			tag = new Tag();
		}
	}

	public String resetar() {
		tag = new Tag();
		return null;
	}

	public void salvar() {
		FacesContext context = FacesContext.getCurrentInstance();

		try {

			this.conteudo.setTags(this.tags);
			this.cadastro.salvar(this.conteudo);

			this.conteudo = new Conteudo();
			this.tags = new ArrayList<>();
			
			context.addMessage(null, new FacesMessage("Conteudo salvo com sucesso!"));

		} catch (NegocioException e) {

			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}
	}


	public Conteudo getConteudo() {
		return conteudo;
	}

	public void setConteudo(Conteudo conteudo) {
		this.conteudo = conteudo;
	}

	public List<Container> getListaContainer() {
		return listaContainer;
	}

	public Tag getTag() {
		return tag;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}

}
