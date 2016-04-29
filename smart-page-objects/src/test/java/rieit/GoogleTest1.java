package rieit;

import static org.junit.Assert.*;
import org.junit.Test;
import rieit.page.Google1;
import rieit.page.GoogleResult1;
import org.junit.After;

public class GoogleTest1{

	String Url = "https://www.google.co.in";

	@Test
	public void should_Return_Url() {
		
		Google1 googlePage = new Google1(Url);

		googlePage.open(); // should able to open the correct Url.

		CharSequence testUrl = Url;
		
		boolean flag = googlePage.getUrl().contains(testUrl);

		assertEquals(true, flag);

	}

	//@Test
	public void should_Return_Page_Is_Ready() {

		Google1 googlePage = new Google1( Url);

		googlePage.open();

		assertEquals(true, googlePage.isReady());

	}

	//@Test
	public void should_Be_Able_To_Enter_Text_In_BoxComponent() {

		Google1 googlePage = new Google1( Url);

		googlePage.open();
		
		googlePage.submitSearchQuery("Hello Java World!");
			
		assertEquals(true, googlePage.boxComponent().isReady());

	}

	//@Test
	public void should_Be_Able_To_Navigate_To_Result_Page_After_Entering_The_Search_Criteria() {

		Google1 googlePage = new Google1(Url);
			
		GoogleResult1 googleResult = new GoogleResult1(Url);

		googlePage.open();

		googlePage.submitSearchQuery("Hello Java World!");

		assertEquals(true, googleResult.isReady());
			
	}

	//@Test
	public void should_Not_Be_Able_To_Navigate_To_Result_Page_Witout_Entering_The_Search_Criteria() {

		Google1 googlePage = new Google1(Url);

		googlePage.open();

		googlePage.submitSearchQuery("Hello Java World!");

		googlePage.clearSearchQuery();
			
		googlePage.submitSearchQuery("");
		
		CharSequence testUrl = Url;
		
		boolean flag = googlePage.getUrl().contains(testUrl);

		assertEquals(true, flag);
	
	}

	@After
	public void afterTest() {
		
		DriverFactory.getInstance().removeDriver();
	}
}

