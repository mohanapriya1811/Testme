package listeners;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

public class IReporterListener implements IReporter {

	public void generateReport(List<XmlSuite> xmlSuite, List<ISuite> iSuite, String outputDirectory) {
		for(ISuite suite : iSuite) {
			String suiteName = suite.getName();
			Map<String, ISuiteResult> testResult = suite.getResults();
			
			Collection<ISuiteResult> result = testResult.values();
			
			for(ISuiteResult resultSet:result) {
				int size = resultSet.getTestContext().getPassedTests().getAllResults().size();
				
					System.out.println(size); 
				
			}
		}
		
	}

}
