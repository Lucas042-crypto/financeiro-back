package br.com.yonkoudev.financeiro.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FiltroDTO {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDate dataInicial;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDate dataFinal;

}
