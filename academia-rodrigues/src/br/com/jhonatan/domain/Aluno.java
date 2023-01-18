package br.com.jhonatan.domain;

import java.util.Objects;

public class Aluno {

    private String nome;
    private String faixa;
    private Long cpf;
    private Long numero;
    private Float mensalidade;

    public Aluno(String name, String belt, String cpf, String number, String payment){
        this.nome = name;
        this.faixa = belt;
        this.cpf = Long.valueOf(cpf);
        this.numero = Long.valueOf(number);
        this.mensalidade = Float.valueOf(payment);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFaixa() {
        return faixa;
    }

    public void setFaixa(String faixa) {
        this.faixa = faixa;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Float getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(Float mensalidade) {
        this.mensalidade = mensalidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(cpf, aluno.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    @Override
    public String toString() {
        return "Aluno encontrado = " + "nome: " + nome +", faixa: " + faixa + ", cpf: " + cpf;
    }
}
