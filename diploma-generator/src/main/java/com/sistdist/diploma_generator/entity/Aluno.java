package com.sistdist.diploma_generator.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "aluno")
public class Aluno implements Serializable {

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

    @Override
    public String toString() {
        return "Aluno{" +
                ", nome='" + nome + '\'' +
                ", nacionalidade='" + nacionalidade + '\'' +
                ", estado='" + estado + '\'' +
                ", dataDeNascimento=" + dataDeNascimento +
                ", rg='" + rg + '\'' +
                ", dataDeConclusao=" + dataDeConclusao +
                ", curso='" + curso + '\'' +
                ", nivelDeEspecializacao='" + nivelDeEspecializacao + '\'' +
                ", cargaHorariaEmHoras='" + cargaHorariaEmHoras + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // Comparação de identidade, mesmo objeto
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; // Diferentes tipos de objetos
        }
        Aluno aluno = (Aluno) obj;
        return rg == aluno.getRg() &&
                Objects.equals(nome, aluno.getNome()) &&
                Objects.equals(nacionalidade, aluno.getNacionalidade()) &&
                Objects.equals(estado, aluno.getEstado()) &&
                Objects.equals(dataDeNascimento, aluno.getDataDeNascimento()) &&
                Objects.equals(dataDeConclusao, aluno.getDataDeConclusao()) &&
                Objects.equals(curso, aluno.getCurso()) &&
                Objects.equals(nivelDeEspecializacao, aluno.getNivelDeEspecializacao()) &&
                Objects.equals(cargaHorariaEmHoras, aluno.getCargaHorariaEmHoras());
    }

    @Override
    public int hashCode() {
        return Objects.hash(rg, nome, nacionalidade, estado, dataDeNascimento, dataDeConclusao, curso, nivelDeEspecializacao, cargaHorariaEmHoras);
    }
}
