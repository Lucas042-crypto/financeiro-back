package br.com.yonkoudev.financeiro.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Despesa extends Lancamento {

    @Column(columnDefinition = "TEXT")
    private String comprovante;
}
