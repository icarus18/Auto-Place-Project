
public class CarInfo {
	
	String number; //Account Number
	String brand;
	String model;
	int year;
	boolean oilChange;
	boolean tireRotation;
	boolean alignment;
	String date;
	String time;
	
	public CarInfo(String n, String b, String m, int y, boolean o, boolean t, boolean a, String d, String i) {
		
		number = n;
		brand = b;
		model = m;
		year = y;
		oilChange = o;
		tireRotation = t;
		alignment = a;
		date = d;
		time = i;
		
		
	}

	public String getAccount() 
	{
		return number;
	}
	public String getBrand() {
		return brand;
	}
	public String getModel() {
		return model;
	}
	public int getYear() {
		return year;
	}
	
	public boolean getOilChange() {
		return oilChange;
	}
	
	public boolean getTireRotation() {
		return tireRotation;
	}
	
	public boolean getAlignment() {
		return alignment;
	}
	
	public String getDate() {
	return date;
	}
	
	public String getTime() {
		return time;
	}
	
	
	
	
	//Setters
	public void setNumber(String number2) {
		this.number = number2;
	}

	public void setOilChange(boolean oilchange2) {
		this.oilChange = oilchange2;
	}
	
	public void setTireRotation(boolean tireRotation2) {
		this.tireRotation = tireRotation2;
	}
	
	public void setAlignment(boolean alignment2) {
		this.alignment = alignment2;
	}
	
	public void setDate(String date2) 
	{
		this.date = date2;
	}
	public void setTime(String time2) 
	{
		this.time = time2;
	}
	public void setYear(int year2) 
	{
		this.year = year2;
	}
	public void setMake(String make2) 
	{
	this.brand = make2;
	}
	public void setModel(String model2) 
	{
		this.model = model2;	
	}

}
