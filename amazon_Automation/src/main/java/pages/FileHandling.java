package pages;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileHandling {
	 String data ;
	 
	 
	@SuppressWarnings("resource")
	public void fetch_data(String locator , String src) throws FileNotFoundException {
		File file = new File(src);
		Scanner scanner = new Scanner(file);
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] linesplit = line.split(" ");
		    if(linesplit[0].equalsIgnoreCase(locator)) {
		    	data = linesplit[2];
		    	System.out.println(linesplit[0]);
		    	System.out.println(linesplit[2]);
		    }	
	    }
	}
}
