/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gtacomputadores.control.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cidade implements Serializable
{
  private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Integer codigo;
    private String nome;
    private String codibge;
    
    public Cidade()
    {
    }

    public Integer getCodigo()
    {
        return codigo;
    }

    public void setCodigo(Integer codigo)
    {
        this.codigo = codigo;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getCodibge()
    {
        return codibge;
    }

    public void setCodibge(String codibge)
    {
        this.codibge = codibge;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(codigo);
        hash = 11 * hash + Objects.hashCode(nome);
        hash = 11 * hash + Objects.hashCode(codibge);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        Cidade other = (Cidade)obj;
        if(!Objects.equals(codigo, other.codigo))
            return false;
        if(!Objects.equals(nome, other.nome))
            return false;
        return Objects.equals(codibge, other.codibge);
    }

  
}
