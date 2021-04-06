package br.com.gtacomputadores.control.dao;

import br.com.gtacomputadores.control.model.Login;
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
public class LoginDAOHibernate implements LoginDAO {




    @Override
    public List<Login> list() {
         String where = "";
 
            where = "from Login l order by l.id desc ";


        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        List<Login> listaLogin = new ArrayList<>();
        Query query = session.createQuery(where);

        listaLogin = query.list();
        t.commit();
        return listaLogin;
    }

    
}
