package br.com.gtacomputadores.control.dao;

import java.util.List;
import org.hibernate.Session;
import br.com.gtacomputadores.control.model.Usuario;
import br.com.gtacomputadores.control.utils.HibernateUtil;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Transaction;

public class UsuarioDAOHibernate implements UsuarioDAO {

    @Override
    public void save(Usuario usuario) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        session.save(usuario);
        session.flush();
        t.commit();

    }

    @Override
    public Usuario procuraUsuarioCodigo(long codigo) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        List<Usuario> listaUsuario = new ArrayList<>();
        Query query = session.createQuery("from Usuario u where u.codigo =:codigo");
        query.setLong("codigo", codigo);
        listaUsuario = query.list();
        if (listaUsuario.size() > 0) {
            t.commit();
            return listaUsuario.get(0);
        } else {
            t.rollback();
            return null;
        }
    }

    @Override
    public List<Usuario> list() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Usuario").list();
        t.commit();
        return lista;
    }

    @Override
    public void remove(Usuario usuario) {
        // Session session = HibernateUtil.getSessionFactory().openSession();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        session.delete(usuario);
        t.commit();
    }

    @Override
    public void update(Usuario usuario) {
        //Session session = HibernateUtil.getSessionFactory().openSession();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        session.update(usuario);
        session.flush();
        t.commit();
    }
    


}
