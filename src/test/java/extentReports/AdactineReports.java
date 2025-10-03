package extentReports;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class AdactineReports implements ITestListener   // interface
{

	//declare some varible
		public ExtentSparkReporter report;
		//It provides the Basic info about Document(ReportName,Document title,theme)
		public ExtentReports extent;
		//It will provide the info about users(username,OS,Browser,Environment,HostName)
		public ExtentTest test;
		//It will provide the abisc info about testCases(Pass,Faild,Skipped)
		
		//pre defined methods(OnStart,OnTestSuccess,OnTestFailure,OnTestSkipped,OnFinish)
		public void onStart(ITestContext tr) 
		{
			report = new ExtentSparkReporter("C:\\Users\\Dell\\Desktop\\jp\\EMS_Project_40\\AdactineReports\\reports.html");
			report.config().setReportName("AdactineHotel");
			report.config().setDocumentTitle("AdactineFunctionalities");
			report.config().setTheme(Theme.DARK);
			
			extent = new ExtentReports();
			extent.attachReporter(report);
			extent.setSystemInfo("UserName", "Sharath");
			extent.setSystemInfo("OS", "Windows");
			extent.setSystemInfo("Browser", "Chrome");
			extent.setSystemInfo("Environment", "QA Environment");
			extent.setSystemInfo("HostName", "Local Host");
		}
		
		public void onTestSuccess(ITestResult tr) {
			test = extent.createTest(tr.getName());
			test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		}
		
		public void onTestFailure(ITestResult tr) {
			test = extent.createTest(tr.getName());
			test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		}
		
		public void onTestSkipped(ITestResult tr) {
			test = extent.createTest(tr.getName());
			test.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.YELLOW));
		}

		public void onFinish(ITestContext context) {	
			extent.flush();				//It will remove the un-neccessary data
		}
		
			
		}



