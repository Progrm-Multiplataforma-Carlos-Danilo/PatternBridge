package abstracao;

import implementacao.ExportadorRelatorio;

/**
 * Abstração Refinada (Refined Abstraction) representando o relatório
 * legado de Vendas.
 *
 * Não conhece nenhuma classe concreta de exportação: recebe a
 * implementação pronta via injeção de dependência no construtor.
 */
public class RelatorioVendas extends Relatorio {

    public RelatorioVendas(ExportadorRelatorio exportador) {
        super("Relatorio de Vendas", exportador);
    }

    @Override
    protected String gerarConteudo() {
        return "Produto A: 150 unidades vendidas | Receita: R$ 15.000,00\n"
             + "Produto B: 80 unidades vendidas  | Receita: R$ 9.600,00\n"
             + "Total do período: R$ 24.600,00";
    }
}
