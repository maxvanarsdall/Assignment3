/*
 * This code is a main file to run the Json write and FlatfileReader
 * 
 * Authors: Max Van Arsdall and Tristin Gilbert
 * 
 * 
 */
package reports;

import java.util.List;
import datacontainers.Person;
import datacontainers.Customer;
import datacontainers.Invoice;
import datacontainers.Product;
import filereader.FlatFileReader;
import fileWriter.JsonWriter;

public class DataConverter {

	public static void main(String[] args) {

		// Create a FlatFileReader object
		FlatFileReader fr = new FlatFileReader();

		/*
		 * fr Reads data from the flat file; Creates Person objects; and Stores Person
		 * objects in a Person ArrayList
		 */
		List<Person> personList = fr.readPersons();

		/*
		 * fr Reads data from the flat file; Creates Customer objects; and Stores Customer
		 * objects in a Customer ArrayList
		 */
		List<Customer> customerList = fr.readCustomers(personList);

		/*
		 * fr Reads data from the flat file; Creates Product objects; and Stores Product
		 * objects in a Product ArrayList
		 */
		List<Product> productList = fr.readProducts(customerList);
		
		
		
		

		
		JsonWriter jWriter = new JsonWriter();

		// Write Person ArrayList into a Json file
		jWriter.jsonPersonConverter(personList);
		// Write Customer ArrayList into a Json file
		jWriter.jsonCustomerConverter(customerList);
		// Write Product ArrayList into a Json file
		jWriter.jsonProductConverter(productList);

	}
}
