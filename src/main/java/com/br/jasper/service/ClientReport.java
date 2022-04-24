package com.br.jasper.service;

import com.br.jasper.domain.Client;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClientReport {

    private final GenerateClients generateClients;

    public ClientReport() {
        generateClients = new GenerateClients();
    }

    public void execute() throws Exception {

        generateReport(generateClients.execute());
    }

    private String getPathToReportPackage() {

        return "D:\\Workspace_outros\\RelatorioJasper\\src\\main\\resources\\report\\Clients.jrxml";
    }

    private void generateReport(List<Client> clientList) throws Exception {

        Map<String, Object> params = new HashMap<String, Object>();
        JasperReport report = JasperCompileManager.compileReport(getPathToReportPackage());

        JasperPrint print = JasperFillManager.fillReport(report, params,
                new JRBeanCollectionDataSource(clientList));

        JasperExportManager.exportReportToPdfFile(print, "D:/Report/ClientsReport.pdf");
    }
}
