package com.cit.rt.view;

import com.cit.rt.entity.District;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class PdfView extends AbstractPdfView{
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // change the file name
        response.setHeader("Content-Disposition", "attachment; filename=\"my-pdf-file.pdf\"");

        List<District> districts = (List<District>) model.get("district");
        document.add(new Paragraph("Generated Districts " + LocalDate.now()));

        PdfPTable table = new PdfPTable(districts.size());//districts.stream().findAny().get().getColumnCount()
        table.setWidthPercentage(100.0f);
        table.setSpacingBefore(10);

        // define font for table header row
        Font font = FontFactory.getFont(FontFactory.TIMES);
        font.setColor(BaseColor.WHITE);

        // define table header cell
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(BaseColor.DARK_GRAY);
        cell.setPadding(5);

        // write table header
        cell.setPhrase(new Phrase("id", font));
        table.addCell(cell);

        // write table header
        cell.setPhrase(new Phrase("name", font));
        table.addCell(cell);

        for(District district : districts) {
            table.addCell(district.getId().toString());
            table.addCell(district.getName());
        }

        document.add(table);
    }
}
