package abstracao;

import implementacao.ExportadorRelatorio;

/**
 * Abstração Refinada (Refined Abstraction) representando o novo
 * relatório de Desempenho de RH, exigido pelo novo requisito de negócio.
 *
 * Sua criação NÃO exigiu nenhuma alteração nas classes de exportação
 * existentes nem nas demais classes de relatório — apenas a extensão de
 * {@link Relatorio}, evidenciando a aderência ao Princípio Aberto/Fechado.
 */
public class RelatorioRH extends Relatorio {

    public RelatorioRH(ExportadorRelatorio exportador) {
        super("Relatorio de Desempenho de RH", exportador);
    }

    @Override
    protected String gerarConteudo() {
        return "Colaborador: Ana Souza    | Meta atingida: 92%\n"
             + "Colaborador: Bruno Lima   | Meta atingida: 87%\n"
             + "Colaborador: Carla Nunes  | Meta atingida: 95%\n"
             + "Média geral da equipe: 91,3%";
    }
}
