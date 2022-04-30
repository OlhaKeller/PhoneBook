package manager;

import org.slf4j.LoggerFactory;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.slf4j.Logger;

public class TestNgMyListener implements ITestListener, ISuiteListener {
    //mozna xoch vsi methodu implementuvatu
    Logger logger = LoggerFactory.getLogger(TestNgMyListener.class);

    @Override
    public void onStart(ISuite suite) {
        ISuiteListener.super.onStart(suite);
        logger.info("onStart(ISuite suite)");
    }

    @Override
    public void onFinish(ISuite suite) {
        ISuiteListener.super.onFinish(suite);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        logger.info("onTestFailure");
    }

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        logger.info("onTestStart"+result.getTestName());
    }
}
