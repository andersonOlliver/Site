package br.com.bb.intranet.supermt.site.controller.consulta;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.bb.intranet.supermt.site.model.Conteudo;
import br.com.bb.intranet.supermt.site.repository.Noticias;
import br.com.bb.intranet.supermt.site.repository.filter.FiltroNoticia;

public class ConsultaNoticiaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Noticias noticiasRepository;
	
	private FiltroNoticia filtro = new FiltroNoticia();
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

				setRowCount(noticiasRepository.quantidadeFiltrados(filtro));

				return noticiasRepository.filtrados(filtro);
			}

		};
	}

	public FiltroNoticia getFiltro() {
		return filtro;
	}

	public LazyDataModel<Conteudo> getModel() {
		return model;
	}

}
