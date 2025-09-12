package  com.alok.selenium.dataprovider;

import org.testng.annotations.DataProvider;

import com.alok.selenium.utils.ExcelUtils;

public class TestData{
	@DataProvider(name="userData")
	public static Object[][] getUsers(){
		return new Object[][] {
			{"student","Password123"},
			{"teacher","Techer123"},
			{"Madam","madam1234"}
		};
		}
	@DataProvider(name = "excelData")
	public static Object[][] getExcelData() throws Exception{
     String filePath = "src/test/resources/UserData.xlsx";
        return ExcelUtils.readExcelData(filePath, "Sheet1");
	
	}
}