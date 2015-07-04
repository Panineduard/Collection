package GAI;

import java.util.*;

/**
 * Created by ������ on 01.07.15.
 */
public class Servise implements Runnable {

    public void run()		//���� ����� ����� ����������� � �������� ������
    {
        Builder s=new Builder();
        System.out.println(s.getCarsOwners());
    }
    //����� ���������� � ������������ ���������, ������������������ �� ������� ������������� (����� ������������ �� �������);
    public List<Car> SearchByName(String name){
        Registration registration=new Registration();
        registration.getRegistration();
        List<Car>list;
        Builder owner =new Builder();
        int ID=0;
        for (CarOwner carOwner:owner.getCarsOwners()){
            if(carOwner.getName().contains(name)){
                ID=carOwner.getIndividualID();

            }
        }
        if(ID==0){ System.out.println("Incorrect name!!!");
            return null;
        }
        list=registration.getRegistration().get(ID);
        return list;
    }
    //����� ���������� � ��������� �� ����� ��������� �����;
    public List<CarOwner> SearchByNamber(String namber){
        Car car =new Car();
        List<CarOwner> searchOwners=new ArrayList<>();
        Car searchingCar=new Car();
Registration registration=new Registration();
        Integer id=0;
        Builder carOwner=new Builder();
        for (Car car1:carOwner.getCars()) {
            if (car1.getNamber().contains(namber)) {
                searchingCar = car1;
                for (int i=1;i<registration.getRegistration().size();i++){
                    for (Car c : registration.getRegistration().get(i)) {
                        if (c==car1) {
                            searchOwners.add(carOwner.getOwnerById(i));
                        }}}}}
        return searchOwners;
    }

    //����� ���������� � ���� ������������ ���������, ������� �� ��������� ��;
    public HashSet<Car> notTtimelyServise(Integer k){
        Builder car =new Builder();
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
    // ����� ���������� � ���� ��������������, ������� ��������� ����������� � ��������� ����;
    public HashSet<CarOwner> whoViolated(Offenses of) {
        HashSet<CarOwner> owners = new HashSet<>();
        Builder carOwner = new Builder();
        for (CarOwner carOwn :carOwner.getCarsOwners()){
            for (Offenses offenses:carOwn.getTheListOfOffenses()){
                if(of.equals(offenses))owners.add(carOwn);
            }
        }
        return owners;
    }
    //����� ���������� � ���� ������������ ���������, ������������� � ���.
    public HashSet<Car> carsAccident(){
        Builder car =new Builder();
        HashSet<Car> cars=new HashSet<>();
        for (Car car1:car.getCars()){
            if(car1.getAccidents()>=1)cars.add(car1);
        }
        return cars;
    }
}
