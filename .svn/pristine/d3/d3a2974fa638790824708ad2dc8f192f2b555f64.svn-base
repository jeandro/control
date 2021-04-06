package br.com.gtacomputadores.control.controller;

import br.com.gtacomputadores.control.converter.ConverterUsuario;
import br.com.gtacomputadores.control.dao.AgendaDAO;
import br.com.gtacomputadores.control.dao.AgendaDAOHibernate;
import br.com.gtacomputadores.control.model.Agenda;
import br.com.gtacomputadores.control.utils.UtilRelatorios;
import br.com.gtacomputadores.control.utils.EmailUtil;
import br.com.gtacomputadores.control.utils.UtilException;
import br.com.gtacomputadores.control.utils.TextoUtil;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.swing.text.BadLocationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author Jeandro
 */
@ManagedBean(name = "agendaBean")
@RequestScoped

public class AgendaController implements Serializable {

    private AgendaDAOHibernate Dao = new AgendaDAOHibernate();

    public AgendaDAOHibernate getDao() {
        return Dao;
    }

    public void setDao(AgendaDAOHibernate Dao) {
        this.Dao = Dao;
    }

    private Integer verificaControle;

    public Integer getVerificaControle() {
        return verificaControle;
    }

    public void setVerificaControle(Integer verificaControle) {
        this.verificaControle = verificaControle;
    }
    private Agenda agenda = new Agenda();
    private DataModel listaAgendas;
    private String keySeach;
    private List<Agenda> agendas = new ArrayList<Agenda>();
    private boolean podeeditar;

    public boolean isPodeeditar() {
        return podeeditar;
    }

    public void setPodeeditar(boolean podeeditar) {
        this.podeeditar = podeeditar;
    }

    public List<Agenda> getAgendas() {
        return agendas;
    }

    private ConverterUsuario converterCliente;

    public ConverterUsuario getConverterCliente() {
        return converterCliente;
    }

    public void setConverterCliente(ConverterUsuario converterCliente) {
        this.converterCliente = converterCliente;
    }

    public String getKeySeach() {
        return keySeach;
    }

    public void setKeySeach(String keySeach) {
        this.keySeach = keySeach;
    }

    /**
     * Creates a new instance of ClienteController
     */
    public AgendaController() {

    }

    public List getlistar() {
        List<Agenda> lista = Dao.listar();
        return lista;
    }

    public DataModel getListarAgendas2() {
        listaAgendas = new ListDataModel(Dao.listar());

        return listaAgendas;
    }

    public String setarpesquisa() {
        agenda = (Agenda) (listaAgendas.getRowData());
        return "informacoes";
    }

    public DataModel getListaAgendas() {
        return listaAgendas;
    }

    public void setListaAgendas(DataModel listaAgendas) {
        this.listaAgendas = listaAgendas;
    }

    public DataModel getListarAgendas() {
        List<Agenda> lista = new AgendaDAOHibernate().list();
        listaAgendas = new ListDataModel(lista);
        return listaAgendas;
    }

    public DataModel getListaEsperas() {
        List<Agenda> lista = new AgendaDAOHibernate().listaesperas();
        listaAgendas = new ListDataModel(lista);
        return listaAgendas;
    }

    public DataModel getListaProtocolo() {
        List<Agenda> lista = new AgendaDAOHibernate().listaprotocolo();
        listaAgendas = new ListDataModel(lista);
        return listaAgendas;
    }

    public Agenda getAgenda() {
        return this.agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public String prepararAdicionarAgenda() {
        agenda = new Agenda();
        podeeditar = false;
        return "agenda";
    }

    public String excluirAgenda() {
        Agenda agendaTemp = (Agenda) (listaAgendas.getRowData());
        AgendaDAO dao = new AgendaDAOHibernate();
        dao.remove(agendaTemp);
        prepararAdicionarAgenda();
        return "agenda";
    }

    public String adicionarAgenda() throws UtilException, IOException, BadLocationException {
        AgendaDAO dao = new AgendaDAOHibernate();
        Integer codigo = agenda.getCodigo();
        TextoUtil textoutil = new TextoUtil();

        if (codigo == null || codigo == 0) {
            agenda.setStatus("ESPERA");
            Random r = new Random();
            agenda.setControle(r.nextInt(100000));
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            agenda.setUsuarioagendamento(auth.getName());
            agenda.setData_hora_usuarioagendamento(new Date());
            dao.save(agenda);
            //       this.relatorio_protocolo_email(agenda.getCodigo());

            String Menss = textoutil.MontaEmail(agenda);

            Thread thr1 = new Thread(new EmailUtil(Menss, "Protocolo de Atendimento Nº " + agenda.getCodigo().toString(), agenda.getClienteagenda().getEmail(), "correiaegomes@gmail.com", agenda.getClienteagenda().getNomeFantasia()), "Thread #1");

            new Thread(thr1).start();

            prepararAdicionarAgenda();

        } else {

            dao.update(agenda);
            //   this.relatorio_protocolo_email(codigo);
            String Menss = textoutil.MontaEmail(agenda);

            Thread thr2 = new Thread(new EmailUtil(Menss, "Protocolo de Atendimento Nº " + agenda.getCodigo().toString(), agenda.getClienteagenda().getEmail(), "correiaegomes@gmail.com", agenda.getClienteagenda().getNomeFantasia()), "Thread #2");

            new Thread(thr2).start();
        }

        return "agenda";
    }

//     public void relatorio_protocolo_email(int codigo) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        AgendaDAO dao = new AgendaDAOHibernate();
//        HashMap parametros = new HashMap();
//        parametros.put("IMPRESSO_POR", auth.getName());
//        List<Agenda> protocolo = new ArrayList<>();
//        UtilRelatorios.imprimeRelatorioEmail("protocolo_email", parametros, dao.protocolo(codigo));
//
//    }
    public void relatorio_protocolo(int codigo) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        AgendaDAO dao = new AgendaDAOHibernate();
        HashMap parametros = new HashMap();
        parametros.put("IMPRESSO_POR", auth.getName());
        List<Agenda> protocolo = new ArrayList<>();
        UtilRelatorios.imprimeRelatorio("protocolo", parametros, dao.protocolo(codigo));
        agenda.setUsuarioimpresao(auth.getName());
        agenda.setData_hora_usuarioimpresao(new Date());
        dao.update(agenda);
        prepararAdicionarAgenda();

    }

    public String prepararAlterarAgenda() {
        agenda = (Agenda) (listaAgendas.getRowData());
        podeeditar = false;
        return "agenda";

    }

    public String prepararFechamentoContatoAgenda() {

        agenda = (Agenda) (listaAgendas.getRowData());
        if ((agenda.getStatus()).equals("AGUARDANDO CONTATO")) {
            return "fechar_contato";
        } else {
            return "erro_status";
        }

    }

    public String prepararFechamentoAgenda() {
        agenda = (Agenda) (listaAgendas.getRowData());
        if ((agenda.getStatus()).equals("ESPERA")) {
            return "fechar_agenda";
        } else {
            return "erro_status";
        }

    }

    public String prepararFechamentoProtocolo() {
        agenda = (Agenda) (listaAgendas.getRowData());
        if ((agenda.getStatus()).equals("AGUARDANDO PROTOCOLO")) {
            return "/administrador/fechar_protocolo";
        } else {
            return "erro_status";
        }

    }

    public String mostraInformacoes() {
        return "/restrito/informacoes";
    }

    public void prepararPesquisaAgenda() {
        agenda = (Agenda) (listaAgendas.getRowData());

    }

    public String fecharAgenda() {
        if ((agenda.getControle()).equals(verificaControle)) {
            AgendaDAO dao = new AgendaDAOHibernate();
            agenda.setStatus("AGUARDANDO CONTATO");
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            agenda.setDataFim(new Date());
            agenda.setHoraFim(new Time(System.currentTimeMillis()));
            agenda.setUsuariofechamento(auth.getName());
            agenda.setData_hora_usuariofechamento(new Date());
            dao.update(agenda);
            TextoUtil textoutil = new TextoUtil();
            String Menss = textoutil.MontaEmail(agenda);

            Thread thr2 = new Thread(new EmailUtil(Menss, "Protocolo de Atendimento Nº " + agenda.getCodigo().toString(), agenda.getClienteagenda().getEmail(), "correiaegomes@gmail.com", agenda.getClienteagenda().getNomeFantasia()), "Thread #2");

            new Thread(thr2).start();

            return "principal";
        } else {
            return "erro_status";
        }

    }

    public String fecharAgendaContato() {
        if ((agenda.getControle()).equals(verificaControle)) {
            AgendaDAO dao = new AgendaDAOHibernate();
            agenda.setStatus("AGUARDANDO PROTOCOLO");
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            agenda.setDataContato(new Date());
            agenda.setHoraContato(new Time(System.currentTimeMillis()));
            agenda.setUsuariocontato(auth.getName());
            agenda.setData_hora_usuariocontato(new Date());
            dao.update(agenda);
            TextoUtil textoutil = new TextoUtil();
            String Menss = textoutil.MontaEmail(agenda);

            Thread thr2 = new Thread(new EmailUtil(Menss, "Protocolo de Atendimento Nº " + agenda.getCodigo().toString(), agenda.getClienteagenda().getEmail(), "correiaegomes@gmail.com", agenda.getClienteagenda().getNomeFantasia()), "Thread #2");

            new Thread(thr2).start();

            return "principal";
        } else {
            return "erro_status";
        }
    }

    public String fecharAgendaProtocolo() {
        AgendaDAO dao = new AgendaDAOHibernate();
        agenda.setStatus("RESOLVIDO");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        agenda.setUsuarioprotocolo(auth.getName());
        agenda.setData_hora_usuarioprotocolo(new Date());
        dao.update(agenda);
        TextoUtil textoutil = new TextoUtil();
        String Menss = textoutil.MontaEmail(agenda);

        Thread thr2 = new Thread(new EmailUtil(Menss, "Protocolo de Atendimento Nº " + agenda.getCodigo().toString(), agenda.getClienteagenda().getEmail(), "correiaegomes@gmail.com", agenda.getClienteagenda().getNomeFantasia()), "Thread #2");

        new Thread(thr2).start();

        return "/administrador/index";
    }

    public String alterarAgenda() {
        AgendaDAO dao = new AgendaDAOHibernate();
        dao.update(agenda);
        return "agenda";
    }

}
