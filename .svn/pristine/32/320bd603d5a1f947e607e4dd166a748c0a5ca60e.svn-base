package br.com.gtacomputadores.control.controller;

import br.com.gtacomputadores.control.dao.CidadeDAO;
import br.com.gtacomputadores.control.dao.CidadeDAOHibernate;
import br.com.gtacomputadores.control.model.Cidade;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean(name="cidadeBean")
@RequestScoped
public class CidadeController
    implements Serializable
{
    
    
    private Cidade cidade;
    private DataModel listaCidades;
    private String keySeach;

    public String getKeySeach()
    {
        return keySeach;
    }

    public void setKeySeach(String keySeach)
    {
        this.keySeach = keySeach;
    }

    public CidadeController()
    {
        cidade = new Cidade();
    }

    public DataModel getListarCidades()
    {
        List lista = (new CidadeDAOHibernate()).list();
        listaCidades = new ListDataModel(lista);
        return listaCidades;
    }

    public List getListar()
    {
        List lista = (new CidadeDAOHibernate()).list();
        return lista;
    }

    public Cidade getCidade()
    {
        return cidade;
    }

    public void setCidade(Cidade cidade)
    {
        this.cidade = cidade;
    }

    public String prepararAdicionarCidade()
    {
        cidade = new Cidade();
        return "cidade";
    }

    public String excluirCidade()
    {
        Cidade cidadeTemp = (Cidade)(Cidade)listaCidades.getRowData();
        CidadeDAO dao = new CidadeDAOHibernate();
        dao.remove(cidadeTemp);
        prepararAdicionarCidade();
        return "cidade";
    }

    public String adicionarCidade()
    {
        CidadeDAO dao = new CidadeDAOHibernate();
        Integer codigo = cidade.getCodigo();
        if(codigo == null || codigo.intValue() == 0)
        {
            dao.save(cidade);
            prepararAdicionarCidade();
        } else
        {
            dao.update(cidade);
        }
        return "cidade";
    }

    public String prepararAlterarCidade()
    {
        cidade = (Cidade)(Cidade)listaCidades.getRowData();
        return "cidade";
    }

    public String alterarCidade()
    {
        CidadeDAO dao = new CidadeDAOHibernate();
        dao.update(cidade);
        return "cidade";
    }

    public DataModel getbuscaNome()
    {
        CidadeDAO idao = new CidadeDAOHibernate();
        listaCidades = new ListDataModel(idao.buscaNome(keySeach));
        return listaCidades;
    }

}
