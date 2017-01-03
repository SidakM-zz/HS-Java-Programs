
public class Customer {
private String name,phone,street,postal,province, city;
	public Customer(String name, String phone, String street, String postal, String province, String city){//create a customer with the following information
		this.name = name;//set the object variables to the values received when the object was created
		this.phone = phone;
		this.street = street;
		this.postal = postal;
		this.province = province;
		this.city = city;
	}
	public Customer(){//create a blank customer
		
	}
	public void setName(String name){//set the name 
		this.name = name;
	}
	public void setPhone(String phone){//sets the phone number
		this.phone= phone;
	}
	public void setStreet(String street){//sets the street
		this.street= street;
	}
	public void setPostal(String postal){//sets the postal code
		this.postal= postal;
	}
	public void setProvince(String province){//sets the province
		this.province= province;
	}
	public void setCity(String city){//sets the city
		this.city= city;
	}
	
	public String getName(){//gets the name
		return this.name;
	}
	public String getPhone(){//gets the phone number
		return this.phone;
	}
	public String getStreet(){//gets the street
		return this.street;
	}
	public String getPostal(){//gets the postal
		return this.postal;
	}
	public String getProvince(){//gets the province  
		return this.province;
	}
	public String getCity(){///gets the city
		return this.city;
	}
	public static void main(String args[]){//self testing main
		Customer nam = new Customer();//create a blank new customer
		nam.setName("Sidak");//set its values
		nam.setPhone("905465798");
		nam.setStreet("Swag Road");
		nam.setPostal("8h67d5");
		nam.setProvince("Ontario");
		nam.setCity("Toronto");
		System.out.println(nam.getName() + " " + nam.getPhone() + " " + nam.getStreet() + " " + nam.getPostal() + " " + nam.getProvince() + " " + nam.getCity());//print out the set values
		
		Customer name = new Customer("name", "phone", "street", "postal", "province", "city");//create a new customer with all the values preset
		System.out.println(name.getName() + " " + name.getPhone() + " " + name.getStreet() + " " + name.getPostal() + " " + name.getProvince() + " " + name.getCity());//print out the created values
		
	}
}
