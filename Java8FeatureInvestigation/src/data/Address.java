package data;

public class Address {
	private String FirstLine;
	private String SecondLine;
	private String Town;
	private String PostCode;
	
	public Address(String firstLine, String secondLine, String town, String postCode)
	{
		FirstLine = firstLine;
		SecondLine = secondLine;
		Town = town;
		PostCode = postCode;
	}
	
	public String getFirstLine() {
		return FirstLine;
	}
	public String getSecondLine() {
		return SecondLine;
	}
	public String getTown() {
		return Town;
	}
	public String getPostCode() {
		return PostCode;
	}
	
}
