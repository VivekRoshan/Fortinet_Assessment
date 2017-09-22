package problem_4;

public class Color implements PrintType{

	private String printerId;
	private String UserName = "User";
	public Color(String printerId) {
		this.printerId = printerId;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}

	@Override
	public String print() {
		System.out.println(this.UserName+ ", Your \"Color\" Document Created "
				+ "and sent to the Printer "+printerId);
        return "Please collect your Color print at the printing station";
	
	}

	
}
