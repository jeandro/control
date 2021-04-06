/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.gtacomputadores.control.converter;

import br.com.gtacomputadores.control.dao.AgendaDAOHibernate;
import br.com.gtacomputadores.control.model.Agenda;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;



/**
 *
 * @author Jeandro
 */
@FacesConverter(forClass = Agenda.class)
public class ConverterAgenda implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && !value.equals("")) {
           return new AgendaDAOHibernate().procuraAgendaCodigo(Long.parseLong(value));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Agenda agenda;
        agenda = (Agenda) value;
        return String.valueOf(agenda.getCodigo());
    }
    
}
