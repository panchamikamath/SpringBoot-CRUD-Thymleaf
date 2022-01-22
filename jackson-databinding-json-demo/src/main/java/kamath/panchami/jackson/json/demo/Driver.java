package kamath.panchami.jackson.json.demo;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		
		//create object mapper
		ObjectMapper mapper = new ObjectMapper();
		
		//read json and convert to POJO
		try {
			//Student theStudent = mapper.readValue(new File("data/sample-lite.json"), Student.class);
			
			Student theStudent = mapper.readValue(new File("data/sample-full.json"), Student.class);
			
			System.out.println("First Name : " + theStudent.getFirstName());
			System.out.println("Last Name : " + theStudent.getLastName());
			
			Address tempAddress = theStudent.getAddress();
			System.out.println("Street = " + tempAddress.getStreet());
			System.out.println("City = " + tempAddress.getCity());
			System.out.println("Zip = " + tempAddress.getZip());
			System.out.println("Country = " + tempAddress.getCountry());
			
			System.out.print("Languages = ");
			for( String i : theStudent.getLanguages())
				System.out.print(i + " ");
			
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
