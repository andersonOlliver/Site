package br.com.bb.intranet.supermt.site.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.bb.intranet.supermt.site.model.Registro;
import br.com.bb.intranet.supermt.site.repository.Registros;

@FacesConverter(forClass = Registro.class)
public class CadastroConverter implements Converter {

    @Inject
    private Registros cadastros;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        // TODO Auto-generated method stub
        Registro retorno = null;

        if (value != null && !"".equals(value)) {
            retorno = this.cadastros.porId(new Long(value));
        }

        return retorno;

    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        // TODO Auto-generated method stub
        if (value != null) {
            return ((Registro) value).getId().toString();
        }
        return null;
    }
}
