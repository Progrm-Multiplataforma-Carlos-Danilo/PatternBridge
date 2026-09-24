package implementacao;

/**
 * Implementação concreta (ConcreteImplementor) responsável por
 * "exportar" um relatório para o formato PDF.
 *
 * Em um cenário real, aqui entraria a integração com uma biblioteca de
 * geração de PDF (ex.: iText, Apache PDFBox). Para fins didáticos, a
 * exportação é simulada via console.
 */
public class ExportadorPDF implements ExportadorRelatorio {

    @Override
    public void exportar(String nomeRelatorio, String conteudo) {
        System.out.println("=======================================");
        System.out.println("[PDF] Gerando arquivo " + nomeRelatorio.replace(" ", "_") + ".pdf");
        System.out.println("[PDF] Motor: simulação de biblioteca PDF (ex.: iText/PDFBox)");
        System.out.println("[PDF] Conteúdo renderizado:");
        System.out.println(conteudo);
        System.out.println("[PDF] Exportação concluída com sucesso.");
        System.out.println("=======================================");
    }

    @Override
    public String getFormato() {
        return "PDF";
    }
}
