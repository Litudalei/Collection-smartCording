import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SmartCodingCollection {
    public static void main(String[] args) {
        System.out.println("code is customized and not for production");
        List<String> countryList=new LinkedList<>();
        countryList.add("India");
        countryList.add("Usa");
        countryList.add("Uk");
        countryList.add("Germany");
        countryList.add("India");
        System.out.println(countryList);
       /* for(String country:countryList)
        {
            System.out.println(country.toUpperCase());
        }*/
        java.util.Iterator<String> iteratorlist =countryList.iterator();
        while(iteratorlist.hasNext())
        {
            System.out.println(iteratorlist.next());
        }
    }
}
