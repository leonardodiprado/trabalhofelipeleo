package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class User {

    @NotNull(message = "O campo 'nome' não pode ser nulo.")
    @Size(min = 1, max = 50, message = "O nome deve ter entre 1 e 50 caracteres.")
    private String nome;

    @NotNull(message = "O campo 'email' não pode ser nulo.")
    @Email(message = "O email deve ser válido.")
    private String email;

    // Outros atributos e métodos conforme necessário

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Long id) {
    }
}
