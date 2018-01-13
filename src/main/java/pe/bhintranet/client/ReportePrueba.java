/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.bhintranet.client;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author moises_rodriguez
 */
public class ReportePrueba {

public InputStream getJasper() {
    InputStream jasperStream;
    jasperStream = this.getClass().getResourceAsStream("/jasperreports/reporte002.jasper");
    return jasperStream;

}

public static void main(String[] args) {
  HashMap hm = null;

  
  // System.out.println("Usage: ReportGenerator ....");

  try {
   System.out.println("Start ....");
   // Get jasper report
   String jrxmlFileName = "C://reportessw//reporte002.jrxml";
   String jasperFileName = "C://reportessw//reporte002.jasper";
   String pdfFileName = "C://reportessw//C1_report1.pdf";

   JasperCompileManager.compileReportToFile(jrxmlFileName, jasperFileName);
      // String dbUrl = props.getProperty("jdbc.url");
   String dbUrl = "jdbc:mysql://127.0.0.1:3306/bdboldhouseperu";
   // String dbDriver = props.getProperty("jdbc.driver");
   String dbDriver = "com.mysql.jdbc.Driver";
   // String dbUname = props.getProperty("db.username");
   String dbUname = "root";
   // String dbPwd = props.getProperty("db.password");
   String dbPwd = "toor";

   // Load the JDBC driver
   Class.forName(dbDriver);
   // Get the connection
   Connection conn = DriverManager.getConnection(dbUrl, dbUname, dbPwd);

   // Create arguments
   // Map params = new HashMap();
   hm = new HashMap();
   hm.put("ID", "123");
   hm.put("DATENAME", "April 2006");

   //****
   //****
   // Generate jasper print
   JasperPrint jprint = (JasperPrint) JasperFillManager.fillReport(jasperFileName, hm, conn);

   // Export pdf file
   JasperExportManager.exportReportToPdfFile(jprint, pdfFileName);
   
   System.out.println("Done exporting reports to pdf");
   
  } catch (Exception e) {
   System.out.print("Exceptiion" + e);
  }
 }    
}
