package abstracao;

import implementacao.ExportadorRelatorio;

/**
 * Abstração do padrão Bridge.
 *
 * Mantém uma referência ao objeto de {@link ExportadorRelatorio}
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
    protected ExportadorRelatorio exportador;

    private final String nome;

    protected Relatorio(String nome, ExportadorRelatorio exportador) {
        if (exportador == null) {
            throw new IllegalArgumentException("O exportador não pode ser nulo.");
        }
        this.nome = nome;
        this.exportador = exportador;
    }

    /**
     * Permite trocar a implementação de exportação em tempo de execução,
     * sem alterar o tipo do relatório nem recriar o objeto. É este método
     * que demonstra o desacoplamento característico do Bridge: o mesmo
     * relatório de vendas pode ser gerado em PDF e, em seguida, no mesmo
     * objeto, ser exportado para Excel.
     *
     * @param novoExportador nova implementação a ser injetada (via setter,
     *                        complementando a injeção via construtor)
     */
    public void setExportador(ExportadorRelatorio novoExportador) {
        if (novoExportador == null) {
            throw new IllegalArgumentException("O exportador não pode ser nulo.");
        }
        this.exportador = novoExportador;
    }

    public String getNome() {
        return nome;
    }

    /**
     * Monta o conteúdo específico deste tipo de relatório. Cada subclasse
     * concreta de Relatorio implementa sua própria lógica de negócio,
     * totalmente independente do formato de saída.
     */
    protected abstract String gerarConteudo();

    /**
     * Operação de alto nível exposta ao cliente. Delega a exportação
     * propriamente dita ao objeto Implementor atual (a "ponte"),
     * qualquer que ele seja.
     */
    public void gerar() {
        String conteudo = gerarConteudo();
        System.out.println(">> Solicitando geração de \"" + nome + "\" no formato "
                + exportador.getFormato() + "...");
        exportador.exportar(nome, conteudo);
    }
}
