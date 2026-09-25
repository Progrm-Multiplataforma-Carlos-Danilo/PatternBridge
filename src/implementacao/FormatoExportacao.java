package implementacao;

import java.util.List;

/**
 * Implementor do padrão Bridge.
 *
 * Define a interface para as classes de implementação (os "formatos de
 * exportação"). A hierarquia de Abstração (pacote {@code abstracao}) nunca
 * depende de uma classe concreta desta interface — apenas deste contrato.
 * Isso permite que novos formatos de exportação sejam adicionados sem
 * alterar nenhuma classe de relatório existente (Princípio Aberto/Fechado).
 *
 * A exportação é modelada em três etapas, que a Abstração invoca em
 * sequência sobre o mesmo arquivo em construção: cabeçalho, corpo e
 * finalização.
 */
public interface FormatoExportacao {

    /**
     * Desenha o cabeçalho do relatório (título) no arquivo de saída.
     *
     * @param titulo título do relatório sendo exportado
     */
    void desenharCabecalho(String titulo);

    /**
     * Desenha o corpo do relatório com os dados já apurados pela Abstração.
     *
     * @param dados linhas de conteúdo do relatório
     */
    void desenharCorpo(List<String> dados);

    /**
     * Finaliza e "grava" o arquivo no formato concreto implementado por
     * esta classe.
     */
    void finalizarArquivo();
}
