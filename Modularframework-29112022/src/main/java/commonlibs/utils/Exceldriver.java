package commonlibs.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exceldriver {

//To Read from an external file
private InputStream fileReader;

//To write into an external file
private OutputStream filewriter;

private Workbook Excelworkbook;

private String Excelfilename;

public void createworkbook(String filename)throws Exception
{
	//To remove white spaces
filename=filename.trim();
   //create a file variable
File file=new File(filename);
//Not to override
if(file.exists()) {
	throw new Exception("File Already Exist..Create a file with new name");
}
//Initialise a workbook xls or xslx none of them throws exception
if(filename.endsWith(".xls"))
{
Excelworkbook=new HSSFWorkbook();	
}
else if(filename.endsWith(".xlsx"))
{
Excelworkbook=new XSSFWorkbook();
}else {
	throw new Exception("Invalid file format-Supported one are .xls and .xlsx");
}
filewriter=new FileOutputStream(filename);

Excelworkbook.write(filewriter);

filewriter.close();

Excelworkbook.close();
     }
//Opening a workbook
public void openworkbook(String filename)throws Exception
{
filename=filename.trim();
//Since this filename used for rest of my method
Excelfilename=filename;
//creating a file
File file=new File(filename);
//file doesnt exist opening a file need to be exist
if(!file.exists())
{
throw new Exception("File doesn't exist");
}
//through inputstream read into the filereader and 
//from that file'filename' available as screen in filereader
fileReader=new FileInputStream(filename);
//convert the screen'fileereader' into an excelworkbook
Excelworkbook=WorkbookFactory.create(fileReader);

}
//Create a Sheet
public void createsheet(String sheetname)throws Exception
{
sheetname=sheetname.trim();
//check with that name already get restored
Sheet sheet=Excelworkbook.getSheet(sheetname);
//doesnt exist sheet is null create an sheet
if(sheet !=null)
{
throw new Exception("Sheet already exist");
}
Excelworkbook.createSheet(sheetname);
}
//existing file need to know rowcount
public int getrowcount(String sheetname)throws Exception
{
sheetname=sheetname.trim();

Sheet sheet=Excelworkbook.getSheet(sheetname);

if(sheet==null)
{
	throw new Exception("sheet does not exist");
}
return sheet.getLastRowNum();
}
public int getcellcountfromarow(String sheetname,int rownumber)throws Exception
{
	sheetname=sheetname.trim();

	Sheet sheet=Excelworkbook.getSheet(sheetname);

	if(sheet==null)
	{
		throw new Exception("sheet does not exist");
	}
	if(rownumber<0)
	{
		throw new Exception("Invalid Row Number..");
	}
Row row;

row=sheet.getRow(rownumber);

if(row==null)
{
	return 0;
}else 
	return row.getLastCellNum();

}
public String getcelldata(String sheetname,int rownum,int cellnumber)throws Exception
{
sheetname=sheetname.trim();

Sheet sheet=Excelworkbook.getSheet(sheetname);

if(sheet==null)
{
	throw new Exception("Sheet doesn't Exist");
}
if(rownum<0 || cellnumber<0) {
	
	throw new Exception("Invalid row or cell number");
}
Row row;

row=sheet.getRow(rownum);
if(row==null) {
	return"";
}

Cell cell=row.getCell(cellnumber);
if(cell==null) {
	return"";
}
//method to get cell data
else {
	if(cell.getCellType()==CellType.NUMERIC) {
		return String.valueOf(cell.getNumericCellValue());
	}else {
		return cell.getStringCellValue();
	   }		
    }

  }

//write into a cell
public void setcelldata(String sheetname,int rownumber,int cellnumber,String text)throws Exception
{
	sheetname=sheetname.trim();

	Sheet sheet=Excelworkbook.getSheet(sheetname);

	if(sheet==null)
	{
		throw new Exception("sheet does not exist");
	}
	if(rownumber<0)
	{
		throw new Exception("Invalid Row Number..");
	}	
	Row row;

	row=sheet.getRow(rownumber);

if(row==null) {
          sheet.createRow(rownumber);
     
          row=sheet.getRow(rownumber);	
            }
    Cell cell=row.getCell(cellnumber);

if(cell==null)
{
         row.createCell(cellnumber);
         
         cell=row.getCell(cellnumber);
}
         cell.setCellValue(text);
}
public void savefile()throws Exception
{
filewriter= new FileOutputStream(Excelfilename)	;

Excelworkbook.write(filewriter);

filewriter.close();

}
public void saveasfile(String newfilename)throws Exception
{
newfilename=newfilename.trim();

File file=new File(newfilename);

if(file.exists()) {
	throw new Exception("File already existes....");
}
filewriter=new FileOutputStream(newfilename);

Excelworkbook.close();

filewriter.close();
}
public void closeworkbook()throws Exception
{
fileReader.close();

filewriter.close();

Excelworkbook.close();
}
	
}
