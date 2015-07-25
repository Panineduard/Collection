package GAI;

/**
 * Created by Эдуард on 09.07.15.
 */
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XmlSax extends DefaultHandler implements Runnable{
    private String thisElement = "";
    CarOwner carOwner;
    private static List<CarOwner> owners=new ArrayList<>();
    public List<CarOwner> getOwners(){return owners;}

//    public List<CarOwner> carOvners() throws ParserConfigurationException, SAXException, IOException {
//
//
////      System.out.println(saxp.getOwners());
//    }
    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start parse XML...");
    }
    @Override
    public void startElement(String namespaceURI, String localName, String
            qName, Attributes atts) throws SAXException {
        thisElement=qName;
        if("CarOwner".equals(qName)){
             carOwner = new CarOwner();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if ("id".equals(thisElement)) carOwner.setIndividualID(new Integer(new String(ch, start, length)));
        if (thisElement.equals("name")) carOwner.setName(new String(ch, start, length));
        if (thisElement.equals("firstname")) carOwner.setFirstname(new String(ch, start, length));
        if (thisElement.equals("lastname")) carOwner.setLastname(new String(ch, start, length));
        if (thisElement.equals("yearOfBbirth")) carOwner.setYearOfBbirth(new Integer(new String(ch, start, length)));
        if (thisElement.equals("passportSeries")) carOwner.setPassportSeries(new String(ch, start, length));
        if (thisElement.equals("passportNamber"))
            carOwner.setPassportNamber(new Integer(new String(ch, start, length)));
        if (thisElement.equals("dateIssuanceOfPassports"))
            carOwner.setDateIssuanceOfPassports(new Integer(new String(ch, start, length - 8)),
                    (new Integer(new String(ch, start + 3, length - 8))), (new Integer(new String(ch, start + 6, length - 6))));
        if (thisElement.equals("adress")) carOwner.setAdress(new String(ch, start, length));
        if (thisElement.equals("driver_sLicenseNumber"))
            carOwner.setDriver_sLicenseNumber(new Integer(new String(ch, start, length)));
        if (thisElement.equals("categoryDrivingLicense"))
            carOwner.setCategoryDrivingLicense(new String(ch, start, length));
        if (thisElement.equals("theListOfOffenses") && length > 0) {
            List<Offenses> offenses = new ArrayList<>();
            String[] offences = new String(ch,start,length).split(",");
               for (String offenses1:offences){

                   offenses.add(Offenses.valueOf(offenses1));
               }
            carOwner.setTheListOfOffenses(offenses);
            }

    }
    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        thisElement="";

        if("CarOwner".equals(qName)){

            owners.add(carOwner);
        }
    }
    @Override
    public void endDocument() {
        System.out.println("Stop parse XML...");
    }

    @Override
    public void run() {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            XmlSax saxp = new XmlSax();
            parser.parse(new File("D:\\JAVA\\Collection\\src\\GAI\\file1.xml"), saxp);
            } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
