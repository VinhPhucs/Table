package TestProject;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Demo1 {

    public static void main(String[] args) {

        String baseURL= "http://demo.guru99.com/test/web-table-element.php";

        //trigger browser
        System.setProperty("webdriver.gecko.driver","D:\\geckodriver.exe");
        WebDriver driver= new FirefoxDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();

        //utilize the defined method
        getTotalRowNumber(driver);
        getTotalColumnNumber(driver);
        getRowNumberByValue(driver,4,3);

    }

    private static void getRowNumberByValue(WebDriver driver, int i, int j) {
		// TODO Auto-generated method stub
		
	}

	//define method
    public static void getTotalRowNumber(WebDriver dr) {
        List <WebElement> rows = dr.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
        System.out.println("Total Rows: " + rows.size());
    }

    public static void getTotalColumnNumber(WebDriver dr) {
        List<WebElement> columns = dr.findElements(By.xpath("/html/body/div/div[3]/div[1]/table/thead/tr/th"));
        System.out.println("Total Colums: " + columns.size());
    }

    public static void getRowNumberByValue(String value, WebDriver dr) {
        List <WebElement> rows = dr.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr/td"));
        for (int i = 0; i < rows.size(); i++) {
            if (rows.get(i).getText().equals(value)) {
                System.out.println("Found item at row " + i);
            }
            else {
            	System.out.println(" Items " + value + " was not found ");
            }
        }
    }
    public static void getTableCellValue(WebDriver dr) {
        List <WebElement> shirtList = dr.findElements(By.xpath("//*[@id='product-wrapper']//li[@class='item-product-item']"));
    }
    
    public static void getTableCellValue(int row, int col ,WebDriver dr) {
        List <WebElement> rows = dr.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr"));
        WebElement SelectedRow = rows.get(row);
        List <WebElement> cols = SelectedRow.findElements(By.xpath("//td[4]"));
        System.out.println(cols.get(col).getText());
    }
}