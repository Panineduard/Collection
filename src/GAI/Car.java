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

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Integer year,Integer month,Integer day) {

        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, -year);
        c.add(Calendar.MONTH, month);
        c.add(Calendar.DAY_OF_MONTH, day);
        releaseDate = c.getTime();

    }

    public Date getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(Integer year,Integer month,Integer day) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR,-year);
        c.add(Calendar.MONTH, month);
        c.add(Calendar.DAY_OF_MONTH, day);
        inspectionDate = c.getTime();

    }

    public String getNamber() {
        return namber;
    }

    public void setNamber(String namber) {
        this.namber = namber;
    }

    public Integer getAccidents() {
        return accidents;
    }

    public void setAccidents(Integer accidents) {
        this.accidents = accidents;
    }



    @Override
    public String toString(){
        return "Namber  - "+namber+"  DTP  - "+accidents;
    }//+"Inspection date  - "+format.format(inspectionDate)

   


}
