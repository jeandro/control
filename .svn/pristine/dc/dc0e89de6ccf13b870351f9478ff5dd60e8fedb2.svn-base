package br.com.gtacomputadores.control.model;


import java.io.*;
import java.util.*;
import javax.persistence.*;

@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 2471765773806278661L;
	@Id
        @GeneratedValue
//        (strategy = GenerationType.IDENTITY)
	private Integer codigo;
	private String nome;
	private String email;
	@org.hibernate.annotations.NaturalId
	private String login;
	private String senha;
        @Temporal(javax.persistence.TemporalType.DATE)
	private Date nascimento;
	private String celular;
        private boolean ativo;
	private String permissao;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
     //   this.nome = nome;
         this.nome = (nome == null) ? null : nome.toUpperCase(); 
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
    
         this.login = (login == null) ? null : login.toUpperCase(); 
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
  
         this.senha = (senha == null) ? null : senha.toUpperCase(); 
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    /**
     * @return the permissao
     */
    public String getPermissao() {
        return permissao;
    }

    /**
     * @param permissao the permissao to set
     */
    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.codigo);
        hash = 53 * hash + Objects.hashCode(this.nome);
        hash = 53 * hash + Objects.hashCode(this.email);
        hash = 53 * hash + Objects.hashCode(this.login);
        hash = 53 * hash + Objects.hashCode(this.senha);
        hash = 53 * hash + Objects.hashCode(this.nascimento);
        hash = 53 * hash + Objects.hashCode(this.celular);
        hash = 53 * hash + (this.ativo ? 1 : 0);
        hash = 53 * hash + Objects.hashCode(this.permissao);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.nascimento, other.nascimento)) {
            return false;
        }
        if (!Objects.equals(this.celular, other.celular)) {
            return false;
        }
        if (this.ativo != other.ativo) {
            return false;
        }
        if (!Objects.equals(this.permissao, other.permissao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "codigo=" + codigo + ", nome=" + nome + ", email=" + email + ", login=" + login + ", senha=" + senha + ", nascimento=" + nascimento + ", celular=" + celular + ", ativo=" + ativo + ", permissao=" + permissao + '}';
    }



}