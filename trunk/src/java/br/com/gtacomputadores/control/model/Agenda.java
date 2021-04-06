/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gtacomputadores.control.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import static java.util.Objects.equals;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Jeandro
 */
@Entity
public class Agenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Integer codigo;
    //private Integer cliente;
    @ManyToOne
    @JoinColumn(name = "idcliente", nullable = false)
    private Cliente clienteagenda;
    //private Integer responsavel;
    @ManyToOne
    @JoinColumn(name = "idresponsavel", nullable = false)
    private Usuario usuarioagenda;
    @Column(columnDefinition = "TEXT")
    private String problema;
    @Column(columnDefinition = "TEXT")
    private String solucao;
    private String status;
    private String usuarioagendamento;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date data_hora_usuarioagendamento;
    private String usuariofechamento;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date data_hora_usuariofechamento;
    private String usuariocontato;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date data_hora_usuariocontato;
    private String usuarioprotocolo;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date data_hora_usuarioprotocolo;
    private String usuarioavaliacaoatendimento;
    @Column(columnDefinition = "TEXT")
    private String obsavaliacaodoatendimento;
    private String avaliacaodoatendimento;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataInicio;
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date horaInicio;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataFim;
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date horaFim;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataContato;
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date horaContato;
    private String contato;
    private Integer controle;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date data_hora_usuarioimpresao;
    private String usuarioimpresao;

//-------------------------//
    public Date getData_hora_usuarioimpresao() {
        return data_hora_usuarioimpresao;
    }

    public void setData_hora_usuarioimpresao(Date data_hora_usuarioimpresao) {
        this.data_hora_usuarioimpresao = data_hora_usuarioimpresao;
    }

    public String getUsuarioimpresao() {
        if (null == usuarioimpresao) {
            return "";
        } else {
            return usuarioimpresao;
        }
    }

    public void setUsuarioimpresao(String usuarioimpresao) {
        this.usuarioimpresao = usuarioimpresao;
    }

    public Integer getControle() {
        return controle;
    }

    public void setControle(Integer controle) {
        this.controle = controle;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Cliente getClienteagenda() {
        return clienteagenda;
    }

    public void setClienteagenda(Cliente clienteagenda) {
        this.clienteagenda = clienteagenda;
    }

    public Usuario getUsuarioagenda() {
        return usuarioagenda;
    }

    public void setUsuarioagenda(Usuario usuarioagenda) {
        this.usuarioagenda = usuarioagenda;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public String getSolucao() {
        if (null == solucao) {
            return "";
        } else {
            return solucao;
        }
    }

    public void setSolucao(String solucao) {
        this.solucao = solucao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsuarioagendamento() {
        if (null == usuarioagendamento) {
            return "";
        } else {
            return usuarioagendamento;
        }
    }

    public void setUsuarioagendamento(String usuarioagendamento) {
        this.usuarioagendamento = usuarioagendamento;
    }

    public Date getData_hora_usuarioagendamento() {
        return data_hora_usuarioagendamento;
    }

    public void setData_hora_usuarioagendamento(Date data_hora_usuarioagendamento) {
        this.data_hora_usuarioagendamento = data_hora_usuarioagendamento;
    }

    public String getUsuariofechamento() {
        if (null == usuariofechamento) {
            return "";
        } else {
            return usuariofechamento;
        }
    }

    public void setUsuariofechamento(String usuariofechamento) {
        this.usuariofechamento = usuariofechamento;
    }

    public Date getData_hora_usuariofechamento() {
        return data_hora_usuariofechamento;
    }

    public void setData_hora_usuariofechamento(Date data_hora_usuariofechamento) {
        this.data_hora_usuariofechamento = data_hora_usuariofechamento;
    }

    public String getUsuariocontato() {
        if (null == usuariocontato) {
            return "";
        } else {
            return usuariocontato;
        }
    }

    public void setUsuariocontato(String usuariocontato) {
        this.usuariocontato = usuariocontato;
    }

    public Date getData_hora_usuariocontato() {
        return data_hora_usuariocontato;
    }

    public void setData_hora_usuariocontato(Date data_hora_usuariocontato) {
        this.data_hora_usuariocontato = data_hora_usuariocontato;
    }

    public String getUsuarioprotocolo() {
        if (null == usuarioprotocolo) {
            return "";
        } else {
            return usuarioprotocolo;
        }
    }

    public void setUsuarioprotocolo(String usuarioprotocolo) {
        this.usuarioprotocolo = usuarioprotocolo;
    }

    public Date getData_hora_usuarioprotocolo() {
        return data_hora_usuarioprotocolo;
    }

    public void setData_hora_usuarioprotocolo(Date data_hora_usuarioprotocolo) {
        this.data_hora_usuarioprotocolo = data_hora_usuarioprotocolo;
    }

    public String getUsuarioavaliacaoatendimento() {
        return usuarioavaliacaoatendimento;
    }

    public void setUsuarioavaliacaoatendimento(String usuarioavaliacaoatendimento) {
        this.usuarioavaliacaoatendimento = usuarioavaliacaoatendimento;
    }

    public String getObsavaliacaodoatendimento() {
        return obsavaliacaodoatendimento;
    }

    public void setObsavaliacaodoatendimento(String obsavaliacaodoatendimento) {
        this.obsavaliacaodoatendimento = obsavaliacaodoatendimento;
    }

    public String getAvaliacaodoatendimento() {
        return avaliacaodoatendimento;
    }

    public void setAvaliacaodoatendimento(String avaliacaodoatendimento) {
        this.avaliacaodoatendimento = avaliacaodoatendimento;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public String getDataInicio_String() {
        if (dataInicio != null) {
            SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
            String data = formataData.format(dataInicio);
            return data;
        } else {
            return "";
        }
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public String getHoraInicio_String() {
        if (horaInicio != null) {
            SimpleDateFormat formataData = new SimpleDateFormat("HH:mm");
            String hora = formataData.format(horaInicio);
            return hora;
        } else {
            return "";
        }
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public String getDataFim_String() {
        if (dataFim != null) {
            SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
            String data = formataData.format(dataFim);
            return data;
        } else {
            return "";
        }
    }

    public Date getHoraFim() {
        return horaFim;
    }

    public String getHoraFim_String() {
        if (horaFim != null) {
            SimpleDateFormat formataData = new SimpleDateFormat("HH:mm");
            String hora = formataData.format(horaFim);
            return hora;
        } else {
            return "";
        }
    }

    public void setHoraFim(Date horaFim) {
        this.horaFim = horaFim;
    }

    public Date getDataContato() {
        return dataContato;
    }

    public String getDataContato_String() {
        if (dataContato != null) {
            SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
            String data = formataData.format(dataContato);
            return data;
        } else {
            return "";
        }
    }

    public void setDataContato(Date dataContato) {
        this.dataContato = dataContato;
    }

    public Date getHoraContato() {
        return horaContato;
    }

    public String getHoraContato_String() {
        if (horaContato != null) {
            SimpleDateFormat formataData = new SimpleDateFormat("HH:mm");
            String hora = formataData.format(horaContato);
            return hora;
        } else {
            return "";
        }
    }

    public void setHoraContato(Date horaContato) {
        this.horaContato = horaContato;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.codigo);
        hash = 23 * hash + Objects.hashCode(this.clienteagenda);
        hash = 23 * hash + Objects.hashCode(this.usuarioagenda);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Agenda other = (Agenda) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.clienteagenda, other.clienteagenda)) {
            return false;
        }
        if (!Objects.equals(this.usuarioagenda, other.usuarioagenda)) {
            return false;
        }
        return true;
    }

}
