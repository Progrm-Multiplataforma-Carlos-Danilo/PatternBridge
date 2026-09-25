package implementacao;

import java.util.List;

/**
 * Implementação concreta (ConcreteImplementor) responsável por
 * "exportar" um relatório para o formato HTML.
 *
 * Em um cenário real, aqui entraria a geração de um template HTML
 * (ex.: via Thymeleaf, FreeMarker ou concatenação de tags). Para fins
 * didáticos, a exportação é simulada via console.
 */
public class ExportadorHTML implements FormatoExportacao {

    @Override
    public void desenharCabecalho(String titulo) {
        System.out.println("=======================================");
        System.out.println("[HTML] Gerando arquivo " + titulo.replace(" ", "_") + ".html");
        System.out.println("[HTML] Motor: simulação de template engine (ex.: Thymeleaf)");
        System.out.println("[HTML] <h1>" + titulo + "</h1>");
    }

    @Override
    public void desenharCorpo(List<String> dados) {
        System.out.println("[HTML] <ul>");
        for (String linha : dados) {
            System.out.println("[HTML]   <li>" + linha + "</li>");
        }
        System.out.println("[HTML] </ul>");
    }

    @Override
    public void finalizarArquivo() {
        System.out.println("[HTML] Exportação concluída com sucesso.");
        System.out.println("=======================================");
    }
}
