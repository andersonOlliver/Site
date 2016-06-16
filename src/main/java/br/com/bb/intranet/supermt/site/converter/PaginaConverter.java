package br.com.bb.intranet.supermt.site.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.bb.intranet.supermt.site.model.Pagina;
import br.com.bb.intranet.supermt.site.repository.Paginas;

@FacesConverter(forClass = Pagina.class)
public class PaginaConverter implements Converter{
	
	@Inject
	private Paginas paginas;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		// TODO Auto-generated method stub
		Pagina retorno = null;
		
		if(value != null && !"".equals(value)){
			retorno = this.paginas.porId(new Long(value));
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		// TODO Auto-generated method stub
		if(value != null){
			return ((Pagina) value).getId().toString();
		}
		return null;
	}

}
