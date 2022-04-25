package com.br.jasper.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;

@Service
public class ClientReport2 {

    public void execute() throws Exception {

        generateReport();
    }

    private String getPathToReportPackage() {

        //Windows
        //return "D:\\Workspace_outros\\RelatorioJasper\\src\\main\\resources\\report\\ArquivoJM.jrxml";
        //Linux
        return "/home/ifj/workspace/outros/RelatorioJasper/src/main/resources/report/ArquivoJM.jrxml";
    }

    private void generateReport() throws Exception {

        JasperReport report = JasperCompileManager.compileReport(getPathToReportPackage());

        Map parametros = new HashMap();
        parametros.put("clienteDe", 1);
        parametros.put("clienteAte", 4);

        Connection conexao = null;
        try {
              Class.forName("com.mysql.jdbc.Driver");
              conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/arquivojm", "root", "root");
        } catch (Exception e) {
             //TODO:handle exception
        }

        JasperPrint print = JasperFillManager.fillReport(report, parametros, conexao);

        //Windows
        //JasperExportManager.exportReportToPdfFile(print, "D:/Report/ClientsReport.pdf");
        //Linux
        JasperExportManager.exportReportToPdfFile(print,
            "/home/ifj/Downloads/Report/ArquivoJM.pdf");
    }
}
