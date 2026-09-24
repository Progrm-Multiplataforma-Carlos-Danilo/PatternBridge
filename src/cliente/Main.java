package cliente;

import abstracao.Relatorio;
import abstracao.RelatorioRH;
import abstracao.RelatorioVendas;
import implementacao.ExportadorExcel;
import implementacao.ExportadorHTML;
import implementacao.ExportadorPDF;
import implementacao.ExportadorRelatorio;

/**
 * Classe cliente do padrão Bridge.
 *
 * É a ÚNICA camada do sistema que conhece as classes concretas de
 * exportação ({@link ExportadorPDF}, {@link ExportadorExcel},
 * {@link ExportadorHTML}). As classes de relatório (pacote
 * {@code abstracao}) recebem essas implementações prontas via
 * injeção de dependência no construtor — nunca as instanciam
 * internamente.
 *
 * Este script valida o desacoplamento do Bridge executando três
 * rotinas exigidas pelo requisito:
 *   1) Geração de um Relatório de Vendas em PDF;
 *   2) Alteração dinâmica, em tempo de execução, do MESMO relatório
 *      de vendas para o formato Excel;
 *   3) Geração de um Relatório de RH em HTML.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("############################################");
        System.out.println("# VALIDACAO DO PADRAO BRIDGE - MODULO RELATORIOS");
        System.out.println("############################################\n");

        // ------------------------------------------------------------
        // Rotina 1: Relatório de Vendas em PDF
        // ------------------------------------------------------------
        System.out.println("--- Rotina 1: Relatorio de Vendas em PDF ---");
        ExportadorRelatorio exportadorPdf = new ExportadorPDF();          // Implementação concreta escolhida aqui, no cliente
        Relatorio relatorioVendas = new RelatorioVendas(exportadorPdf);   // Injeção via construtor
        relatorioVendas.gerar();
        System.out.println();

        // ------------------------------------------------------------
        // Rotina 2: Alteração dinâmica do MESMO relatório para Excel
        // ------------------------------------------------------------
        System.out.println("--- Rotina 2: Mesmo Relatorio de Vendas, agora em Excel (troca em runtime) ---");
        ExportadorRelatorio exportadorExcel = new ExportadorExcel();
        relatorioVendas.setExportador(exportadorExcel);  // Troca a implementação sem recriar o objeto Relatorio
        relatorioVendas.gerar();
        System.out.println();

        // ------------------------------------------------------------
        // Rotina 3: Relatório de RH em HTML (novo requisito de negócio)
        // ------------------------------------------------------------
        System.out.println("--- Rotina 3: Relatorio de Desempenho de RH em HTML ---");
        ExportadorRelatorio exportadorHtml = new ExportadorHTML();
        Relatorio relatorioRH = new RelatorioRH(exportadorHtml);
        relatorioRH.gerar();
        System.out.println();

        System.out.println("############################################");
        System.out.println("# FIM DA VALIDACAO - Todas as rotinas executadas com sucesso.");
        System.out.println("############################################");
    }
}
