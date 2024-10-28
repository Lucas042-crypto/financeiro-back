package br.com.yonkoudev.financeiro.repository;

import br.com.yonkoudev.financeiro.model.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {
}
