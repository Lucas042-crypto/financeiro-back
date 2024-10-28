package br.com.yonkoudev.financeiro.repository;

import br.com.yonkoudev.financeiro.model.Receita;
import br.com.yonkoudev.financeiro.repository.custom.LancamentoCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceitaRepository extends JpaRepository<Receita, Long>, LancamentoCustomRepository {
}
