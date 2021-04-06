package br.com.gtacomputadores.control.dao;

import br.com.gtacomputadores.control.model.Cidade;
import br.com.gtacomputadores.control.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.*;

// Referenced classes of package br.com.gtacomputadores.control.dao:
//            CidadeDAO
public class CidadeDAOHibernate
        implements CidadeDAO {

    public CidadeDAOHibernate() {
    }

    @Override
    public void save(Cidade cidade) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        session.save(cidade);
        session.flush();
        t.commit();
    }

    @Override
    public Cidade procuraCidadeCodigo(long codigo) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        List listaCidade = new ArrayList();
        Query query = session.createQuery("from Cidade c where c.codigo =:codigo");
        query.setLong("codigo", codigo);
        listaCidade = query.list();
        if (listaCidade.size() > 0) {
            t.commit();
            return (Cidade) listaCidade.get(0);
        } else {
            t.rollback();
            return null;
        }
    }

    @Override
    public List list() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Cidade c").list();
        t.commit();
        return lista;
    }

    @Override
    public void remove(Cidade cidade) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        session.delete(cidade);
        t.commit();
    }

    @Override
    public void update(Cidade cidade) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        session.update(cidade);
        session.flush();
        t.commit();
    }

    public List buscaNome(String busca) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Query query = session.createQuery("from Cidade c where c.nome like :busca");
        List list = query.setString("busca", (new StringBuilder()).append("%").append(busca).append("%").toString()).list();
        return list;
    }
}
