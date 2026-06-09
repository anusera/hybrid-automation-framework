package com.anu.framework.utilities;

import com.github.javafaker.Faker;

public class FakerUtility {
	
	private static final Faker faker = new Faker();
	
	public static String getFirstName() {
		return faker.name().firstName();
	}
	
	public static String getLastName() {
		return faker.name().lastName();
	}
	
	public static String getPostalCode() {
		return faker.address().zipCode();
	}
	
	
	

}
