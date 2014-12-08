package data;

public class Address {
	private final int HouseNumber;
	private final String RoadName;
	private final String Town;
	private final String PostCode;
	private final String Country;
	
	public static final String NoAddress = "No fixed abode";
	
	public Address( final int houseNumber, final String roadName, final String town, final String postCode, final String country )
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
