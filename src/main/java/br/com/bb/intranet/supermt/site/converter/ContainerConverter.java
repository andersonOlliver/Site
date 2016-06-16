package br.com.bb.intranet.supermt.site.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.bb.intranet.supermt.site.model.Container;
import br.com.bb.intranet.supermt.site.repository.Containers;

@FacesConverter(forClass = Container.class)
public class ContainerConverter implements Converter {

	@Inject
	private Containers containers;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Container retorno = null;
		
		if(value != null && !"".equals(value)){
			retorno = this.containers.porId(new Long(value));
		}
		
		return retorno;
	}
	
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		// TODO Auto-generated method stub
		if (value != null) {
			return ((Container) value).getId().toString();
		}
		return null;
	}
}
