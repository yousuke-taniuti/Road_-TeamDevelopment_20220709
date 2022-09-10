package com.salary.export;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.salary.entity.Salary;

public class CsvExporter {
	private XSSFWorkbook xssfWorkbook;
	private XSSFSheet	xssfSheet;
	private List<Salary> list;
	
	private void headerLine() {
		xssfSheet = xssfWorkbook.createSheet("All USers Details");
		Row row = xssfSheet.createRow(0);
		
		CellStyle cellStyle = xssfWorkbook.createCellStyle();
		XSSFFont font = xssfWorkbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		cellStyle.setFont(font);
		
		createCell(row, 0, "user_id", cellStyle);
		createCell(row, 1, "salary_number", cellStyle);
		createCell(row, 2, "name", cellStyle);
		createCell(row, 3, "base_salary", cellStyle);
		createCell(row, 4, "tax", cellStyle);
		createCell(row, 5, "premium", cellStyle);
		createCell(row, 6, "carfare", cellStyle);
		createCell(row, 7, "gross_payment", cellStyle);
		createCell(row, 8, "salary_date", cellStyle);
	}
	
	private void createCell(Row row, int countColumn, Object value, CellStyle cellStyle) {
		
		xssfSheet.autoSizeColumn(countColumn);
		Cell cell = row.createCell(countColumn);
		if(value instanceof Integer) {
			cell.setCellValue((Integer) value);
		}
		else if(value instanceof Boolean) {
			cell.setCellValue((double) value);
		}
		else {
			cell.setCellValue((String) value);
		}
		cell.setCellStyle(cellStyle);
	}
	
	private void writerDateLines() {
		int rowCount = 1;
		
		CellStyle style = xssfWorkbook.createCellStyle();
		XSSFFont font = xssfWorkbook.createFont();
		font.setFontHeight(18);
		style.setFont(font);
		
		for(Salary salary : list) {
			Row row = xssfSheet.createRow(rowCount++);
			int countColumn = 0;
			
			createCell(row, countColumn++, salary.getUser_id(), style);
			createCell(row, countColumn++, salary.getSalary_number(), style);
			createCell(row, countColumn++, salary.getName(), style);
			createCell(row, countColumn++, salary.getBase_salary(), style);
			createCell(row, countColumn++, salary.getTax(), style);
			createCell(row, countColumn++, salary.getPremium(), style);
			createCell(row, countColumn++, salary.getCarfare(), style);
			createCell(row, countColumn++, salary.getGross_payment(), style);
			createCell(row, countColumn++, salary.getSalary_date(), style);
			
		}
	}
	
	public CsvExporter(List<Salary>list) {
		this.list = list;
		xssfWorkbook = new XSSFWorkbook();
		
	}
	
	public void exportData(HttpServletResponse response) throws IOException {
		
		headerLine();
		
		writerDateLines();
		
		ServletOutputStream outputStream = response.getOutputStream();
		xssfWorkbook.write(outputStream);
		xssfWorkbook.close();
		
		outputStream.close();
	}
}
//d