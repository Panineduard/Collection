import java.io.Serializable;

/**
 * Created by Ёдуард on 13.06.15.
 */
public class Result implements Serializable {
    private int result1 = 0;//—колько забили они
    private int result2 = 0;//—колько забили им
    private String nameCommand1;//»м€ нашей команды
    private String nameCommand2;//»м€ команды с которой играли
Result(int result1,int result2, String nameCommand1,String nameCommand2){
    this.result1=result1;
    this.result2= result2;
    this.nameCommand1 = nameCommand1;
    this.nameCommand2 = nameCommand2;
}
    public int getResult1(){
        return result1;
    }
    public  int getResult2(){
        return result2;
    }
    public String getNameCommand1(){
        return nameCommand1;
    }
    public String getNameCommand2(){
        return nameCommand2;
    }

}
