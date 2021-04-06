/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gtacomputadores.control.controller;

import br.com.gtacomputadores.control.converter.ConverterCidade;
import br.com.gtacomputadores.control.dao.ClienteDAO;
import br.com.gtacomputadores.control.dao.ClienteDAOHibernate;
import br.com.gtacomputadores.control.model.Cliente;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Jeandro
 */
@ManagedBean(name = "clienteBean")
@RequestScoped
public class ClienteController implements Serializable {

    private Cliente cliente = new Cliente();
    private DataModel listaClientes;
    private String keySeach;

    private ConverterCidade converterCidade;

    public ConverterCidade getConverterCidade() {
        return converterCidade;
    }

    public void setConverterCidade(ConverterCidade converterCidade) {
        this.converterCidade = converterCidade;
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
    public ClienteController() {

    }

//    public DataModel getListarClientes() {
//        List<Cliente> lista = new ClienteDAOHibernate().list();
//        listaClientes = new ListDataModel(lista);
//        return listaClientes;
//    }
    public DataModel getListarClientesFisico() {
        List<Cliente> lista = new ClienteDAOHibernate().listFisico();
        listaClientes = new ListDataModel(lista);
        return listaClientes;
    }

    public DataModel getListarClientesJuridico() {
        List<Cliente> lista = new ClienteDAOHibernate().listJuridico();
        listaClientes = new ListDataModel(lista);
        return listaClientes;
    }

    public List getListarClientes() {
        List<Cliente> lista = new ClienteDAOHibernate().list();
        return lista;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String prepararAdicionarCliente() {
        cliente = new Cliente();
        return "cliente_juridico";
    }

    public String prepararAdicionarClienteFisico() {
        cliente = new Cliente();
        return "cliente_fisico";
    }

    public String excluirCliente() {
        Cliente clienteTemp = (Cliente) (listaClientes.getRowData());
        ClienteDAO dao = new ClienteDAOHibernate();
        dao.remove(clienteTemp);
        prepararAdicionarCliente();
        return "cliente_juridico";
    }

    public String excluirClienteFisico() {
        Cliente clienteTemp = (Cliente) (listaClientes.getRowData());
        ClienteDAO dao = new ClienteDAOHibernate();
        dao.remove(clienteTemp);
        prepararAdicionarClienteFisico();
        return "cliente_fisico";
    }

    public String adicionarCliente() {
        ClienteDAO dao = new ClienteDAOHibernate();
        Integer codigo = cliente.getCodigo();
        if (codigo == null || codigo == 0) {
            dao.save(cliente);
            prepararAdicionarCliente();
        } else {
            dao.update(cliente);
        }

        return "cliente_juridico";
    }

    public String adicionarClienteFisico() {
        ClienteDAO dao = new ClienteDAOHibernate();
        Integer codigo = cliente.getCodigo();
        if (codigo == null || codigo == 0) {
            dao.save(cliente);
            prepararAdicionarClienteFisico();
        } else {
            dao.update(cliente);
        }

        return "cliente_fisico";
    }

    public String prepararAlterarCliente() {
        cliente = (Cliente) (listaClientes.getRowData());
        return "cliente_juridico";
    }

    public String prepararAlterarClienteFisico() {
        cliente = (Cliente) (listaClientes.getRowData());
        return "cliente_fisico";
    }

    public String alterarCliente() {
        ClienteDAO dao = new ClienteDAOHibernate();
        dao.update(cliente);
        return "cliente_juridico";
    }

    public String alterarClienteFisico() {
        ClienteDAO dao = new ClienteDAOHibernate();
        dao.update(cliente);
        return "cliente_fisico";
    }

    public DataModel getbuscaFantasias() {
        ClienteDAO idao = new ClienteDAOHibernate();
        listaClientes = new ListDataModel(idao.buscaFantasia(keySeach));
        return listaClientes;
    }  
            

    public String setarCliente() {
        cliente = (Cliente) (listaClientes.getRowData());
        return "cliente";
    }
}
