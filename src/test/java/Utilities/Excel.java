package Utilities;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
 
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
public class Excel {
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	String path;
 
	public static  String ExcelRead(String sheet,int r,int c) throws IOException {
		FileInputStream fe = new FileInputStream(System.getProperty("user.dir")+"//Excel//RBS.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fe);
		XSSFSheet Sheet = workbook.getSheet(sheet);
		XSSFRow row = Sheet.getRow(r);
		XSSFCell cell = row.getCell(c);
		String value = String.valueOf(cell);
		return value;
	}
	
	public Excel(String path) {
		
		this.path=path;
	}
 
	public void setCellData(String sheetName,int rownum,int colnum,String string) throws IOException
	{
		File xlfile=new File(path);
		if(!xlfile.exists())    // If file not exists then create new file
		{
		workbook=new XSSFWorkbook();
		fo=new FileOutputStream(path);
		workbook.write(fo);
		}
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		if(workbook.getSheetIndex(sheetName)==-1) // If sheet not exists then create new Sheet
			workbook.createSheet(sheetName);
		sheet=workbook.getSheet(sheetName);
		if(sheet.getRow(rownum)==null)   // If row not exists then create new Row
				sheet.createRow(rownum);
		row=sheet.getRow(rownum);
		cell=row.createCell(colnum);
		cell.setCellValue(string);
		fo=new FileOutputStream(path);
		workbook.write(fo);		
		workbook.close();
		fi.close();
		fo.close();
	}
}


