package testCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestCaseFunction.SignInFunction;
import listener.Listener;
import Utils.BaseTest;

@Listeners({Listener.class})
public class SignInTest extends BaseTest{

@Test
	public void signInTestCase() {
		SignInFunction signInFunction = new SignInFunction(driver);
		signInFunction.SignInForm();
	}

}
