package br.com.yonkoudev.financeiro.service;

import br.com.yonkoudev.financeiro.controller.dto.FiltroDTO;
import br.com.yonkoudev.financeiro.controller.dto.FluxoCaixaDTO;
import br.com.yonkoudev.financeiro.model.Despesa;
import br.com.yonkoudev.financeiro.model.Receita;
import br.com.yonkoudev.financeiro.repository.DespesaRepository;
import br.com.yonkoudev.financeiro.repository.ReceitaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class FinanceiroService {

    private final DespesaRepository despesaRepository;

    private final ReceitaRepository receitaRepository;

    public Despesa lancarDespesa(Despesa despesa) {
        Objects.requireNonNull(despesa.getTipo());

        if(despesa.getId() != null){
            despesaRepository.findById(despesa.getId()).ifPresent(d ->{
                despesa.setHorarioCadastro(d.getHorarioCadastro());
                despesa.setHorarioAlteracao(d.getHorarioAlteracao());
            });
        }
        return despesaRepository.save(despesa);
    }

    public List<Despesa> listarDespesa(Long id) {

        if(id != null){
         return  Collections.singletonList(despesaRepository.findById(id).orElse(null));
        }

        return despesaRepository.findAll();
    }


    public List<Receita> listarReceita(Long id) {

        if(id != null){
            return  Collections.singletonList(receitaRepository.findById(id).orElse(null));
        }

        return receitaRepository.findAll();
    }

    public Receita lancarReceita(Receita receita) {
        Objects.requireNonNull(receita.getTipo());

        if(receita.getId() != null){
            receitaRepository.findById(receita.getId()).ifPresent(d ->{
                receita.setHorarioCadastro(d.getHorarioCadastro());
                receita.setHorarioAlteracao(d.getHorarioAlteracao());
            });
        }
        return receitaRepository.save(receita);
    }

    public List<FluxoCaixaDTO> fluxoCaixa(FiltroDTO filtroDTO) {
        return receitaRepository.getFluxoCaixas(filtroDTO);
    }
}
