package br.com.bb.intranet.supermt.site.controller.consulta;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.bb.intranet.supermt.site.model.Sugestao;
import br.com.bb.intranet.supermt.site.repository.Sugestoes;
import br.com.bb.intranet.supermt.site.repository.filter.FiltroSugestao;

@Named
@ViewScoped
public class ConsultaSugestaoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Sugestoes sugestaoRepository;
	
	private List<Sugestao> sugestoes;
	private FiltroSugestao filtro = new FiltroSugestao();
	private LazyDataModel<Sugestao> model;
	private Sugestao sugestaoSelecionada;
	
	public void consultar(){
		model = new LazyDataModel<Sugestao>() {
			
			private static final long serialVersionUID = 1L;
			
			public List<Sugestao> load(int first, int pageSize, String sortField, SortOrder sortOrder,
					Map<String, Object> filters) {
				
				filtro.setPrimeiroRegistro(first);
				filtro.setQuantidadeRegistros(pageSize);
				filtro.setAscendente(SortOrder.ASCENDING.equals(sortOrder));
				filtro.setPropriedadeOrdenacao(sortField);
				
				setRowCount(sugestaoRepository.quantidadeFiltrados(filtro));
				
				return sugestaoRepository.filtrados(filtro);
			}

		};
	}

	public List<Sugestao> getSugestoes() {
		return sugestoes;
	}

	public void setSugestoes(List<Sugestao> sugestoes) {
		this.sugestoes = sugestoes;
	}

	public Sugestao getSugestaoSelecionada() {
		return sugestaoSelecionada;
	}

	public void setSugestaoSelecionada(Sugestao sugestaoSelecionada) {
		this.sugestaoSelecionada = sugestaoSelecionada;
	}

	public FiltroSugestao getFiltro() {
		return filtro;
	}

	public LazyDataModel<Sugestao> getModel() {
		return model;
	}

	
}
