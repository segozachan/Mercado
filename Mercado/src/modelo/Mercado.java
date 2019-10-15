/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.time.LocalDate;
/**
 *
 * @author Administrador
 */
public class Mercado {
    private Integer codigo;
    private String nome_fantasia;
    private String razao_social;
    private LocalDate fundacao;
    private Integer nr_funcionario;
    private Double valor_bolsa;

    @Override
    public String toString() {
        return nome_fantasia;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome_fantasia() {
        return nome_fantasia;
    }

    public void setNome_fantasia(String nome_fantasia) {
        this.nome_fantasia = nome_fantasia;
    }

    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    public LocalDate getFundacao() {
        return fundacao;
    }

    public void setFundacao(LocalDate fundacao) {
        this.fundacao = fundacao;
    }

    public Integer getNr_funcionario() {
        return nr_funcionario;
    }

    public void setNr_funcionario(Integer nr_funcionario) {
        this.nr_funcionario = nr_funcionario;
    }

    public Double getValor_bolsa() {
        return valor_bolsa;
    }

    public void setValor_bolsa(Double valor_bolsa) {
        this.valor_bolsa = valor_bolsa;
    }
    
}
