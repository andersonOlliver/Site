package br.com.bb.intranet.supermt.site.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.bb.intranet.supermt.site.model.Tag;
import br.com.bb.intranet.supermt.site.repository.Tags;

@FacesConverter(forClass = Tag.class)
public class TagConverter implements Converter {

	@Inject
	private Tags tags;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		// TODO Auto-generated method stub
		Tag retorno = null;

		if (value != null && !"".equals(value)) {
			retorno = this.tags.porId(new Long(value));
		}

		return retorno;

	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		// TODO Auto-generated method stub
		if (value != null) {
			return ((Tag) value).getId().toString();
		}
		return null;
	}
}
