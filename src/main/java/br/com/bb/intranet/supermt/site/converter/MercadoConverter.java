package br.com.bb.intranet.supermt.site.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import br.com.bb.intranet.supermt.site.model.Mercado;
import br.com.bb.intranet.supermt.site.repository.Mercados;

@FacesConverter(forClass = Mercado.class)
public class MercadoConverter implements Converter {

	@Inject
	private Mercados mercados;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Mercado retorno = null;
		
		if(value!= null && StringUtils.isNotEmpty(value)){
			retorno = this.mercados.porId(new Long(value));
		}
		
		return retorno;
		
	}
	
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null){
			return ((Mercado) value).getId().toString();
		}
		
		return null;
	}
}
