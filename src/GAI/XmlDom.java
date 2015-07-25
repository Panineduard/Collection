package GAI;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;

/**
 * Created by Эдуард on 11.07.15.
 */
public class XmlDom {
    public static void main(String[] args) throws Exception {
        Document doc = getDocument();
List<CarOwner> carOwners = new ArrayList<>();

//        String element = doc.getDocumentElement().getNodeName();
        NodeList nodeList= doc.getElementsByTagName("CarOwner");
  for (int j=0;j<nodeList.getLength();j++) {
      CarOwner carOwner=new CarOwner();
      Element element1=(Element)nodeList.item(j);
        List<Offenses>listOffenses=new ArrayList<>();
        for (int i=0;i<element1.getElementsByTagName("offence").getLength();i++) {
          listOffenses.add(Offenses.valueOf(element1.getElementsByTagName("offence").item(i).getChildNodes().item(0).getNodeValue()));}
              carOwner.setTheListOfOffenses(listOffenses);
              carOwner.setCategoryDrivingLicense(element1.getElementsByTagName("categoryDrivingLicense").item(0).getChildNodes().item(0).getNodeValue());
              carOwner.setDriver_sLicenseNumber(Integer.parseInt(element1.getElementsByTagName("driver_sLicenseNumber").item(0).getChildNodes().item(0).getNodeValue()));
              carOwner.setAdress(element1.getElementsByTagName("adress").item(0).getChildNodes().item(0).getNodeValue());
              carOwner.setDate(element1.getElementsByTagName("dateIssuanceOfPassports").item(0).getChildNodes().item(0).getNodeValue());
              carOwner.setPassportNamber(Integer.parseInt(element1.getElementsByTagName("passportNamber").item(0).getChildNodes().item(0).getNodeValue()));
              carOwner.setPassportSeries(element1.getElementsByTagName("passportSeries").item(0).getChildNodes().item(0).getNodeValue());
              carOwner.setYearOfBbirth(Integer.parseInt(element1.getElementsByTagName("yearOfBbirth").item(0).getChildNodes().item(0).getNodeValue()));
              carOwner.setLastname(element1.getElementsByTagName("lastname").item(0).getChildNodes().item(0).getNodeValue());
              carOwner.setName(element1.getElementsByTagName("name").item(0).getChildNodes().item(0).getNodeValue());
              carOwner.setFirstname(element1.getElementsByTagName("firstname").item(0).getChildNodes().item(0).getNodeValue());
              carOwner.setIndividualID(Integer.parseInt(element1.getElementsByTagName("id").item(0).getChildNodes().item(0).getNodeValue()));
              carOwner.setCategoryDrivingLicense(element1.getElementsByTagName("categoryDrivingLicense").item(0).getChildNodes().item(0).getNodeValue());
      carOwners.add(carOwner);
}
        System.out.println(carOwners);
    }
    private static Document getDocument() throws Exception {
        try {
            DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
            f.setValidating(false);
            DocumentBuilder builder = f.newDocumentBuilder();
            return builder.parse(new File("D:\\JAVA\\Collection\\src\\GAI\\file2.xml"));
        } catch (Exception exception) {
            String message = "XML parsing error!";
            throw new Exception(message);
        }
    }
}
