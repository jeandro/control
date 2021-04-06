package br.com.gtacomputadores.control.dao;

import br.com.gtacomputadores.control.model.Cliente;
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
public class ClienteDAOHibernate implements ClienteDAO {

    @Override
    public void save(Cliente cliente) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();

        session.save(cliente);
        session.flush();
        t.commit();

    }

    @Override
    public Cliente procuraClienteCodigo(long codigo) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        List<Cliente> listaCliente = new ArrayList<>();
        Query query = session.createQuery("from Cliente c where c.codigo =:codigo");
        query.setLong("codigo", codigo);
        listaCliente = query.list();
        if (listaCliente.size() > 0) {
            t.commit();
            return listaCliente.get(0);
        } else {
            t.rollback();
            return null;
        }

    }

    @Override
    public List<Cliente> list() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Cliente ORDER BY nomeFantasia ").list();
        t.commit();
        return lista;
    }

    public List<Cliente> listFisico() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Cliente c join fetch c.cidadecliente "
                + "WHERE c.inscricao = null  ORDER BY c.nomeFantasia ").list();
        t.commit();
        return lista;
    }

    public List<Cliente> listJuridico() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Cliente WHERE inscricao <> null  ORDER BY nomeFantasia ").list();
        t.commit();
        return lista;
    }

    @Override
    public void remove(Cliente cliente) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        session.delete(cliente);
        t.commit();
    }

    @Override
    public void update(Cliente cliente) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        session.update(cliente);
        session.flush();
        t.commit();

    }

    @Override
    public List<String> buscaFantasia(String busca) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        Query query = session.createQuery("from Cliente c where c.nomeFantasia like :busca");
        List list = query.setString("busca", "%" + busca + "%").list();
        t.commit();
        return list;
    }

 

    }
