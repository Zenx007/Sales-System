package br.com.papelcia.sistemadevendas.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

/**
 * Entidade 'Funcionario' que herda de 'Pessoa' .
 * Possui campos adicionais 'cargo' e 'senha'.
 */
@Entity
@Table(name = "funcionario")
@PrimaryKeyJoinColumn(name = "id_funcionario") // [cite: 2237, 2240]
public class Funcionario extends Pessoa {

    private String cargo; // [cite: 2239]
    private String senha; // [cite: 2238]

    // Construtor vazio
    public Funcionario() {
    }

    // --- Getters e Setters (para os campos desta classe) ---

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}