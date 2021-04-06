/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.gtacomputadores.control.converter;

import br.com.gtacomputadores.control.dao.CidadeDAOHibernate;
import br.com.gtacomputadores.control.model.Cidade;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass=Cidade.class)
public class ConverterCidade
    implements Converter
{

    public ConverterCidade()
    {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value)
    {
        if(value != null && !value.equals(""))
            return new CidadeDAOHibernate().procuraCidadeCodigo(Long.parseLong(value));
        else
            return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value)
    {
        Cidade cidade = (Cidade)value;
        return String.valueOf(cidade.getCodigo());
    }
}
