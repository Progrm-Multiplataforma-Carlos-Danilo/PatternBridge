package abstracao;

import implementacao.FormatoExportacao;

import java.util.List;

/**
 * Abstração Refinada (Refined Abstraction) representando o relatório
 * legado de Vendas.
 *
 * Não conhece nenhuma classe concreta de exportação: recebe a
 * implementação pronta via injeção de dependência no construtor.
 */
public class RelatorioVendas extends Relatorio {

    private final String periodo;

    public RelatorioVendas(String periodo, FormatoExportacao exportador) {
        super("Relatorio de Vendas", exportador);
        this.periodo = periodo;
    }

    /**
     * Simula a consulta à base de dados de vendas do período informado.
     */
    private List<String> consultarVendas() {
        return List.of(
                "Periodo: " + periodo,
                "Produto A: 150 unidades vendidas | Receita: R$ 15.000,00",
                "Produto B: 80 unidades vendidas  | Receita: R$ 9.600,00",
                "Total do periodo: R$ 24.600,00"
        );
    }

    @Override
    public void gerarRelatorio() {
        List<String> dados = consultarVendas();
        exportador.desenharCabecalho(titulo);
        exportador.desenharCorpo(dados);
        exportador.finalizarArquivo();
    }
}
