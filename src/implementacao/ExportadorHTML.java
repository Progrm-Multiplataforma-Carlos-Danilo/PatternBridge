package implementacao;

/**
 * Implementação concreta (ConcreteImplementor) responsável por
 * "exportar" um relatório para o formato HTML.
 *
 * Em um cenário real, aqui entraria a geração de um template HTML
 * (ex.: via Thymeleaf, FreeMarker ou concatenação de tags). Para fins
 * didáticos, a exportação é simulada via console.
 */
public class ExportadorHTML implements ExportadorRelatorio {

    @Override
    public void exportar(String nomeRelatorio, String conteudo) {
        System.out.println("=======================================");
        System.out.println("[HTML] Gerando arquivo " + nomeRelatorio.replace(" ", "_") + ".html");
        System.out.println("[HTML] Motor: simulação de template engine (ex.: Thymeleaf)");
        System.out.println("[HTML] Conteúdo renderizado como markup:");
        System.out.println("<html><body><h1>" + nomeRelatorio + "</h1><pre>" + conteudo + "</pre></body></html>");
        System.out.println("[HTML] Exportação concluída com sucesso.");
        System.out.println("=======================================");
    }

    @Override
    public String getFormato() {
        return "HTML";
    }
}
