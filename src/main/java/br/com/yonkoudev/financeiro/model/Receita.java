package br.com.yonkoudev.financeiro.model;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
public class Receita extends Lancamento {
}
