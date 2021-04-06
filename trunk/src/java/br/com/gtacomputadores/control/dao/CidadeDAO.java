package br.com.gtacomputadores.control.dao;


import br.com.gtacomputadores.control.model.Cidade;
import java.util.List;

public interface CidadeDAO
{

    public abstract void save(Cidade cidade);

    public abstract Cidade procuraCidadeCodigo(long l);

    public abstract List list();

    public abstract List buscaNome(String s);

    public abstract void remove(Cidade cidade);

    public abstract void update(Cidade cidade);
}