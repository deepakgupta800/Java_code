package com.user.service.UserService.file;

import com.user.service.UserService.Entity.User;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Component
public class CreateExcelFile {

    public void createExcel(List<User> users) {
        String filePath = "/home/dell-cjy3424/Downloads/ExcelFile/MyExcel.xlsx";

        try (Workbook workbook = new XSSFWorkbook();
             FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {

            Sheet sheet = workbook.createSheet("user-info");

            Row headerRow = sheet.createRow(0);

            CellStyle headerStyle = workbook.createCellStyle();
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerStyle.setFont(headerFont);

            String[] headers = createHeaders();
            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
                cell.setCellStyle(headerStyle);
            }

            int rowNum = 1;
            for (User user : users) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(user.getUserId());
                row.createCell(1).setCellValue(user.getName());
                row.createCell(2).setCellValue(user.getEmail());
                row.createCell(3).setCellValue(user.getAbout());
            }

            for (int i = 0; i < headers.length; i++) {
                sheet.autoSizeColumn(i);
            }

            workbook.write(fileOutputStream);

        } catch (IOException e) {
            throw new RuntimeException("Failed to create Excel file", e);
        }
    }

    private String[] createHeaders() {
        return new String[]{"UserId", "Name", "Email", "About", "Ratings"};
    }
}