package br.com.gtacomputadores.control.controller;

import br.com.gtacomputadores.control.dao.UsuarioDAOHibernate;
import br.com.gtacomputadores.control.dao.UsuarioDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import br.com.gtacomputadores.control.model.Usuario;
import br.com.gtacomputadores.control.utils.UtilRelatorios;
import java.io.Serializable;
import java.util.HashMap;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean(name = "usuarioBean")
@RequestScoped
public class UsuarioController implements Serializable {

    public UsuarioController() {
    }

    public UsuarioController(DataModel listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    private Usuario usuario = new Usuario();
    private DataModel listaUsuarios;

    //   public List getListarUsuarios() {
    public DataModel getListarUsuarios() {
        List<Usuario> lista = new UsuarioDAOHibernate().list();
        listaUsuarios = new ListDataModel(lista);
        return listaUsuarios;

    }

    public List getUsuarios() {
        List<Usuario> lista = new UsuarioDAOHibernate().list();
        return lista;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String prepararAdicionarUsuario() {
        usuario = new Usuario();
        return "usuario";
    }

    public String prepararAlterarUsuario() {
        usuario = (Usuario) (listaUsuarios.getRowData());
//        listaUsuarios = new ListDataModel (this.getListarUsuarios());
//        usuario = (Usuario) listaUsuarios.getRowData());  
        return "usuario";
    }

    public String excluirUsuario() {
        Usuario usuarioTemp = (Usuario) (listaUsuarios.getRowData());
        UsuarioDAO dao = new UsuarioDAOHibernate();
        dao.remove(usuarioTemp);
        prepararAdicionarUsuario();
        return "usuario";
    }

    public String adicionarUsuario() {

        UsuarioDAO dao = new UsuarioDAOHibernate();
        Integer codigo = usuario.getCodigo();
        if (codigo == null || codigo == 0) {
            dao.save(usuario);
            prepararAdicionarUsuario();
        } else {
            dao.update(usuario);
        }

        return "usuario";
    }

    public String alterarUsuario() {
        UsuarioDAO dao = new UsuarioDAOHibernate();
        dao.update(usuario);
        return "usuario";
    }

    public void relatorio() {
        UsuarioDAO dao = new UsuarioDAOHibernate();
        HashMap parametros = new HashMap();
        UtilRelatorios.imprimeRelatorio("user", parametros, dao.list());
    }
  

}
