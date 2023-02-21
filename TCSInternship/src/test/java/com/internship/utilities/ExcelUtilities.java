package com.internship.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {

		static XSSFWorkbook wbook;
		static XSSFSheet sheet;
		public static String getcelldata(int sheetno, int row,int col) throws IOException
		{
		String datapath=System.getProperty("user.dir")+"\\src\\test\\resources\\Test_data.xlsx";
		FileInputStream fis=new FileInputStream(datapath);
		
		 wbook=new XSSFWorkbook(fis);
		 sheet=wbook.getSheetAt(sheetno);
		 fis.close();
		return sheet.getRow(row).getCell(col).toString();
		
		}
		public static String getcelldata(String sht, int row, int col) throws IOException {
			// TODO Auto-generated method stub
			String datapath=System.getProperty("user.dir")+"\\src\\test\\resources\\Test_data.xlsx";
			FileInputStream fis=new FileInputStream(datapath);
			 wbook=new XSSFWorkbook(fis);
			 sheet=wbook.getSheet(sht);
			 fis.close();
			return sheet.getRow(row).getCell(col).toString();
		}
	}

