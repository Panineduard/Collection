package GAI;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.*;

/**
 * Created by Эдуард on 01.07.15.
 */
public class Servise implements Runnable {

    public void run()		//Этот метод будет выполняться в побочном потоке
    {
//        Servise servise = new Servise();
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("SearchByNamber");
//        System.out.println("Input namber");
//        String options=null;
//        if (scanner.hasNext()) {
//            options = (String)scanner.next();
//        } else System.out.println("Incorrect number of retry");
//        System.out.println(options);
//        try {
//
//
////            System.out.println(servise.SearchByNamber(options));
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (SAXException e) {
//            e.printStackTrace();
//        } catch (ParserConfigurationException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
    //поиск информации о транспортных средствах, зарегистрированных на данного автовладельца (поиск осуществлять по фамилии);
    public List<Car> SearchByName(String name) throws InterruptedException, IOException, SAXException, ParserConfigurationException {
        List<Car>list;
        Helper owner =new Helper();
        owner.getRegistration();
        int ID=0;
        String name1=name.replaceAll(" ","");
        for (CarOwner carOwner:owner.getCarsOwners()){//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!


            if(name1.contains(carOwner.getName())){

                ID=carOwner.getIndividualID();
            }
        }
        if(ID==0){ System.out.println("Incorrect name!!!");
            return null;
        }
        list=owner.getRegistration().get(ID);
        return list;
    }
    //поиск информации о владельце по части номерного знака;
    public List<CarOwner> SearchByNamber(String namber) throws InterruptedException, IOException, SAXException, ParserConfigurationException {
        List<CarOwner> searchOwners=new ArrayList<>();
        Helper carOwner=new Helper();
        for (Car car1:carOwner.getCars()) {
            if (car1.getNamber().contains(namber)) {
                for (int i=1;i<carOwner.getRegistration().size();i++){
                    for (Car c : carOwner.getRegistration().get(i)) {
                        if (c==car1) {
                            searchOwners.add(carOwner.getOwnerById(i));
                        }}}}}
        return searchOwners;
    }

    //вывод информации о всех транспортных средствах, вовремя не прошедших ТО;
    public HashSet<Car> notTtimelyServise(Integer k){
        Helper car =new Helper();
        HashSet<Car> searchCars=new HashSet<>();
        Date date;
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, -k);
        date=c.getTime();
        for (Car car1:car.getCars()) {
            if (car1.getInspectionDate().before(date)) searchCars.add(car1);
        }
        return searchCars;
    }
    // вывод информации о всех автовладельцах, которые управляли транспортом в нетрезвом виде;
    public HashSet<CarOwner> whoViolated(Offenses of) throws InterruptedException, ParserConfigurationException, SAXException, IOException {
        HashSet<CarOwner> owners = new HashSet<>();
        Helper carOwner = new Helper();
        for (CarOwner carOwn :carOwner.getCarsOwners()){
            for (Offenses offenses:carOwn.getTheListOfOffenses()){
                if(of.equals(offenses))owners.add(carOwn);
            }
        }
        return owners;
    }
    //вывод информации о всех транспортных средствах, участвовавших в ДТП.
    public HashSet<Car> carsAccident(){
        Helper car =new Helper();
        HashSet<Car> cars=new HashSet<>();
        for (Car car1:car.getCars()){
            if(car1.getAccidents()>=1)cars.add(car1);
        }
        return cars;
    }
}
