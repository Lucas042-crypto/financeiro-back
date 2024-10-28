package br.com.yonkoudev.financeiro.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class Entidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "horario_cadastro")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime horarioCadastro;

    @Column(name = "horario_alteracao")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime horarioAlteracao;


    protected void preUpdateInSubclass() {

    }

    @PreUpdate
    public void setarDataAlteracao() {
        this.horarioAlteracao = LocalDateTime.now();
        preUpdateInSubclass();
    }

    @PrePersist
    public void setarDataCadastro() {
        this.horarioCadastro = LocalDateTime.now();
        preUpdateInSubclass();
    }

}
