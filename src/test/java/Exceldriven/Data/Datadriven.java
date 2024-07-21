package Exceldriven.Data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Datadriven {
	
	//The below is the main base for driving the sheet data.

	public static void main(String[] args) throws IOException {

		// We have to pass the file path. In fileInputStream object.
		// The fileInputStream shall have the power to read the file.

		FileInputStream fis = new FileInputStream(
				"F:\\Working Projects\\Selenium_Java\\Interview Questions\\Part_2\\5_Data.xlsx");

		// We have created the object for the method.
		//The workBook have an ability to access the file now as we have passed the "fis" object name in that.
		XSSFWorkbook workBook = new XSSFWorkbook(fis);
		
		//Now we shall go to the desired sheet
		//Before that we shall get the count of the sheet present in the excel file.
		//So if there are 10 sheet we shall get it into a loop and check which perticular sheet we need to check.
		//Once the sheet name is been matched then we will access that sheet.
		int sheets = workBook.getNumberOfSheets();
		for(int i=0;i<sheets;i++) {
			
			//If the sheet name matches then only do the action.
			if(workBook.getSheetName(i).equalsIgnoreCase("TestData1")) {
			//Here i means one by one it shall iterate between the sheets.
			//The return type for the below is XSSFSheet
			XSSFSheet sheetName = workBook.getSheetAt(i);
			
			//So now we have the access to the sheet which we want.
			//Identify Testcases column by scanning the entire 1st row.
			//Once column is identified scan entire test cases column to identify purchase testcase.
			//After you grab purchase test case row pull all the data of that row and feed into test
			
			//How to iterate through each and every row of the sheet.
			Iterator<Row> rows = sheetName.iterator();
			//So once we define the above then the rows have the power to iterate through each and every row
			//So we shall first scan the 1st row. so .next() shall go to the first row, then if we again write the same.
			//It shall then go to the second row.
			//Row is the return type.
			
			Row firstRow = rows.next();
			//Once we got to the row, we have to scan each and every row cell.
			//We can iterate through each and every row by using the below
			
			Iterator<Cell> cell = firstRow.cellIterator();
			
			//have declared one variable for the below
			int k = 0;
			int column = 0;
			
			//There is method apart from next(), that is hasNext()
			//hasNext is something which tells if next cell is present.
			//Its like the next object whatever is present or not. It shall only check but not move.
			while(cell.hasNext()) {
				//We are checking if the cell is present, if yes then we shall move to it as of below.
				//Below we are capturing the value.
				Cell valueOfCell = cell.next();
				//Once we captured the value then we have to read it.
				//getStringValue shall extract the string value present in the cell.
				//Here we are comparing it
				if(valueOfCell.getStringCellValue().equalsIgnoreCase("Testcases")){
					//once the cell value is been matched. It nothing but the index number.
					column = k;
				}
				
				//The above k which we have defined shall increment after each and every while loop.
				//Why we are doing this below. so first it check for the 1st value if it is not true.
				//Then the below k shall increment by 1
				k++;
			}
			System.out.println(column);
			
			//How to scan a single column
			while(rows.hasNext()) {
				Row r = rows.next();
				if(r.getCell(column).getStringCellValue().equalsIgnoreCase("Purchase")) {
					//Once match is found, we have to pull all of the data for that row.
					Iterator<Cell> cv = r.cellIterator();
					while(cv.hasNext()) {
						//the below will only move next in the purchase row cell.
						System.out.println(cv.next().getStringCellValue());
						//
					}
				}
			}
			}
		}
	}

}
