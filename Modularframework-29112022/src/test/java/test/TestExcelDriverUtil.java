package test;

import org.testng.annotations.Test;

import commonlibs.utils.Exceldriver;

public class TestExcelDriverUtil {
@Test
public void VerifyTestExcelDriverUtil()throws Exception{
	
Exceldriver exceldriver=new Exceldriver();

String excelworkbook=System.getProperty("user.dir")+"/testData/excelWorkbook.xlsx";

String sheetname="TestData";

exceldriver.createworkbook(excelworkbook);	

exceldriver.openworkbook(excelworkbook);

exceldriver.createsheet(sheetname);

exceldriver.setcelldata(sheetname, 0, 0,"Nithya");
exceldriver.setcelldata(sheetname, 0, 1,"jai");

exceldriver.setcelldata(sheetname, 1, 0,"Dhana");
exceldriver.setcelldata(sheetname, 1, 1,"NN");

exceldriver.savefile();
exceldriver.closeworkbook();
}
}

