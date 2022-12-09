package utils;

import org.testng.annotations.DataProvider;

import commonlibs.utils.Exceldriver;

public class TestDataProvider {

@DataProvider
public Object[][] getUserData() throws Exception{

	String CurrentWorkingDirectory=System.getProperty("user.dir");
	
	String Workbookname=CurrentWorkingDirectory+"/TestDataInputFiles/TestData.xlsx";
		
	String Sheetname="Test Data";
	
	Exceldriver exceldriver=new Exceldriver();
	
	Object[][] data;
	
	exceldriver.openworkbook(Workbookname);
	
	int rowcount=exceldriver.getrowcount(Sheetname);
	int cellcount=exceldriver.getcellcountfromarow(Sheetname, 0);
	
	data=new Object[rowcount+1][cellcount];
	
	for(int row=0;row<=rowcount;row++) {
		for(int cell=0;cell<cellcount;cell++) {
			
			data[row][cell]=exceldriver.getcelldata(Sheetname, row, cell);
		}
	}
return data;
		
		}

}
