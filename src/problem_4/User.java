package problem_4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
public class User {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("---Welcome to the printing Interface---");
		System.out.println("Available options:");
		System.out.println("1:Fortinet#09222017 //newer but highly demanded");
		System.out.println("2:Fortinet#19111993 //older but less queued"); System.out.println();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String selection = null;String userName = null;int option = 1;
        try {System.out.print("Enter your Username: ");
        	userName = br.readLine();
        	System.out.print("Enter your selection: Color or BlackAndWhite: ");
        	selection = br.readLine();
        	System.out.print("Enter your option of printer: ");
    		option = in.nextInt();
    	} catch (IOException e) {e.printStackTrace();}
        Factory factory = PrinterFactory.getUniqueInstance();
        factory.setPrinter(option);
        PrintType objStmtType = factory.printDocument(selection);
        objStmtType.setUserName(userName);
        System.out.println(objStmtType.print());System.out.println();
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
        String selection2 = null;String userName2 = null;
        try {System.out.print("Enter your Username: ");
        	userName2 = br.readLine();
        	System.out.print("Enter your selection: Color or BlackAndWhite: ");
        	selection2 = br2.readLine();
        	System.out.print("Enter your option of printer: ");
    		option = in.nextInt();
        } catch (IOException e) {e.printStackTrace();}
        Factory factory2 = PrinterFactory.getUniqueInstance();
        factory2.setPrinter(option);
        PrintType objStmtType2 = factory2.printDocument(selection2);
        objStmtType2.setUserName(userName2);
        System.out.println(objStmtType2.print());
        in.close();
	}
}
