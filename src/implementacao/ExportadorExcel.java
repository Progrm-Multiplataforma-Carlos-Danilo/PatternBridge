package implementacao;

import java.util.List;

/**
 * Implementação concreta (ConcreteImplementor) responsável por
 * "exportar" um relatório para o formato Excel (XLSX).
 *
 * Em um cenário real, aqui entraria a integração com uma biblioteca como
 * Apache POI. Para fins didáticos, a exportação é simulada via console.
 */
public class ExportadorExcel implements FormatoExportacao {

    @Override
    public void desenharCabecalho(String titulo) {
        System.out.println("=======================================");
        System.out.println("[XLSX] Gerando arquivo " + titulo.replace(" ", "_") + ".xlsx");
        System.out.println("[XLSX] Motor: simulação de biblioteca Excel (ex.: Apache POI)");
        System.out.println("[XLSX] Cabeçalho da planilha: " + titulo);
    }

    @Override
    public void desenharCorpo(List<String> dados) {
        System.out.println("[XLSX] Linhas da planilha:");
        for (String linha : dados) {
            System.out.println("[XLSX]   " + linha);
        }
    }

    @Override
    public void finalizarArquivo() {
        System.out.println("[XLSX] Exportação concluída com sucesso.");
        System.out.println("=======================================");
    }
}
