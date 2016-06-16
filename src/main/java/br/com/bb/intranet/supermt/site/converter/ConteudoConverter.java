package br.com.bb.intranet.supermt.site.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.bb.intranet.supermt.site.model.Conteudo;
import br.com.bb.intranet.supermt.site.repository.Conteudos;

@FacesConverter(forClass = Conteudo.class)
public class ConteudoConverter implements Converter {

	@Inject
	private Conteudos conteudos;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Conteudo retorno = null;
		
		if (value != null && !"".equals(value)) {
			retorno = this.conteudos.porId(new Long(value));
		}

		return retorno;
	}
	
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if (value != null) {
			return ((Conteudo) value).getId().toString();
		}
		return null;
	}
}
