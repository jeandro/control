package br.com.gtacomputadores.control.dao;

import java.util.List;
import br.com.gtacomputadores.control.model.Cliente;

/**
 *
 * @author Jeandro
 */

public interface ClienteDAO {

    public void save(Cliente cliente);

    public Cliente procuraClienteCodigo(long codigo);

    public List<Cliente> list();
    
    public List<String> buscaFantasia(String busca);

    public void remove(Cliente cliente);

    public void update(Cliente cliente);

}
