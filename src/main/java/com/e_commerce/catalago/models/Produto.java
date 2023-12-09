package com.e_commerce.catalago.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Produto {
    @Id
	@GeneratedValue
	(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message = "imagem não pode estar em  branco")
    private String imagem;
    @NotNull(message = "Nome não pode estar em  branco")
    private String nome;
    private double preco;
    private String descricao;
    private String seguimento;
    private int quantidade;
   

    // Construtor da classe
    public Produto(Long id, String imagem, String nome, double preco, String descricao, String seguimento, int quantidade) {
        this.id = id;
        this.imagem = imagem;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.seguimento = seguimento;
        this.quantidade = quantidade;
        
    }

    public Produto(){
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSeguimento() {
        return seguimento;
    }

    public void setSeguimento(String seguimento) {
        this.seguimento = seguimento;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((imagem == null) ? 0 : imagem.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        long temp;
        temp = Double.doubleToLongBits(preco);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
        result = prime * result + ((seguimento == null) ? 0 : seguimento.hashCode());
        result = prime * result + quantidade;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Produto other = (Produto) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (imagem == null) {
            if (other.imagem != null)
                return false;
        } else if (!imagem.equals(other.imagem))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (Double.doubleToLongBits(preco) != Double.doubleToLongBits(other.preco))
            return false;
        if (descricao == null) {
            if (other.descricao != null)
                return false;
        } else if (!descricao.equals(other.descricao))
            return false;
        if (seguimento == null) {
            if (other.seguimento != null)
                return false;
        } else if (!seguimento.equals(other.seguimento))
            return false;
        if (quantidade != other.quantidade)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Produto [id=" + id + ", imagem=" + imagem + ", nome=" + nome + ", preco=" + preco + ", descricao="
                + descricao + ", seguimento=" + seguimento + ", quantidade=" + quantidade + "]";
    }

    
   
    






    
}