package br.com.papelcia.sistemadevendas.Model;

import jakarta.persistence.*;

    @Entity
    @Table(name = "produtos")
    public class Produto {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id_produto;

        private String nome_produto;
        private String descricao;
        private Double preco;
        private Integer estoque;

        // Construtor vazio (obrigatório pelo JPA)
        public Produto() {}

        // Getters e Setters...
        public Integer getId_produto() { return id_produto; }
        public void setId_produto(Integer id_produto) { this.id_produto = id_produto; }
        public String getNome_produto() { return nome_produto; }
        public void setNome_produto(String nome_produto) { this.nome_produto = nome_produto; }
        public String getDescricao() { return descricao; }
        public void setDescricao(String descricao) { this.descricao = descricao; }
        public Double getPreco() { return preco; }
        public void setPreco(Double preco) { this.preco = preco; }
        public Integer getEstoque() { return estoque; }
        public void setEstoque(Integer estoque) { this.estoque = estoque; }
    }
