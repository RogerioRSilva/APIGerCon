package br.com.gercon.gerenciador.contas.model;


import br.com.gercon.gerenciador.contas.util.StatusConta;
import jakarta.persistence.*;

@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConta;

    private String tipoConta;
    private String descricaco;
    private double valorConta;
    private String dataVencimento;
    private String dataPagamento;

    @Enumerated(EnumType.STRING)
    private StatusConta statusConta;

    @ManyToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;


    public Conta() {
    }

    public void cadastrarConta(String tipoConta, String descricaco, double valorConta, String dataVencimento, String dataPagamento, StatusConta statusConta, Pessoa pessoa){
        this.tipoConta = tipoConta;
        this.descricaco = descricaco;
        this.valorConta = valorConta;
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
        this.statusConta = statusConta;
        this.pessoa = pessoa;
    }

    public Long getIdConta() {
        return idConta;
    }

    public void setIdConta(Long idConta) {
        this.idConta = idConta;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public String getDescricaco() {
        return descricaco;
    }

    public void setDescricaco(String descricaco) {
        this.descricaco = descricaco;
    }

    public double getValorConta() {
        return valorConta;
    }

    public void setValorConta(double valorConta) {
        this.valorConta = valorConta;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public StatusConta getStatusConta() {
        return statusConta;
    }

    public void setStatusConta(StatusConta statusConta) {
        this.statusConta = statusConta;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public String toString() {
        return "Conta{" + "idConta="
                + idConta
                + ", tipoConta="
                + tipoConta
                + ", descricaco="
                + descricaco
                + ", valorConta="
                + valorConta
                + ", dataVencimento="
                + dataVencimento
                + ", dataPagamento="
                + dataPagamento
                + ", statusConta="
                + statusConta
                + ", pessoa="
                + pessoa
                + '}';
    }
}
