package problem_4;

public class PrinterFactory extends Factory {
    private static PrinterFactory uniqueInstance;
    private static String printerId = "Fortinet#09222017";
    private PrinterFactory() {
    }
    
    public void setPrinter(int i){
    	if(i==1)
    	{
    		printerId = "Fortinet#09222017";
    	}
    	if(i==2)
    	{
    		printerId = "Fortinet#19111993";
    	}
    }
    public static PrinterFactory getUniqueInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new PrinterFactory();
            System.out.println("Creating a new PrinterFactory instance");
        }
        return uniqueInstance;
    }
    @SuppressWarnings("static-access")
	public PrintType printDocument(String selection) {
        if (selection.equalsIgnoreCase("color")) {
            return new Color(this.printerId);
        } else if (selection.equalsIgnoreCase("blackAndWhite")) {
            return new BlackAndWhite(this.printerId);
        }
        throw new IllegalArgumentException("Selection doesnot exist");
    }
}
