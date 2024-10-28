package br.com.yonkoudev.financeiro.repository.custom;

import br.com.yonkoudev.financeiro.controller.dto.FiltroDTO;
import br.com.yonkoudev.financeiro.controller.dto.FluxoCaixaDTO;
import br.com.yonkoudev.financeiro.model.Lancamento;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
public class LancamentoCustomRepositoryImpl implements LancamentoCustomRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<FluxoCaixaDTO> getFluxoCaixas(FiltroDTO filtroDTO) {

        String sql = """
                SELECT
                    data,
                    tipo,
                    SUM(receita - despesa) AS saldo_diario,
                    SUM(SUM(receita - despesa)) OVER (ORDER BY data) AS saldo_acumulado,
                    status
                FROM (
                   SELECT data, valor AS receita, 0 AS despesa, tipo, status FROM receita r
                   UNION ALL
                   SELECT data, 0 AS receita, valor AS despesa, tipo, status FROM despesa d
                ) AS fluxo_caixa where 1 = 1 
                GROUP BY data,
                		 tipo,
                		 status
                ORDER BY data;
                """;

        //TODO: Fazer filtro
        return jdbcTemplate.query(sql, (rs, rowNum) -> FluxoCaixaDTO.builder()
                .data(rs.getObject("data", LocalDate.class))
                .tipo(Lancamento.Tipo.valueOf(rs.getString("tipo")))
                .saldoDiario(rs.getBigDecimal("saldo_diario"))
                .saldoAcumulado(rs.getBigDecimal("saldo_acumulado"))
                .status(Lancamento.Status.valueOf(rs.getString("status")))
                .build());
    }
}
