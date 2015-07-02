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

        Builder carOwner = new Builder();
        Builder car = new Builder();
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

}
