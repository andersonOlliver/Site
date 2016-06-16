package br.com.bb.intranet.supermt.site.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.bb.intranet.supermt.site.model.Sugestao;
import br.com.bb.intranet.supermt.site.repository.Sugestoes;

@FacesConverter(forClass = Sugestao.class)
public class SugestaoConverter implements Converter {
	
	@Inject
	private Sugestoes sugestoes;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		Sugestao retorno = null;

		if (value != null && !"".equals(value)) {
			retorno = this.sugestoes.porId(new Long(value));
		}

		return retorno;
	}
	
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return ((Sugestao) value).getId().toString();
		}
		return null;
	}
}
