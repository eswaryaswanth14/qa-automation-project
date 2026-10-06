package retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

	int count=0;
	
	@Override
	public boolean retry(ITestResult result) {
		
		return false;
	}
	
	
	
	

}
