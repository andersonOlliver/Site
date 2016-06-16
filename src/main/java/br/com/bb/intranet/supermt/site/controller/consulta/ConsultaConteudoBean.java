package br.com.bb.intranet.supermt.site.controller.consulta;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.bb.intranet.supermt.site.model.Conteudo;
import br.com.bb.intranet.supermt.site.repository.Conteudos;
import br.com.bb.intranet.supermt.site.repository.filter.FiltroConteudo;

@Named
@ViewScoped
public class ConsultaConteudoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Conteudos conteudosRepository;

	private FiltroConteudo filtro = new FiltroConteudo();
	private LazyDataModel<Conteudo> model;

	public void consultar() {
		model = new LazyDataModel<Conteudo>() {

			private static final long serialVersionUID = 1L;

			public List<Conteudo> load(int first, int pageSize, String sortField, SortOrder sortOrder,
					Map<String, Object> filters) {

				filtro.setPrimeiroRegistro(first);
				filtro.setQuantidadeRegistros(pageSize);
				filtro.setAscendente(SortOrder.ASCENDING.equals(sortOrder));
				filtro.setPropriedadeOrdenacao(sortField);

				setRowCount(conteudosRepository.quantidadeFiltrados(filtro));

				return conteudosRepository.filtrados(filtro);
			}

		};
	}

	public FiltroConteudo getFiltro() {
		return filtro;
	}

	public LazyDataModel<Conteudo> getModel() {
		return model;
	}

}
