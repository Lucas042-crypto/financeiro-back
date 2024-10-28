package br.com.yonkoudev.financeiro.repository.custom;

import br.com.yonkoudev.financeiro.controller.dto.FiltroDTO;
import br.com.yonkoudev.financeiro.controller.dto.FluxoCaixaDTO;

import java.util.List;


public interface LancamentoCustomRepository {
    List<FluxoCaixaDTO> getFluxoCaixas(FiltroDTO filtroDTO);
}
