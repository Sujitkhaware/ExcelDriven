package Exceldriven.Data;

import java.io.IOException;
import java.util.ArrayList;

public class testSample {

	public static void main(String[] args) throws IOException {
		
		Datadriven data = new Datadriven();
		ArrayList<String> dataOne = data.getData("Purchase");
		System.out.println(dataOne.get(0));
		

	}

}
