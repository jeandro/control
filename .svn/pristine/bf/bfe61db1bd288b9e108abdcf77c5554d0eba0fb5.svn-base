package br.com.gtacomputadores.control.dao;

import br.com.gtacomputadores.control.model.Agenda;
import br.com.gtacomputadores.control.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Jeandro
 */
public class AgendaDAOHibernate implements AgendaDAO {

    private String filtro = "";

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

    @Override
    public void save(Agenda agenda) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        session.save(agenda);
        session.flush();
        t.commit();

    }

    public List<Agenda> listar() {
        String where = "";
        if (filtro.length() > 0) {
            where = "from Agenda a where a.clienteagenda.nomeFantasia LIKE '"
                    + filtro.toUpperCase() + "%' order by a.dataInicio desc ";
        } else {

            where = "from Agenda a order by a.dataInicio desc ";
        }

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        List<Agenda> listaAgenda = new ArrayList<>();
        Query query = session.createQuery(where);

        listaAgenda = query.list();
        t.commit();
        return listaAgenda;

    }

    @Override
    public Agenda procuraAgendaCodigo(long codigo) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        List<Agenda> listaAgenda = new ArrayList<>();
        Query query = session.createQuery("from Agenda a where a.codigo =:codigo");
        query.setLong("codigo", codigo);
        listaAgenda = query.list();
        if (listaAgenda.size() > 0) {
            t.commit();
            return listaAgenda.get(0);
        } else {
            t.rollback();
            return null;
        }
    }

    @Override
    public List<Agenda> list() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Agenda a order by a.status").list();
        t.commit();
        return lista;
    }

    public List<Agenda> listaesperas() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
  //      List lista = session.createQuery("from Agenda a join fetch a.clienteagenda join fetch a.usuarioagenda ").list();    
        
        List lista = session.createQuery("from Agenda a join fetch a.clienteagenda "
                + "join fetch a.usuarioagenda "
                + "where a.status <> 'RESOLVIDO' and "
                + "a.status <> 'AGUARDANDO PROTOCOLO' "
                + "order by a.dataInicio").list();
        t.commit();
        return lista;
    }
    
       public List<Agenda> listaprotocolo() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
  //      List lista = session.createQuery("from Agenda a join fetch a.clienteagenda join fetch a.usuarioagenda ").list();    
        
        List lista = session.createQuery("from Agenda a join fetch a.clienteagenda "
                + "join fetch a.usuarioagenda "
                + "where a.status = 'AGUARDANDO PROTOCOLO' "
                + "order by a.dataInicio").list();
        t.commit();
        return lista;
    }

    @Override
    public void remove(Agenda agenda) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        session.delete(agenda);
        t.commit();
    }

    @Override
    public void update(Agenda agenda) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        session.update(agenda);
        session.flush();
        t.commit();
    }

    @Override
    public List<Agenda> protocolo(long codigo) {
          Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        List<Agenda> listaAgenda = new ArrayList<>();
        Query query = session.createQuery("from Agenda a where a.codigo =:codigo");
        query.setLong("codigo", codigo);
        listaAgenda = query.list();
        if (listaAgenda.size() > 0) {
            t.commit();
            return listaAgenda;
        } else {
            t.rollback();
            return null;
        }
    }

    
}
