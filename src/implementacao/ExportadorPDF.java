package implementacao;

import java.util.List;

/**
 * Implementação concreta (ConcreteImplementor) responsável por
 * "exportar" um relatório para o formato PDF.
 *
 * Em um cenário real, aqui entraria a integração com uma biblioteca de
 * geração de PDF (ex.: iText, Apache PDFBox). Para fins didáticos, a
 * exportação é simulada via console.
 */
public class ExportadorPDF implements FormatoExportacao {

    @Override
    public void desenharCabecalho(String titulo) {
        System.out.println("=======================================");
        System.out.println("[PDF] Gerando arquivo " + titulo.replace(" ", "_") + ".pdf");
        System.out.println("[PDF] Motor: simulação de biblioteca PDF (ex.: iText/PDFBox)");
        System.out.println("[PDF] Cabeçalho: " + titulo);
    }

    @Override
    public void desenharCorpo(List<String> dados) {
        System.out.println("[PDF] Corpo do relatório:");
        for (String linha : dados) {
            System.out.println("[PDF]   " + linha);
        }
    }

    @Override
    public void finalizarArquivo() {
        System.out.println("[PDF] Exportação concluída com sucesso.");
        System.out.println("=======================================");
    }
}
