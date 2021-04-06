/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gtacomputadores.control.controller;

import br.com.gtacomputadores.control.enums.TipoAvaliacao;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Jeandro
 */
@ManagedBean(name = "avaliacaoBean")
@RequestScoped
public class AvaliacaoController implements Serializable {
 
        //meu enum que será setado na view
    private TipoAvaliacao tipoAvaliacao;
    //aqui vamos fornecer a lista com todos os enums
    private List<TipoAvaliacao> todosTiposAvaliacao;
 
    public List<TipoAvaliacao> getTodosTiposAvaliacao() {
        //aqui retornamos a lista de enums
        return Arrays.asList(TipoAvaliacao.values());
    }

    public TipoAvaliacao getTipoAvaliacao() {
        return tipoAvaliacao;
    }

    public void setTipoAvaliacao(TipoAvaliacao tipoAvaliacao) {
        this.tipoAvaliacao = tipoAvaliacao;
    }
    
}
