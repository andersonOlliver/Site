package br.com.bb.intranet.supermt.site.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.bb.intranet.supermt.site.model.Noticia;
import br.com.bb.intranet.supermt.site.repository.Noticias;

@FacesConverter(forClass = Noticia.class)
public class NoticiaConverter implements Converter {

	@Inject
	private Noticias noticias;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Noticia retorno = null;

		if (value != null && !"".equals(value)) {
			retorno = this.noticias.porId(new Long(value));
		}

		return retorno;
	}
	
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return ((Noticia) value).getId().toString();
		}
		return null;
	}
}
