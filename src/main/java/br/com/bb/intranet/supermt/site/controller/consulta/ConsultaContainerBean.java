package br.com.bb.intranet.supermt.site.controller.consulta;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bb.intranet.supermt.site.model.Container;
import br.com.bb.intranet.supermt.site.repository.Containers;

@Named
@ViewScoped
public class ConsultaContainerBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Containers containersRepository;
	
	private List<Container> listaContainer;

	public void consultar(){
		this.listaContainer = containersRepository.todos();
	}
	
	public List<Container> getListaContainer() {
		return listaContainer;
	}

}
