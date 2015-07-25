package GAI;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Created by Эдуард on 01.07.15.
 */
public class Helper implements Runnable {
    //make exemplar CarOwner

    private static List<CarOwner> CAR_OWNER = new ArrayList<>();
//    static {
//
//        System.out.println(CAR_OWNER);
//        List<Offenses> offenses=new ArrayList<>();
//        List<Offenses> randomOffenses=new ArrayList<>();
//        for (Offenses i:Offenses.values()){
//            offenses.add(i);
//        }
//        Random random = new Random();
//        BufferedReader bufferedReader = null;
//        List<String> namesBase = new ArrayList<>();
//        try {
//        bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\JAVA\\Name.txt")));
//        String word;
//
//        while ((word=bufferedReader.readLine())!=null){
//                namesBase.add(word);
//               }
//
//            bufferedReader.close();
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        for (int i = 0; i <= 10; i++) {
//            CarOwner carOwner = new CarOwner();
//            carOwner.setQuantityCars(random.nextInt(4));
//            carOwner.setIndividualID(i + 1);
//            carOwner.setName(namesBase.get(random.nextInt(namesBase.size() - 1)));
//            carOwner.setLastname("OwnerLastName" + i);
//            carOwner.setFirstname("OwnerFirstName" + i);
//            carOwner.setYearOfBbirth(1940 + random.nextInt(70));
//            for (int k=0;k<random.nextInt(2);){
//                randomOffenses.add(offenses.get(random.nextInt(6)));
//            }
//            carOwner.setTheListOfOffenses(new ArrayList<Offenses>(randomOffenses));
//            randomOffenses.clear();
//            carOwner.setPassportSeries("P" + random.nextInt(10));
//            carOwner.setPassportNamber(1000 + random.nextInt(10000));
//            carOwner.setAdress("Kharkov" + i);
//            carOwner.setDriver_sLicenseNumber(random.nextInt(30));
//            carOwner.setCategoryDrivingLicense("A" + i);
//            carOwner.setDateIssuanceOfPassports(random.nextInt(75), random.nextInt(12), random.nextInt(30));
////            CAR_OWNER.add(i, carOwner);
//        }

//    }
    public static CarOwner getOwnerById(Integer id) throws InterruptedException, SAXException, ParserConfigurationException, IOException {
        for (CarOwner carOwner:getCarsOwners()){
            if (carOwner.getIndividualID().equals(id)){return carOwner;}
        }
        return null;
    }
    public static List<CarOwner> getCarsOwners () throws InterruptedException, IOException, SAXException, ParserConfigurationException {
        XmlSax xmlSax=new XmlSax();
        CAR_OWNER = xmlSax.getOwners();
//        System.out.println(CAR_OWNER);


        return CAR_OWNER;
    }
    //make exemplars Car
    private static List<Car> CARS=new ArrayList<>();
    static {
        Random random = new Random();

        for (int i = 0; i <= 30; i++) {
            Car car = new Car();
            car.setBrand("Brand" + i);
            car.setModel("Model" + i);
            car.setNamber("AX" + random.nextInt(9999) + "AC   ");
            car.setAccidents(random.nextInt(2));
            car.setInspectionDate(random.nextInt(4), random.nextInt(12), random.nextInt(30));
            car.setReleaseDate(random.nextInt(15), random.nextInt(12), random.nextInt(30));
            CARS.add(i,car);
        }
    }
    public static List<Car> getCars(){
        return CARS;
    }


    public static HashMap<Integer, List<Car>> getRegistration() throws InterruptedException, ParserConfigurationException, SAXException, IOException {

        Helper carOwner = new Helper();
        Helper car = new Helper();
        HashMap<Integer, List<Car>> registration = new HashMap<>();
        int auto = 0;
        List<Car> cars = new ArrayList<>();
        for (CarOwner owner : carOwner.getCarsOwners()) {
            int ID = owner.getIndividualID();
            if (owner.getQuantityCars() > 1) {
                for (int i = 0; i < owner.getQuantityCars(); i++) {
                    cars.add(car.getCars().get(auto));
                    auto++;
                }
            }
            if (owner.getQuantityCars() <= 1) {

                cars.add(car.getCars().get(auto));
                auto++;
            }
            registration.put(ID, new ArrayList<>(cars));
            cars.clear();
        }
//        carOwner.setNames(strings);
        return registration;
    }

    @Override
    public void run() {
        try {

            getCars();
            getRegistration();
            getCarsOwners();
            System.out.println(getOwnerById(1));
                   } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
