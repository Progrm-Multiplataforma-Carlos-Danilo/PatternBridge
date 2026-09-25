package abstracao;

import implementacao.FormatoExportacao;

/**
 * Abstração do padrão Bridge.
 *
 * Mantém uma referência ao objeto de {@link FormatoExportacao}
 * (a "ponte" para a Implementação) em vez de herdar dela. Isso desacopla
 * a hierarquia de tipos de relatório (Vendas, RH, ...) da hierarquia de
 * formatos de exportação (PDF, Excel, HTML, ...), permitindo que ambas
 * evoluam de forma independente sem explosão de subclasses.
 *
 * A dependência do exportador é OBRIGATORIAMENTE injetada via construtor
 * (Injeção de Dependência) — esta classe e suas subclasses nunca
 * instanciam um exportador concreto com {@code new}.
 */
public abstract class Relatorio {

    /** Referência à Implementação (a "ponte"). */
    protected FormatoExportacao exportador;

    protected String titulo;

    protected Relatorio(String titulo, FormatoExportacao exportador) {
        if (exportador == null) {
            throw new IllegalArgumentException("O exportador não pode ser nulo.");
        }
        this.titulo = titulo;
        this.exportador = exportador;
    }

    /**
     * Permite trocar a implementação de exportação em tempo de execução,
     * sem alterar o tipo do relatório nem recriar o objeto. É este método
     * que demonstra o desacoplamento característico do Bridge: o mesmo
     * relatório de vendas pode ser gerado em PDF e, em seguida, no mesmo
     * objeto, ser exportado para Excel.
     *
     * @param exportador nova implementação a ser injetada (via setter,
     *                    complementando a injeção via construtor)
     */
    public void setExportador(FormatoExportacao exportador) {
        if (exportador == null) {
            throw new IllegalArgumentException("O exportador não pode ser nulo.");
        }
        this.exportador = exportador;
    }

    /**
     * Operação de alto nível exposta ao cliente. Cada subclasse concreta
     * de Relatorio implementa sua própria lógica de negócio (apuração dos
     * dados) e delega a exportação propriamente dita ao objeto Implementor
     * atual (a "ponte"), qualquer que ele seja.
     */
    public abstract void gerarRelatorio();
}
