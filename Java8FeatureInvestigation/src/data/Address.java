package data;

public class Address {
	private int HouseNumber;
	private String RoadName;
	private String Town;
	private String PostCode;
	private String Country;
	
	public static final String NoAddress = "No fixed abode";
	
	public Address(int houseNumber, String roadName, String town, String postCode, String country)
	{
		HouseNumber = houseNumber;
		RoadName = roadName;
		Town = town;
		PostCode = postCode;
		Country = country;
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
	
	public String getCountry() {
		return Country;
	}
}
