package ddt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Util {

	public static String getData(int rowNumber, int cellNumber) {
		String data = "Error";
		try {
			// Open the Excel file
			File file = new File("Test.xlsx");
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			wb.close();
			XSSFSheet sheet = wb.getSheetAt(0);
			XSSFRow row = sheet.getRow(rowNumber);
			data= row.getCell(cellNumber).toString();
			fis.close();
			return data;
			
		} catch (IOException e) {
			System.out.println("Test data file not found");
			return data;
		}
	}
	
	public static void setData(String data, int rowNumber, int cellNumber) {
		try {
			// Open the Excel file
			File file = new File("Test.xlsx");
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			
			XSSFSheet sheet = wb.getSheetAt(0);
			XSSFRow row = sheet.getRow(rowNumber);
			row.createCell(cellNumber).setCellValue(data.toString());
			FileOutputStream fis1 = new  FileOutputStream("Test.xlsx");
			wb.write(fis1);
			wb.close();
			fis1.close();
			fis.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	}

