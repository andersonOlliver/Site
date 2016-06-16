package br.com.bb.intranet.supermt.site.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.bb.intranet.supermt.site.model.Menu;
import br.com.bb.intranet.supermt.site.repository.Menus;

@FacesConverter(forClass = Menu.class)
public class MenuConverter implements Converter {
	
	@Inject
	private Menus menus;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		// TODO Auto-generated method stub
		Menu retorno = null;
		
		if (value != null && !"".equals(value)) {
			retorno = this.menus.porId(new Long(value));
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		// TODO Auto-generated method stub
		if (value != null) {
			return ((Menu) value).getId().toString();
		}
		
		return null;
	}

	
}
