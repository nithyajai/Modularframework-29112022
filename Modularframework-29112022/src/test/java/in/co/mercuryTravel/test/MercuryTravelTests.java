package in.co.mercuryTravel.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;


public class MercuryTravelTests extends BaseTest {

@Test
public void VerifyUserLoginWithCorrectCredentials()throws Exception
{
extenttest=extent.createTest("TC-001 - Verify User Login with correct Credentials");
	
String username = configProperties.getProperty("userEmailId");

extenttest.log(Status.INFO,"User EmailId -"+username);

String password=configProperties.getProperty("UserPassword");

extenttest.log(Status.INFO,"User Password - "+password);

homepage.UserLogin(username, password);

String Expectedmessage=configProperties.getProperty("expectedmsg");

String Actualmessage=homepage.getmessage();

Assert.assertEquals(Expectedmessage,Actualmessage);

extenttest.log(Status.INFO,"User login successful - ");

}


	
}
