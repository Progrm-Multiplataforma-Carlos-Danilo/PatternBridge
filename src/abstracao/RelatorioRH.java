package abstracao;

import implementacao.FormatoExportacao;

import java.util.List;

/**
 * Abstração Refinada (Refined Abstraction) representando o novo
 * relatório de Desempenho de RH, exigido pelo novo requisito de negócio.
 *
 * Sua criação NÃO exigiu nenhuma alteração nas classes de exportação
 * existentes nem nas demais classes de relatório — apenas a extensão de
 * {@link Relatorio}, evidenciando a aderência ao Princípio Aberto/Fechado.
 */
public class RelatorioRH extends Relatorio {

    private final String departamento;

    public RelatorioRH(String departamento, FormatoExportacao exportador) {
        super("Relatorio de Desempenho de RH", exportador);
        this.departamento = departamento;
    }

    /**
     * Simula a consulta ao sistema de avaliação de desempenho do
     * departamento informado.
     */
    private List<String> consultarDesempenho() {
        return List.of(
                "Departamento: " + departamento,
                "Colaborador: Ana Souza    | Meta atingida: 92%",
                "Colaborador: Bruno Lima   | Meta atingida: 87%",
                "Colaborador: Carla Nunes  | Meta atingida: 95%",
                "Media geral da equipe: 91,3%"
        );
    }

    @Override
    public void gerarRelatorio() {
        List<String> dados = consultarDesempenho();
        exportador.desenharCabecalho(titulo);
        exportador.desenharCorpo(dados);
        exportador.finalizarArquivo();
    }
}
