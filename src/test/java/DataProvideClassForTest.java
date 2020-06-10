import org.testng.annotations.DataProvider;

public class DataProvideClassForTest {

	@DataProvider(name = "datas")
	public Object[][] testDatas(){
		return new Object[][] {
			{"WWW", "TTT"},
			{"UUU", "NNNN"}
		};
		
	}
}
