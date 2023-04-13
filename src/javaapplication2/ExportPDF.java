/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ExportPDF {

   public static void exportar(JTable tabla) throws IOException {
      
      // Crear el archivo PDF
      File file = new File("tabla.pdf");
      file.getParentFile().mkdirs();
      
      // Crear el objeto PdfDocument y el objeto Document
      PdfWriter writer = new PdfWriter(new FileOutputStream(file));
      PdfDocument pdf = new PdfDocument(writer);
      Document document = new Document(pdf, PageSize.A4.rotate());
      
      // Crear la tabla PDF
      Table pdfTable = new Table(tabla.getColumnCount());
      pdfTable.setWidth(100);
      
      // Agregar las columnas a la tabla PDF
      for (int i = 0; i < 3; i++) {
         Cell cell = new Cell();
         PdfFont font = PdfFontFactory.createFont();
         
         pdfTable.addCell(cell);
      }
      
      // Obtener los datos de la tabla JTable y agregar las filas a la tabla PDF
      DefaultTableModel model = (DefaultTableModel) tabla.getModel();
      for (int i = 0; i < 3; i++) {
         for (int j = 0; j < 3; j++) {
            Cell cell = new Cell();
            PdfFont font = PdfFontFactory.createFont();
            
            pdfTable.addCell(cell);
         }
      }
      
      // Agregar la tabla PDF al documento y cerrar el documento
      document.add(pdfTable);
      
      document.close();
   }
}