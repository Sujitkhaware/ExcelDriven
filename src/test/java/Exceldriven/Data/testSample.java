package Exceldriven.Data;

import java.io.IOException;
import java.util.ArrayList;

public class Testsample {

	public static void main(String[] args) throws IOException {
		
		Datadriven data = new Datadriven();
		ArrayList<String> dataOne = data.getData("Purchase");
		System.out.println(dataOne.get(0));
		System.out.println(dataOne.get(1));
		System.out.println(dataOne.get(2));
		System.out.println(dataOne.get(3));
	}
}