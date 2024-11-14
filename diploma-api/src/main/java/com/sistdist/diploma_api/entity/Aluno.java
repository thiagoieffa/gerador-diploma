package com.sistdist.diploma_api.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("nacionalidade")
    private String nacionalidade;

    @JsonProperty("estado")
    private String estado;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @JsonProperty("dataDeNascimento")
    private LocalDate dataDeNascimento;

    @JsonProperty("rg")
    private String rg;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @JsonProperty("dataDeConclusao")
    private LocalDate dataDeConclusao;

    @JsonProperty("curso")
    private String curso;

    @JsonProperty("nivelDeEspecializacao")
    private String nivelDeEspecializacao;

    @JsonProperty("cargaHorariaEmHoras")
    private String cargaHorariaEmHoras;

    public Aluno() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public LocalDate getDataDeConclusao() {
        return dataDeConclusao;
    }

    public void setDataDeConclusao(LocalDate dataDeConclusao) {
        this.dataDeConclusao = dataDeConclusao;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getNivelDeEspecializacao() {
        return nivelDeEspecializacao;
    }

    public void setNivelDeEspecializacao(String nivelDeEspecializacao) {
        this.nivelDeEspecializacao = nivelDeEspecializacao;
    }

    public String getCargaHorariaEmHoras() {
        return cargaHorariaEmHoras;
    }

    public void setCargaHorariaEmHoras(String cargaHorariaEmHoras) {
        this.cargaHorariaEmHoras = cargaHorariaEmHoras;
    }
}
