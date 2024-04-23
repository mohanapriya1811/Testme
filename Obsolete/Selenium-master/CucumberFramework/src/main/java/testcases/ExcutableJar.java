package testcases;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class ExcutableJar {
	
	public static void main(String[] args) {
		XmlSuite suite = new XmlSuite();
		suite.setName("XmlSuite");
		XmlTest  test = new XmlTest(suite);
		test.setName("XmlTest");
		
		List<XmlClass> classes = new ArrayList<XmlClass>();
		classes.add(new XmlClass(testcases.Login_TC_01.class));
		classes.add(new XmlClass(testcases.Create_Lead_01.class));
		test.setXmlClasses(classes);
		
		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(suite);
		TestNG tng = new TestNG();
		tng.setXmlSuites(suites);
		tng.run();
		
		
		
	}
}
