package com.wazn.application.usecase;

import com.wazn.application.exception.ReportException;
import com.wazn.application.model.Account;
import com.wazn.application.model.Document;
import com.wazn.application.repository.AccountRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class GenerateReportUseCaseImp implements GenerateReportUseCase {

    private AccountRepository accountRepository;

    public GenerateReportUseCaseImp(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void generateReport(String mobile) {
        try {
            Account account = accountRepository.getAccount(mobile);
            Document document = accountRepository.getDocument(mobile);
            Map map = buildReportParameter(account,document);
            generatePdfReport(map);
        }catch (Exception ex) {
            throw new ReportException(ex.getMessage());
        }
    }

    private Map buildReportParameter(Account account, Document document) throws IOException {
        Map map = new HashMap();
        map.put("p_entered_on_value", document.getReport().getEnteredOn().toString());
        map.put("p_location_value", document.getReport().getLocation());
        map.put("p_entered_by_value", document.getReport().getEnteredBy());
        map.put("p_doc_bearer_value", account.getFullName());
        map.put("p_birth_date_value", document.getBirthDate().toString());
        map.put("p_gender_value", document.getGender());
        map.put("p_nationality_value", document.getNationality());
        map.put("p_reg_num_value", document.getRegNumber());
        map.put("p_personal_num_value", document.getPersonalNumber());
        map.put("p_num_value", account.getMobile());
        map.put("p_doc_type_value", document.getDocumentType());
        map.put("p_doc_number_value", document.getDocumentNumber());
        map.put("p_issuing_country_value", document.getIssuingCountry());
        map.put("p_valid_through_value", document.getValidThrough().toString());
        map.put("p_own_comment_value", document.getOwnComment());
        map.put("p_helpdesk_value", document.getHelpDeskComment());
        map.put("p_assessment_doc_img", document.getResult().getAssessmentDocumentBearer() ? "accept.png" : "warning.png");
        map.put("p_face_match_img", document.getResult().getFaceMatch() ? "accept.png" : "warning.png");
        map.put("p_mrz_img", document.getResult().getCheckMRZ() ? "accept.png" : "warning.png");
        map.put("p_auth_img", document.getResult().getAutomationAuthentications() ? "accept.png" : "warning.png");
        map.put("p_id_face_img", getImage(document.getImage().getDocumentIdImageFace()));
        map.put("p_id_back_img", getImage(document.getImage().getDocumentIdImageBack()));
        map.put("p_personal_img", getImage(document.getImage().getPersonalImage()));
        map.put("p_Logo_img", "wazn.jpg");
        return map;
    }

    private BufferedImage getImage(byte[] image) throws IOException {
        InputStream in = new ByteArrayInputStream(image);
        BufferedImage bufferedImage = ImageIO.read(in);
        return bufferedImage;
    }

    private void generatePdfReport(Map map) throws JRException, FileNotFoundException {
        InputStream inputStream = getClass().getResourceAsStream("/slip-report.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
        JRDataSource dataSource = new JREmptyDataSource();
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, dataSource);

        JRPdfExporter exporter = new JRPdfExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput( new SimpleOutputStreamExporterOutput("../../wazn/report.pdf"));

        SimplePdfReportConfiguration reportConfig = new SimplePdfReportConfiguration();
        reportConfig.setSizePageToContent(true);
        reportConfig.setForceLineBreakPolicy(false);

        SimplePdfExporterConfiguration exportConfig = new SimplePdfExporterConfiguration();
        exportConfig.setMetadataAuthor("report");
        exportConfig.setEncrypted(true);
        exportConfig.setAllowedPermissionsHint("PRINTING");

        exporter.setConfiguration(reportConfig);
        exporter.setConfiguration(exportConfig);

        exporter.exportReport();
    }
}
