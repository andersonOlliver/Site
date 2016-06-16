package br.com.bb.intranet.supermt.site.controller.consulta;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bb.intranet.supermt.site.model.Pagina;
import br.com.bb.intranet.supermt.site.repository.Paginas;

@Named
@ViewScoped
public class ConsultaPaginaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Paginas paginasRepository;
	
	private List<Pagina> listaPagina;
	
	public void consultar(){
		this.listaPagina = paginasRepository.todas();
	}

	public List<Pagina> getListaPagina() {
		return listaPagina;
	}
	

}
