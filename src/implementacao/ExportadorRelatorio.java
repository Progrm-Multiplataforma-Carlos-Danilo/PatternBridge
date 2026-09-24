package implementacao;

/**
 * Implementor do padrão Bridge.
 *
 * Define a interface para as classes de implementação (os "exportadores").
 * A hierarquia de Abstração (pacote {@code abstracao}) nunca depende de uma
 * classe concreta desta interface — apenas deste contrato. Isso permite que
 * novos formatos de exportação sejam adicionados sem alterar nenhuma classe
 * de relatório existente (Princípio Aberto/Fechado).
 */
public interface ExportadorRelatorio {

    /**
     * Exporta o conteúdo de um relatório para o formato concreto
     * implementado por esta classe.
     *
     * @param nomeRelatorio nome/título do relatório sendo exportado
     * @param conteudo      conteúdo (dados) já formatado pela Abstração
     */
    void exportar(String nomeRelatorio, String conteudo);

    /**
     * @return o nome do formato suportado por este exportador (ex.: "PDF").
     */
    String getFormato();
}
