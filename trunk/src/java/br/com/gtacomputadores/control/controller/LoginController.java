package br.com.gtacomputadores.control.controller;

import br.com.gtacomputadores.control.dao.LoginDAOHibernate;
import br.com.gtacomputadores.control.model.Login;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Jeandro
 */
@ManagedBean(name = "loginBean")
@RequestScoped

public class LoginController implements Serializable {

    private LoginDAOHibernate Dao = new LoginDAOHibernate();
     private Login login = new Login();

    public LoginDAOHibernate getDao() {
        return Dao;
    }

    public void setDao(LoginDAOHibernate Dao) {
        this.Dao = Dao;
    }

   
    public List  getListar() {
        List<Login> lista = Dao.list();
        return lista;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    

}
