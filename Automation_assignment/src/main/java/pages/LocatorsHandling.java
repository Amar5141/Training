package pages;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LocatorsHandling {
	protected String data;
	protected String username , password;
	
	@SuppressWarnings("resource")
	public void fetch_locators(String locator , String src) throws FileNotFoundException {
		File file = new File(src);
		Scanner scanner = new Scanner(file);
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] linesplit = line.split("   ");
		    if(linesplit[0].equalsIgnoreCase(locator)) {
		    	data = linesplit[2];		    	
		    }	
	    }
	}
	
	@SuppressWarnings("resource")
	public void fetch_credentials(String user) throws Exception {
		
		int rowCount;
		XSSFWorkbook workbook = new XSSFWorkbook("./src/test/resources/Records.xlsx");
		XSSFSheet sheet = workbook.getSheet("Creds");
		rowCount = sheet.getPhysicalNumberOfRows();

		for (int i = 1; i < rowCount; i++) {
			String userNo = sheet.getRow(i).getCell(0).getStringCellValue();
			
			if (userNo.equalsIgnoreCase(user)) {
				username = sheet.getRow(i).getCell(1).getStringCellValue();
				password = sheet.getRow(i).getCell(2).getStringCellValue();
			}

		}
	}
}
