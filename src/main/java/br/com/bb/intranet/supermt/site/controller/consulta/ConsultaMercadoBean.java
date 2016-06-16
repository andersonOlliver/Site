package br.com.bb.intranet.supermt.site.controller.consulta;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bb.intranet.supermt.site.model.Mercado;
import br.com.bb.intranet.supermt.site.repository.Mercados;

@Named
@ViewScoped
public class ConsultaMercadoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Mercados mercadosRepository;
	
	private List<Mercado> mercados;
	
	public void consultar(){
		this.mercados = mercadosRepository.todos();
	}

	public List<Mercado> getMercados() {
		return mercados;
	}
	
}
