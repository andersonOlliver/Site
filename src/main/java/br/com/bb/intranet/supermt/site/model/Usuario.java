package br.com.bb.intranet.supermt.site.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String chave;
    private String prefixo;
    private String apelido;
    private String nomeCompleto;
    private String caminhoImagem;
    private TipoUsuario tipo;
    private Mercado mercado;
    private List<Acesso> navegacoes = new ArrayList<>();
    private List<Sugestao> sugestoes = new ArrayList<>();
    private List<Registro> cadastros = new ArrayList<>();

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    @NotEmpty
    @Size(max = 60)
    @Column(length = 60, nullable = false)
    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    @NotEmpty
    @Size(max = 10)
    @Column(nullable = false, length = 10, unique = true)
    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    @NotEmpty
    @Size(max = 5)
    @Column(nullable = false, length = 5)
    public String getPrefixo() {
        return prefixo;
    }

    public void setPrefixo(String prefixo) {
        this.prefixo = prefixo;
    }

    @Size(max = 15)
    @Column(length = 15, nullable = false)
    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    @Size(max = 150)
    @Column(length = 150)
    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }

    @ManyToOne
    @JoinColumn(name = "mercado_id")
    public Mercado getMercado() {
        return mercado;
    }

    public void setMercado(Mercado mercado) {
        this.mercado = mercado;
    }

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    public List<Acesso> getNavegacoes() {
        return navegacoes;
    }

    public void setNavegacoes(List<Acesso> navegacoes) {
        this.navegacoes = navegacoes;
    }

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    public List<Sugestao> getSugestoes() {
        return sugestoes;
    }

    public void setSugestoes(List<Sugestao> sugestoes) {
        this.sugestoes = sugestoes;
    }

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    public List<Registro> getCadastros() {
        return cadastros;
    }

    public void setCadastros(List<Registro> cadastros) {
        this.cadastros = cadastros;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Usuario other = (Usuario) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

}
