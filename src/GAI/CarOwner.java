package GAI;
import javax.xml.bind.annotation.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Эдуард on 17.06.15.
 */
@XmlRootElement( name = "CarOwner" )
@XmlType( propOrder = { "individualID", "name", "firstname","lastname", "yearOfBbirth", "passportSeries","passportNamber", "dateIssuanceOfPassports",
        "adress","driver_sLicenseNumber", "categoryDrivingLicense", "quantityCars","theListOfOffenses" } )

public class CarOwner {
//private  List<String> NAMES=new ArrayList<>();
    private Integer quantityCars=0;
    private Integer individualID;
    private   String name;
    private   String firstname;
    private   String lastname;
    private   Integer yearOfBbirth;
    private   String passportSeries;
    private   Integer passportNamber;
    private   Date dateIssuanceOfPassports;
    private   String adress;
    private   Integer driver_sLicenseNumber;
    private   String categoryDrivingLicense;
    private List<Offenses> theListOfOffenses= new ArrayList<>();
//    public void setNames(List<String> list){
//       NAMES =list;
//    }

    @XmlElement(name = "theListOfOffenses")
    public void setTheListOfOffenses(List<Offenses> theListOfOffenses) {
        this.theListOfOffenses = theListOfOffenses;
    }

    public void setQuantityCars(Integer quantityCars) {
        this.quantityCars = quantityCars;
    }

    public Integer getQuantityCars() {
        return quantityCars;
    }

    public Integer getIndividualID() {
        return individualID;
    }
    @XmlElement(name = "id")
    public void setIndividualID(Integer individualID) {
        this.individualID = individualID;
    }

    public String getName(){
        return name;
    }
    @XmlElement (name = "name")
    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname(){
        return firstname;
    }
    @XmlElement (name = "firstname")
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname(){
        return lastname;
    }
    @XmlElement (name = "lastname")
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getYearOfBbirth() {
        return yearOfBbirth;
    }
    @XmlElement (name = "yearOfBbirth")
    public void setYearOfBbirth(Integer yearOfBbirth) {
        this.yearOfBbirth = yearOfBbirth;
    }

    public String getPassportSeries(){
        return passportSeries;
    }
    @XmlElement (name = "passportSeries")
    public void setPassportSeries(String passportSeries) {
        this.passportSeries = passportSeries;
    }

    public Integer getPassportNamber() {
        return passportNamber;
    }
    @XmlElement (name = "passportNamber")
    public void setPassportNamber(Integer passportNamber) {
        this.passportNamber = passportNamber;
    }

    public Date getDateIssuanceOfPassports() {
        return dateIssuanceOfPassports;
    }
    @XmlElement(name = "dateIssuanceOfPassports")////////!!!!!!!!!!!!!!!!
    public void setDate(String date){
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(date);
        int start = 0;
        int i = 0;
        int[] arrayNambers=new int[3];
        while (matcher.find(start)) {

            String value = date.substring(matcher.start(), matcher.end());
            int result = Integer.parseInt(value);
            arrayNambers[i]=result;
            i++;
            start = matcher.end();
        }
        setDateIssuanceOfPassports(arrayNambers[2],arrayNambers[1],arrayNambers[0]);
    }
    public void setDateIssuanceOfPassports(Integer year,Integer month,Integer day) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, -year);
        c.add(Calendar.MONTH, month);
        c.add(Calendar.DAY_OF_MONTH, day);
        dateIssuanceOfPassports = c.getTime();
    }

    public String getAdress(){
        return adress;
    }
    @XmlElement (name = "adress")
    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Integer getDriver_sLicenseNumber() {
        return driver_sLicenseNumber;
    }
    @XmlElement (name = "driver_sLicenseNumber")
    public void setDriver_sLicenseNumber(Integer driver_sLicenseNumber) {
        this.driver_sLicenseNumber = driver_sLicenseNumber;
    }

    public  String getCategoryDrivingLicense(){
        return categoryDrivingLicense;
    }
    @XmlElement (name = "categoryDrivingLicense")
    public void setCategoryDrivingLicense(String categoryDrivingLicense) {
        this.categoryDrivingLicense = categoryDrivingLicense;
    }
   // @XmlElementWrapper
    public List<Offenses> getTheListOfOffenses() {
        return theListOfOffenses;
    }

    @Override
    public String toString(){
        return "Name  - "+name+ "  Offenses - "+theListOfOffenses+"  ID- "+individualID;
    }

}
