package problem_4;

public class BlackAndWhite implements PrintType {

	private String printerId;
	private String UserName = "User";
	public BlackAndWhite(String printerId) {
		this.printerId = printerId;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}

	@Override
	public String print() {
		System.out.println(this.UserName+ ", Your \"Black and White\" Document "
				+ "Created and sent to the Printer "+printerId);
        return "Please collect your Black and White print at the printing station";

	}

}
