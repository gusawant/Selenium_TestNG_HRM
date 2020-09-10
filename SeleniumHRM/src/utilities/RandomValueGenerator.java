package utilities;

public class RandomValueGenerator {

	public Double d = (Math.random() + 1) * 10000;

	public String firstName = "FName_" + Math.round(d);
	public String lastName = "lName_" + Math.round(d);

	public String employeeName = firstName + " " + lastName;
	
	public String companyName = "Test Company_" + Math.round(d);
}
