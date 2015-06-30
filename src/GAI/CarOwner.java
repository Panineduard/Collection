package GAI;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Эдуард on 17.06.15.
 */
public class CarOwner {
private  List<String> NAMES=new ArrayList<>();
    private Integer quantityCars=0;
    private Integer individualID;
    private   String name;
    private   String firstname;
    private   String lastname;
    private   Integer yearOfBbirth;
    private   String passportSeries;
    private   Integer passportNamber;
    SimpleDateFormat format = new SimpleDateFormat("dd,MM,yyyy");
    private   Date dateIssuanceOfPassports;
    private   String adress;
    private   Integer driver_sLicenseNumber;
    private   String categoryDrivingLicense;
    private List<Offenses> theListOfOffenses= new ArrayList<>();
    public void setNames(List<String> list){
       NAMES =list;
    }

    private void setTheListOfOffenses(List<Offenses> theListOfOffenses) {
        this.theListOfOffenses = theListOfOffenses;
    }

    private void setQuantityCars(Integer quantityCars) {
        this.quantityCars = quantityCars;
    }

    public Integer getQuantityCars() {
        return quantityCars;
    }

    public Integer getIndividualID() {
        return individualID;
    }

    private void setIndividualID(Integer individualID) {
        this.individualID = individualID;
    }

    public String getName(){
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getFirstname(){
        return firstname;
    }

    private void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname(){
        return lastname;
    }

    private void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getYearOfBbirth() {
        return yearOfBbirth;
    }

    private void setYearOfBbirth(Integer yearOfBbirth) {
        this.yearOfBbirth = yearOfBbirth;
    }

    public String getPassportSeries(){
        return passportSeries;
    }

    private void setPassportSeries(String passportSeries) {
        this.passportSeries = passportSeries;
    }

    public Integer getPassportNamber() {
        return passportNamber;
    }

    private void setPassportNamber(Integer passportNamber) {
        this.passportNamber = passportNamber;
    }

    public Date getDateIssuanceOfPassports() {
        return dateIssuanceOfPassports;
    }

    private void setDateIssuanceOfPassports(Integer year,Integer month,Integer day) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, -year);
        c.add(Calendar.MONTH, month);
        c.add(Calendar.DAY_OF_MONTH, day);
        dateIssuanceOfPassports = c.getTime();
    }

    public String getAdress(){
        return adress;
    }

    private void setAdress(String adress) {
        this.adress = adress;
    }

    public Integer getDriver_sLicenseNumber() {
        return driver_sLicenseNumber;
    }

    private void setDriver_sLicenseNumber(Integer driver_sLicenseNumber) {
        this.driver_sLicenseNumber = driver_sLicenseNumber;
    }

    public  String getCategoryDrivingLicense(){
        return categoryDrivingLicense;
    }

    private void setCategoryDrivingLicense(String categoryDrivingLicense) {
        this.categoryDrivingLicense = categoryDrivingLicense;
    }

    public List<Offenses> getTheListOfOffenses() {
        return theListOfOffenses;
    }

    private void setTheListOfOffenses(Offenses ofOffenses) {
        theListOfOffenses.add(ofOffenses);
       }

    @Override
    public String toString(){
        return "Name  - "+name+ "  Offenses - "+theListOfOffenses;
    }
    private static List<CarOwner> CAR_OWNER = new ArrayList<>();

public CarOwner getOwnerById(Integer id){
    for (CarOwner carOwner:CAR_OWNER){
        if (carOwner.getIndividualID()==id){return carOwner;}
    }

    return null;
}
   static {
       List<Offenses> offenses=new ArrayList<>();
       List<Offenses> randomOffenses=new ArrayList<>();
       for (Offenses i:Offenses.values()){
           offenses.add(i);
       }
           Random random = new Random();
       for (int i = 0; i <= 10; i++) {
           CarOwner carOwner = new CarOwner();
           carOwner.setQuantityCars(random.nextInt(4));
           carOwner.setIndividualID(i);
           carOwner.setName("Owner" + i);
           carOwner.setLastname("OwnerLastName" + i);
           carOwner.setFirstname("OwnerFirstName" + i);
           carOwner.setYearOfBbirth(1940 + random.nextInt(70));
          for (int k=0;k<random.nextInt(2);){
              randomOffenses.add(offenses.get(random.nextInt(6)));
          }
           carOwner.setTheListOfOffenses(new ArrayList<Offenses>(randomOffenses));
           randomOffenses.clear();
           carOwner.setPassportSeries("P" + random.nextInt(10));
           carOwner.setPassportNamber(1000 + random.nextInt(10000));
           carOwner.setAdress("Kharkov" + i);
           carOwner.setDriver_sLicenseNumber(random.nextInt(30));
           carOwner.setCategoryDrivingLicense("A" + i);
           carOwner.setDateIssuanceOfPassports(random.nextInt(75), random.nextInt(12), random.nextInt(30));
           CAR_OWNER.add(i, carOwner);
       }
   }
    public List<CarOwner> getCarsOwners () {
           return CAR_OWNER;
       }
   }
