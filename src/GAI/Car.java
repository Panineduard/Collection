package GAI;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 *

 * Created by Эдуард on 17.06.15.
 */
public class Car {
    private String brand;
    private String model;
    SimpleDateFormat format = new SimpleDateFormat("dd,MM,yyyy");
    private Date releaseDate;
    private Date inspectionDate;
    private String namber;
    private Integer accidents =0;

    public String getBrand() {
        return brand;
    }

    private void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    private void setModel(String model) {
        this.model = model;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    private void setReleaseDate(Integer year,Integer month,Integer day) {

        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, -year);
        c.add(Calendar.MONTH, month);
        c.add(Calendar.DAY_OF_MONTH, day);
        releaseDate = c.getTime();

    }

    public Date getInspectionDate() {
        return inspectionDate;
    }

    private void setInspectionDate(Integer year,Integer month,Integer day) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR,-year);
        c.add(Calendar.MONTH, month);
        c.add(Calendar.DAY_OF_MONTH, day);
        inspectionDate = c.getTime();

    }

    public String getNamber() {
        return namber;
    }

    private void setNamber(String namber) {
        this.namber = namber;
    }

    public Integer getAccidents() {
        return accidents;
    }

    private void setAccidents(Integer accidents) {
        this.accidents = accidents;
    }

    private static List<Car> CARS=new ArrayList<>();

    @Override
    public String toString(){
        return "Namber  - "+namber+"  DTP  - "+accidents;
    }//+"Inspection date  - "+format.format(inspectionDate)

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
    public List<Car> getCars(){
        return CARS;
    }

}
