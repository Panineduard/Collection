import java.io.Serializable;

/**
 * Created by ������ on 13.06.15.
 */
public class Result implements Serializable {
    private int result1 = 0;//������� ������ ���
    private int result2 = 0;//������� ������ ��
    private String nameCommand1;//��� ����� �������
    private String nameCommand2;//��� ������� � ������� ������
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
