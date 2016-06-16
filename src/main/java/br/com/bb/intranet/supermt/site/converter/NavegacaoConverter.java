package br.com.bb.intranet.supermt.site.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.bb.intranet.supermt.site.model.Acesso;
import br.com.bb.intranet.supermt.site.repository.Acessos;

@FacesConverter(forClass = Acesso.class)
public class NavegacaoConverter implements Converter {

	@Inject
	private Acessos navegacoes;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		Acesso retorno = null;

		if (value != null && !"".equals(value)) {
			retorno = this.navegacoes.porId(new Long(value));
		}

		return retorno;
	}
	
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		// TODO Auto-generated method stub
		if (value != null) {
			return ((Acesso) value).getId().toString();
		}
		return null;
	}
}
