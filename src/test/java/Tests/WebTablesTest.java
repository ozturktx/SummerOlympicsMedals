package Tests;

import Utilities.TestBase;
import com.sun.org.apache.bcel.internal.generic.DREM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WebTablesTest extends TestBase {
public boolean sortString(List<WebElement> check)
{
    boolean issorted=true;
    for (int i=0;i<check.size()-1;i++)
    {
        if(check.get(i).getText().compareToIgnoreCase(check.get(i+1).getText())>0)
        {
            issorted=false;
            System.out.println(check.get(i+1).getText());
            //System.out.println(check.get(i+2).getText());
            break;
        }
    }
    return issorted;
}
    public boolean sortInt(List<WebElement> check)
    {
        boolean issorted=true;
        int[] ranks=new int[check.size()];
        for(int i=0;i<ranks.length;i++)
        {
            if(check.get(i).getText().equals("11–86")) {
                ranks[i] = Integer.parseInt(check.get(i).getText().substring(0, 2));
            continue;
            }
            ranks[i]=Integer.parseInt(check.get(i).getText());
        }
        Arrays.sort(ranks);
        for (int i = 0; i <ranks.length ; i++) {
            if(!Integer.toString(ranks[i]).equals(check.get(i).getText()))
            {
                issorted=false;
                break;
            }
        }
        return issorted;
    }

public String  mostGold()
{
    String country="";
WebElement sortButton=driver.findElement(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//thead//th[3]"));
    sortButton.click();
if(sortButton.getAttribute("title").equals("Sort descending")){
sortButton.click();
}
WebElement countryCell=driver.findElement(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody//tr[2]//th//img"));
country=countryCell.getAttribute("title");
  //  System.out.println(country);
    return country;
}
    public String mostSilver()
    {
        String country="";
        WebElement sortButton=driver.findElement(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//thead//th[4]"));
        sortButton.click();
        if(sortButton.getAttribute("title").equals("Sort descending")){
            sortButton.click();
        }
        WebElement countryCell=driver.findElement(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody//tr[2]//th//img"));
        country=countryCell.getAttribute("title");
        //  System.out.println(country);
        return country;
    }

    public String mostBronze()
    {
        String country="";
        WebElement sortButton=driver.findElement(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//thead//th[5]"));
        sortButton.click();
        if(sortButton.getAttribute("title").equals("Sort descending")){
            sortButton.click();
        }
        WebElement countryCell=driver.findElement(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody//tr[2]//th//img"));
        country=countryCell.getAttribute("title");
        //  System.out.println(country);
        return country;
    }
    public String mostMedal()
    {
        String country="";
        WebElement sortButton=driver.findElement(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//thead//th[6]"));
        sortButton.click();
        if(sortButton.getAttribute("title").equals("Sort descending")){
            sortButton.click();
        }
        WebElement countryCell=driver.findElement(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody//tr[2]//th//img"));
        country=countryCell.getAttribute("title");
        //  System.out.println(country);
        return country;
    }

    public List<String> silverCountries(){

    List<String>Combinednames=new ArrayList<String>();
    List<WebElement> medals=driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody//td[3]"));
    List<WebElement>names=driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody//th//img"));
    medals.remove(medals.size()-1);
        medals.remove(medals.size()-1);
     //   System.out.println(medals.size());
       // System.out.println(names.size());
        for (int i = 0; i < medals.size(); i++) {
            Combinednames.add(i,(names.get(i).getAttribute("title")+"---->"+medals.get(i).getText()));
        //    System.out.println(Combinednames.get(i));
        }
       /* for (WebElement a:medals) {
            System.out.println(a.getText());
        }
        for (WebElement a:names) {
            System.out.println(a.getAttribute("title"));
        }*/
            return Combinednames;
    }

    public int findLocation(String country)
    {
        List<WebElement>names=driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody//th//img"));
        int row=1;
        for (WebElement a:names) {
            if(a.getAttribute("title").equals(country))
            {
               return row;
            }else{
                row++;
            }
        }
        if(row>names.size())
            try {
                throw new Exception("Country can't be find");
            } catch (Exception e) {
                e.printStackTrace();
            }
        return row;
    }

    public List<String> twoCountries()
    {
        List<String> countries=new ArrayList<String>();

        List<WebElement> medals=driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody//td[4]"));
        List<WebElement>names=driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody//th//img"));
        medals.remove(medals.size()-1);
        medals.remove(medals.size()-1);
        for(int i=0;i<medals.size()-1;i++){
            if(Integer.parseInt(medals.get(i).getText())+Integer.parseInt(medals.get(i+1).getText())==18)
            {
                countries.add(names.get(i).getAttribute("title"));
                countries.add(names.get(i+1).getAttribute("title"));
            }
        }
        return countries;

    }
    @Test
    public void findtotal18()
    {
        System.out.println(twoCountries());
    }
    @Test
    public void findLocation()
    {

        System.out.println("Column is 2 and Row is "+findLocation("Japan"));
    }

    @Test
    public void silverCountrNames()
    {
        System.out.println(silverCountries());
    }
    @Test
    public void sortTest(){

    List<WebElement> rranks=driver.findElements(
            By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody//tr//td[1]"));
    rranks.remove(rranks.size()-1);
    rranks.remove(rranks.size()-1);
    //verifies that rank is ascending order
Assert.assertTrue(sortInt(rranks));
driver.findElement(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//thead//th[2]")).click();
List<WebElement> countries=driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody//tr//th[1]"));

//verifies countries are alphatical order
    Assert.assertTrue(sortString(countries));
    rranks=driver.findElements(
            By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody//tr//td[1]"));
    //verifies that rank is not ascending order anymore
    Assert.assertTrue(!sortInt(rranks));


}

    @Test
    public void findGoldCountry()
    {
        System.out.println("Country that has most gold medals:"+mostGold());
        System.out.println("Country that has most Silver medals:"+mostSilver());
        System.out.println("Country that has most Bronze medals:"+mostBronze());
        System.out.println("Country that has most medals:"+mostMedal());
    }


}
