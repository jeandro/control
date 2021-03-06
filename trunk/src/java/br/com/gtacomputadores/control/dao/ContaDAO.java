
package br.com.gtacomputadores.control.dao;

import br.com.gtacomputadores.control.model.Conta;
import java.util.List;

import br.com.gtacomputadores.control.model.Usuario;

public interface ContaDAO {

	public void salvar(Conta conta);

	public void excluir(Conta conta);

	public Conta carregar(Integer conta);

	public List<Conta> listar(Usuario usuario);

	public Conta buscarFavorita(Usuario usuario);
}
