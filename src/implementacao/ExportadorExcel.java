package implementacao;

/**
 * Implementação concreta (ConcreteImplementor) responsável por
 * "exportar" um relatório para o formato Excel (XLSX).
 *
 * Em um cenário real, aqui entraria a integração com uma biblioteca como
 * Apache POI. Para fins didáticos, a exportação é simulada via console.
 */
public class ExportadorExcel implements ExportadorRelatorio {

    @Override
    public void exportar(String nomeRelatorio, String conteudo) {
        System.out.println("=======================================");
        System.out.println("[XLSX] Gerando arquivo " + nomeRelatorio.replace(" ", "_") + ".xlsx");
        System.out.println("[XLSX] Motor: simulação de biblioteca Excel (ex.: Apache POI)");
        System.out.println("[XLSX] Conteúdo estruturado em planilha:");
        System.out.println(conteudo);
        System.out.println("[XLSX] Exportação concluída com sucesso.");
        System.out.println("=======================================");
    }

    @Override
    public String getFormato() {
        return "Excel (XLSX)";
    }
}
