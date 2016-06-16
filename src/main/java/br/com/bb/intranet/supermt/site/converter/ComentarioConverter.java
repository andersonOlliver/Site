package br.com.bb.intranet.supermt.site.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.bb.intranet.supermt.site.model.Comentario;
import br.com.bb.intranet.supermt.site.repository.Comentarios;

@FacesConverter(forClass = Comentario.class)
public class ComentarioConverter implements Converter {

	@Inject
	private Comentarios comentarios;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		// TODO Auto-generated method stub
		Comentario retorno = null;

		if (value != null && !"".equals(value)) {
			retorno = this.comentarios.porId(new Long(value));
		}

		return retorno;

	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		// TODO Auto-generated method stub
		if (value != null) {
			return ((Comentario) value).getId().toString();
		}
		return null;
	}
}
