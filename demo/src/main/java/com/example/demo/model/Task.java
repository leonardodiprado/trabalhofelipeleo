package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

@Entity
public class Task {

    @NotNull(message = "O campo 'descrição' não pode ser nulo.")
    @Size(min = 1, max = 255, message = "A descrição deve ter entre 1 e 255 caracteres.")
    private String descricao;

    private LocalDate dataConclusao;

    // Outros atributos e métodos conforme necessário

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDate dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public void setId(Long id) {
    }

    public Long getId() {
        return null;
    }
}
