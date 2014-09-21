package data;

public class Address {
	private int HouseNumber;
	private String RoadName;
	private String Town;
	private String PostCode;
	
	public static final String NoAddress = "No fixed abode";
	
	public Address(int houseNumber, String roadName, String town, String postCode)
	{
		HouseNumber = houseNumber;
		RoadName = roadName;
		Town = town;
		PostCode = postCode;
	}
	
	public int getHouseNumber() {
		return HouseNumber;
	}
	public String getRoadName() {
		return RoadName;
	}
	public String getTown() {
		return Town;
	}
	public String getPostCode() {
		return PostCode;
	}
	
}
