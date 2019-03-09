package com.acttime.genericlib;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {
	String path=	"./data/testData.xlsx";
	String pPath = "./data/commonData.properties";
	
	public String getPropertyKeyValue(String key) throws Throwable{
		FileInputStream fis = new FileInputStream(pPath);
		Properties pObj = new Properties();
		pObj.load(fis);
		String data = pObj.getProperty(key);
		return data;
	}
	
	
	
	public String getExcelData(String sheetName,int row,int col) throws Throwable{
	FileInputStream file=new FileInputStream(path);
		Workbook wb=WorkbookFactory.create(file);
		Sheet sh=wb.getSheet(sheetName);
		Row rh=sh.getRow(row);
		String data=rh.getCell(col).getStringCellValue();
		 wb.close();
		return data;
	}
	public void setExcelData(String sheetName,int row,int col,String data) throws Throwable{
	
		FileInputStream file=new FileInputStream(path);
		Workbook wb=WorkbookFactory.create(file);
		Sheet sh=wb.getSheet(sheetName);
		Row rh=sh.getRow(row);
		Cell ce=rh.createCell(col);
		 ce.setCellValue(data);
	    FileOutputStream fileoutput=new FileOutputStream(path);
	    wb.write(fileoutput);
	    wb.close();
	}

}
