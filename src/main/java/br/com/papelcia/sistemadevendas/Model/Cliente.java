package br.com.papelcia.sistemadevendas.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

/**
 * Entidade 'Cliente' que herda de 'Pessoa' .
 * @PrimaryKeyJoinColumn indica que a coluna 'id_cliente' é a chave
 * primária desta tabela e também a chave estrangeira para 'Pessoa'. [cite: 2233, 2234]
 */
@Entity
@Table(name = "cliente")
@PrimaryKeyJoinColumn(name = "id_cliente")
public class Cliente extends Pessoa {

    // Construtor vazio
    public Cliente() {
    }

    // Esta classe não possui campos próprios,
    // todos os getters e setters (nome, email, telefone)
    // são herdados diretamente de Pessoa.
}