/**
 * Created by Эдуард on 13.06.15.
 */
import java.util.*;

public class SportingEvent {

    public static void main(String[]args){
        Random rand = new Random();
        List <Integer> list =new ArrayList<>();
        for (int i=0;i<=7;i++) {
            Integer integer = rand.nextInt(11);
            list.add(integer);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) { //Задали способ сортировки обьектов переопределив метод компаре
                return -1 * (o1 - o2);
            }
        });
        list.remove(list.size() - 1);
        Collections.reverse(list);
        list.remove(list.size()-1);
        int summ=0;
        for (int i=0;i<=list.size()-1;i++){
            summ+=list.get(i);
        }
        double rezult = (double)summ/list.size();
        System.out.println(list);
        System.out.println(summ);
        System.out.println(rezult);

    }
}
