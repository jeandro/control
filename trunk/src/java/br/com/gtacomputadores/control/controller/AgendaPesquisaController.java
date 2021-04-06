package br.com.gtacomputadores.control.controller;

import br.com.gtacomputadores.control.converter.ConverterUsuario;
import br.com.gtacomputadores.control.dao.AgendaDAOHibernate;
import br.com.gtacomputadores.control.model.Agenda;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
/**
 *
 * @author Jeandro
 */
@ManagedBean(name = "agendaPesquisaBean")
@SessionScoped

public class AgendaPesquisaController implements Serializable {

    private AgendaDAOHibernate Dao = new AgendaDAOHibernate();

    public AgendaDAOHibernate getDao() {
        return Dao;
    }

    public void setDao(AgendaDAOHibernate Dao) {
        this.Dao = Dao;
    }
    
    
    private Agenda agenda = new Agenda();

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public DataModel getListaAgendas() {
        return listaAgendas;
    }

    public void setListaAgendas(DataModel listaAgendas) {
        this.listaAgendas = listaAgendas;
    }
    private DataModel listaAgendas;
//    private String keySeach;

    private ConverterUsuario converterCliente;

    public ConverterUsuario getConverterCliente() {
        return converterCliente;
    }

    public void setConverterCliente(ConverterUsuario converterCliente) {
        this.converterCliente = converterCliente;
    }



    /**
     * Creates a new instance of ClienteController
     */
    public AgendaPesquisaController() {

    }

    public DataModel getListarAgendas2() {
        listaAgendas = new ListDataModel(Dao.listar());
       
        return listaAgendas;
    }
    
        public String setarpesquisa() {
        agenda = (Agenda) (listaAgendas.getRowData());
        return "informacoes_pesquisa_agenda";
    }
 
    
//         public void setarpesquisa() {
//        agenda = (Agenda) (listaAgendas.getRowData());
//    }

    
}