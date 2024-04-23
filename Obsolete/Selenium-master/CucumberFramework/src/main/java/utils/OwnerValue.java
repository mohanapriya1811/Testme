package utils;

import org.aeonbits.owner.ConfigFactory;

public class OwnerValue {

	static ReadFromInterface inter = ConfigFactory.create(ReadFromInterface.class);
	
	public static String getUsername() {
		return inter.username();
	}
	
	public static String getPassword() {
		return inter.password();
	}
	
	public static String getLeads() {
		return inter.leadsLinkText();
	}
	
	public static String getCreateLead() {
		return inter.createLeadLinkText();
	
	}
	
	public static void main(String[] args) {
		
		System.out.println(getUsername());
		
	}
}
