package br.com.yonkoudev.financeiro.controller;

import br.com.yonkoudev.financeiro.controller.dto.FiltroDTO;
import br.com.yonkoudev.financeiro.controller.dto.FluxoCaixaDTO;
import br.com.yonkoudev.financeiro.model.Despesa;
import br.com.yonkoudev.financeiro.model.Receita;
import br.com.yonkoudev.financeiro.service.FinanceiroService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gerenciar/financeiro")
@AllArgsConstructor
public class FinanceiroController {

    private FinanceiroService financeiroService;

    @PostMapping("/lancarReceita")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Receita> lancarReceita(@Valid @RequestBody Receita receita) {
        return ResponseEntity.ok(financeiroService.lancarReceita(receita));
    }

    @PostMapping("/lancarDespesa")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Despesa> lancarDespesa(@Valid @RequestBody Despesa despesa) {
        return ResponseEntity.ok(financeiroService.lancarDespesa(despesa));
    }

    @GetMapping("/listarDespesa")
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<List<Despesa>> listarDespesa(@RequestParam(required = false) Long id) {
        return ResponseEntity.ok(financeiroService.listarDespesa(id));
    }

    @GetMapping("/listarReceita")
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<List<Receita>> listarReceita(@RequestParam(required = false) Long id) {
        return ResponseEntity.ok(financeiroService.listarReceita(id));
    }

    @GetMapping("/fluxoCaixa")
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<List<FluxoCaixaDTO>> fluxoCaixa(FiltroDTO filtroDTO) {
        return ResponseEntity.ok(financeiroService.fluxoCaixa(filtroDTO));
    }


}
