import jdk.internal.org.objectweb.asm.tree.analysis.Value;

import java.io.*;
import java.util.*;

/**
 * Created by ������ on 13.06.15.
 */
public class FootballCommand {
    public static void main(String[]args) throws IOException, ClassNotFoundException {
        Random random = new Random();
        List<Result> list = new ArrayList<Result>();
        for (int j = 1; j < 7; j++) {
            for (int i = 1; i <= 7; ) {
                if (j >= i) i++;
                else {
                    Result result = new Result(random.nextInt(20), random.nextInt(20), "Command" + j, "Command" + i);
                    list.add(result);
                    i++;
                }
            }
        }
        //����������� � ���� ����������
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\JAVA\\temp.out"));

        oos.writeObject(list);
        oos.flush();
        oos.close();
        //����������� �� ����� ����������
        ObjectInputStream oin = new ObjectInputStream(new FileInputStream("D:\\JAVA\\temp.out"));
        List<Result> list2 = new ArrayList<>();
        list2=(ArrayList<Result>) oin.readObject();
        oin.close();


        Map<String, Integer> victory = new TreeMap<>();
        Map<String, Integer> scores = new TreeMap<>();
        for (Result i : list2) {
            scores.put(i.getNameCommand1(), 0);
            scores.put(i.getNameCommand2(), 0); }
        for (Result k : list2) {
            victory.put(k.getNameCommand1(), 0);
            victory.put(k.getNameCommand2(), 0);}
        //������� ���������� ������
        for (Result i : list2) {
            Integer res = scores.get(i.getNameCommand1());
            Integer res1 = scores.get(i.getNameCommand2());
            if (i.getResult1() > i.getResult2()) {
                scores.put(i.getNameCommand1(), res += 3);}
            if (i.getResult1() < i.getResult2()) {
                scores.put(i.getNameCommand2(), res1 += 3);}

            if (i.getResult1() == i.getResult2()) {
                scores.put(i.getNameCommand1(), res += 1);
                scores.put(i.getNameCommand2(), res1 += 1);}
        }
        //������� ���������� �����
        for (Result k : list2) {
            Integer win1 = victory.get(k.getNameCommand1());
            Integer win2 = victory.get(k.getNameCommand2());
            if (k.getResult1() > k.getResult2()) {
                victory.put(k.getNameCommand1(), win1 += 1); }
            if (k.getResult1() < k.getResult2()) {
                victory.put(k.getNameCommand2(), win2 += 1); }
         }


        Set<Map.Entry<String, Integer>> s = scores.entrySet(); // ��������� ��� ������ ����� � Set
        List list1 =new ArrayList<Map.Entry>(s);               //������� ���� �� ������ ������ ���� ��������
        Collections.sort(list1, new Comparator<Map.Entry>() {  // ������� ���������� �� ��������

            public int compare(Map.Entry o1, Map.Entry o2) {
                return -1 * ((Integer)o1.getValue()).compareTo((Integer)o2.getValue());
            }
        });
        list1.remove(list1.size()-1);  //������� ������� � ����������� �������

        System.out.println(victory);
        System.out.println(scores);
        System.out.println(list1);
    }


}
