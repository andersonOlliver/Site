package br.com.bb.intranet.supermt.site.controller.consulta;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.bb.intranet.supermt.site.model.Usuario;
import br.com.bb.intranet.supermt.site.repository.Usuarios;
import br.com.bb.intranet.supermt.site.repository.filter.FiltroUsuario;
import br.com.bb.intranet.supermt.site.service.NegocioException;
import br.com.bb.intranet.supermt.site.service.cadastro.CadastroUsuarios;

@Named
@ViewScoped
public class ConsultaUsuariosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Usuarios usuariosRepository;
	
	@Inject
	private CadastroUsuarios cadastro;

	private List<Usuario> usuarios;
	private Usuario usuarioSelecionado;
	private FiltroUsuario filtro = new FiltroUsuario();
	private LazyDataModel<Usuario> model;

	public void consultar() {
		model = new LazyDataModel<Usuario>() {

			private static final long serialVersionUID = 1L;

			public List<Usuario> load(int first, int pageSize, String sortField, SortOrder sortOrder,
					Map<String, Object> filters) {

				filtro.setPrimeiroRegistro(first);
				filtro.setQuantidadeRegistros(pageSize);
				filtro.setAscendente(SortOrder.ASCENDING.equals(sortOrder));
				filtro.setPropriedadeOrdenacao(sortField);

				setRowCount(usuariosRepository.quantidadeFiltrados(filtro));

				return usuariosRepository.filtrados(filtro);
			}
		};
	}

	public void excluir(){
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
			this.cadastro.excluir(this.usuarioSelecionado);
			this.consultar();
			
			context.addMessage(null, new FacesMessage("Usuario excluído com sucesso!"));
		} catch (NegocioException e) {

			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public FiltroUsuario getFiltro() {
		return filtro;
	}

	public LazyDataModel<Usuario> getModel() {
		return model;
	}

	public Usuario getUsuarioSelecionado() {
		return usuarioSelecionado;
	}

	public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}

}
