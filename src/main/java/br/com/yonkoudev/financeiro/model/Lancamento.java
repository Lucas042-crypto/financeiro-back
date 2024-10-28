package br.com.yonkoudev.financeiro.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@MappedSuperclass
public class Lancamento extends Entidade {

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private MetodoPagamento metodoPagamento;

    private String responsavel;

    private String descricao;

    private BigDecimal valor;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDate data;

    private int posicao;


    public enum Tipo{
        DESPESA,
        RECEITA
    }

    public enum Status{
        PENDENTE,
        PAGO
    }

    public enum MetodoPagamento{
        CREDITO,
        DEBITO,
        PIX
    }
}
