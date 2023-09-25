package com.listener;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.base.Base;
import com.utilities.BrowserUtilities;

public class TestNgListener extends Base implements ISuiteListener, ITestListener {

	{
		logger = LogManager.getLogger(TestNgListener.class);
	}

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String screenshotPath = null;

		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName().toString() + " FAILED  ", ExtentColor.RED));
			try {
				screenshotPath = BrowserUtilities.screenShot(result.getName().toString());
				test.addScreenCaptureFromPath(screenshotPath);
				logger.error(screenshotPath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName().toString() + " SKIPPED ", ExtentColor.YELLOW));
		}
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	}

}
