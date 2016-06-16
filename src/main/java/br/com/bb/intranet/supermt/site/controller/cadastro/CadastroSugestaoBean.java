package br.com.bb.intranet.supermt.site.controller.cadastro;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bb.intranet.supermt.site.model.EstadoSugestao;
import br.com.bb.intranet.supermt.site.model.Sugestao;
import br.com.bb.intranet.supermt.site.model.Usuario;
import br.com.bb.intranet.supermt.site.repository.Usuarios;
import br.com.bb.intranet.supermt.site.service.NegocioException;
import br.com.bb.intranet.supermt.site.service.cadastro.CadastroSugestoes;

@Named
@ViewScoped
public class CadastroSugestaoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroSugestoes cadastro;
	
	@Inject
	private Usuarios usuarioRepository;

	private Sugestao sugestao;
	private List<Usuario> todosUsuarios;

	public void prepararCadastro() {
		this.sugestao = new Sugestao();
		this.todosUsuarios = usuarioRepository.todos();
	}

	public void salvar() throws NegocioException {
		FacesContext context = FacesContext.getCurrentInstance();

		if (sugestao == null) {
			throw new NegocioException("Sugestao invalida inválido!");
		}
		
		sugestao.setEstado(this.estadoPadrão());

		this.cadastro.salvar(sugestao);

		this.sugestao = new Sugestao();
		context.addMessage(null, new FacesMessage("Sugestão salva com sucesso!"));
	}
	
	private EstadoSugestao estadoPadrão(){
		return this.sugestao.getEstado() == null ? EstadoSugestao.EM_ANALISE : this.sugestao.getEstado();
	}

	public Sugestao getSugestao() {
		return sugestao;
	}

	public void setSugestao(Sugestao sugestao) {
		this.sugestao = sugestao;
	}

	public List<Usuario> getTodosUsuarios() {
		return todosUsuarios;
	}

	public EstadoSugestao[] getEstadoSugestoes() {
		return EstadoSugestao.values();
	}
}
