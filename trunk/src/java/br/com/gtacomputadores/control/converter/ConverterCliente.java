/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.gtacomputadores.control.converter;

import br.com.gtacomputadores.control.dao.ClienteDAOHibernate;
import br.com.gtacomputadores.control.model.Cliente;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;



/**
 *
 * @author Jeandro
 */
@FacesConverter(forClass = Cliente.class)
public class ConverterCliente implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && !value.equals("")) {
           return new ClienteDAOHibernate().procuraClienteCodigo(Long.parseLong(value));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Cliente cliente;
        cliente = (Cliente) value;
        return String.valueOf(cliente.getCodigo());
    }
    
}
