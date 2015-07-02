package GAI;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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

    public void setIndividualID(Integer individualID) {
        this.individualID = individualID;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname(){
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname(){
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getYearOfBbirth() {
        return yearOfBbirth;
    }

    public void setYearOfBbirth(Integer yearOfBbirth) {
        this.yearOfBbirth = yearOfBbirth;
    }

    public String getPassportSeries(){
        return passportSeries;
    }

    public void setPassportSeries(String passportSeries) {
        this.passportSeries = passportSeries;
    }

    public Integer getPassportNamber() {
        return passportNamber;
    }

    public void setPassportNamber(Integer passportNamber) {
        this.passportNamber = passportNamber;
    }

    public Date getDateIssuanceOfPassports() {
        return dateIssuanceOfPassports;
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

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Integer getDriver_sLicenseNumber() {
        return driver_sLicenseNumber;
    }

    public void setDriver_sLicenseNumber(Integer driver_sLicenseNumber) {
        this.driver_sLicenseNumber = driver_sLicenseNumber;
    }

    public  String getCategoryDrivingLicense(){
        return categoryDrivingLicense;
    }

    public void setCategoryDrivingLicense(String categoryDrivingLicense) {
        this.categoryDrivingLicense = categoryDrivingLicense;
    }

    public List<Offenses> getTheListOfOffenses() {
        return theListOfOffenses;
    }

    public void setTheListOfOffenses(Offenses ofOffenses) {
        theListOfOffenses.add(ofOffenses);
       }
    @Override
    public String toString(){
        return "Name  - "+name+ "  Offenses - "+theListOfOffenses+"  ID- "+individualID;
    }
   }
