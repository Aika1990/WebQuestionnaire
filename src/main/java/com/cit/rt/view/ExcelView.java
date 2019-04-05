package com.cit.rt.view;

import com.cit.rt.entity.District;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class ExcelView extends AbstractXlsView {

    @Override
    protected void buildExcelDocument(Map<String, Object> model,
                                      Workbook workbook,
                                      HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {

        // change the file name
        response.setHeader("Content-Disposition", "attachment; filename=\"my-xls-file.xls\"");

        @SuppressWarnings("unchecked")
        List<District> districts = (List<District>) model.get("districts");
        Sheet sheet = workbook.createSheet("District Detail");
        sheet.setDefaultColumnWidth(30);

        // create style for header cells
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Arial");
        style.setFillForegroundColor(HSSFColor.BLUE.index);
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        font.setBold(true);
        font.setColor(HSSFColor.WHITE.index);
        style.setFont(font);


        // create header row
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("id");
        header.getCell(0).setCellStyle(style);
        header.createCell(1).setCellValue("name");
        header.getCell(1).setCellStyle(style);

        int rowCount = 1;

        for(District district : districts) {
            Row districtRow = sheet.createRow(rowCount++);
            districtRow.createCell(0).setCellValue(district.getId());
            districtRow.createCell(1).setCellValue(district.getName());
        }
    }
}
