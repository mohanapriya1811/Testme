package utils;

import org.aeonbits.owner.Config;
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources("classpath:config_english.properties")
public interface ReadFromInterface extends Config {
	
	String username();
	
	String password();
	
	
	// For Composite names we need to use Config.Key
	@Config.Key("MyHomePage.Leads.LinkText")
	String leadsLinkText();
	
	@Config.Key("LeadsPage.CreateLead.LinkText")
	String createLeadLinkText();

	
}
