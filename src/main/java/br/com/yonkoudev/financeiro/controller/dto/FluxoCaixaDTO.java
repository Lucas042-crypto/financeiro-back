package br.com.yonkoudev.financeiro.controller.dto;

import br.com.yonkoudev.financeiro.model.Lancamento;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FluxoCaixaDTO {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDate data;

    private Lancamento.Tipo tipo;

    private BigDecimal saldoDiario;

    private BigDecimal saldoAcumulado;

    private Lancamento.Status status;

}
