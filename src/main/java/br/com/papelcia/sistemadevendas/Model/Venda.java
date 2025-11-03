package br.com.papelcia.sistemadevendas.Model;

import br.com.papelcia.sistemadevendas.Model.Funcionario;
import jakarta.persistence.*;
import java.util.Date;

/**
 * Entidade 'Venda' .
 * Esta entidade mapeia os relacionamentos com Produto, Cliente e Funcionario
 * usando @ManyToOne e @JoinColumn.
 */
@Entity
@Table(name = "vendas")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_venda; // [cite: 2249]

    // Relacionamento com Funcionario [cite: 2250, 2255]
    @ManyToOne
    @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;

    // Relacionamento com Cliente [cite: 2251, 2256]
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    // Relacionamento com Produto [cite: 2252, 2257]
    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

    private Integer quantidade; // [cite: 2253]

    @Temporal(TemporalType.DATE)
    private Date data_venda; // [cite: 2254]

    // Construtor vazio
    public Venda() {
    }

    // --- Getters e Setters ---

    public Integer getId_venda() {
        return id_venda;
    }

    public void setId_venda(Integer id_venda) {
        this.id_venda = id_venda;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Date getData_venda() {
        return data_venda;
    }

    public void setData_venda(Date data_venda) {
        this.data_venda = data_venda;
    }
}