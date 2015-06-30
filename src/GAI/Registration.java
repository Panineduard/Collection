package GAI;

import GAI.Car;
import GAI.CarOwner;
import java.util.Date;
import java.util.*;

/**
 * Created by Эдуард on 17.06.15.
 */
public class Registration {
    public HashMap<Integer, List<Car>> getRegistration() {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\JAVA\\Name.txt")));
//        String word;
//        List<String> strings = new ArrayList<>();
//        while ((word=bufferedReader.readLine())!=null){
//            int i=0;
//            strings.add(i,word);
//            i++;
//        }
//        bufferedReader.close();
        CarOwner carOwner = new CarOwner();
        Car car = new Car();
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
    //поиск информации о транспортных средствах, зарегистрированных на данного автовладельца (поиск осуществлять по фамилии);
    public List<Car> SearchByName(String name){
        List<Car>list;
        CarOwner owner =new CarOwner();
        int ID=0;
        for (CarOwner carOwner:owner.getCarsOwners()){
              if(name.equals(carOwner.getName())){
              ID=carOwner.getIndividualID();
            }
        }
        if(ID==0){ System.out.println("Incorrect name!!!");
        return null;
        }
        Registration registration=new Registration();
        list=registration.getRegistration().get(ID);
        return list;
    }
    //поиск информации о владельце по части номерного знака;
    public List<CarOwner> SearchByNamber(String namber){
        Car car =new Car();
        List<CarOwner> searchOwners=new ArrayList<>();
        Car searchingCar=new Car();

        Integer id=0;
        CarOwner carOwner=new CarOwner();
         for (Car car1:car.getCars()) {
             if (car1.getNamber().contains(namber)) {
                 searchingCar = car1;
                 for (int i=0;i<getRegistration().size();i++){
                     for (Car c : getRegistration().get(i)) {
                         if (c==car1) {
                             searchOwners.add(carOwner.getOwnerById(i));
                         }}}}}

return searchOwners;
    }
//вывод информации о всех транспортных средствах, вовремя не прошедших ТО;
public HashSet<Car> notTtimelyServise(Integer k){
    Car car =new Car();
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
 public HashSet<CarOwner> whoViolated(Offenses of) {
HashSet<CarOwner> owners = new HashSet<>();
     CarOwner carOwner = new CarOwner();
     for (CarOwner carOwn :carOwner.getCarsOwners()){
         for (Offenses offenses:carOwn.getTheListOfOffenses()){
             if(of.equals(offenses))owners.add(carOwn);
         }
     }
return owners;
 }
    //вывод информации о всех транспортных средствах, участвовавших в ДТП.
public HashSet<Car> carsAccident(){
    Car car =new Car();
    HashSet<Car> cars=new HashSet<>();
    for (Car car1:car.getCars()){
        if(car1.getAccidents()>=1)cars.add(car1);
    }
    return cars;
}
}
