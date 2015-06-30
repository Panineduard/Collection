package GAI;

import java.util.Scanner;

/**
 * * 3. Разработать программу, предназначенную для обработки данных ГАИ о владельцах автотранспорта и зарегистрированных на них автомобилей.
 О владельцах автотранспорта хранится следующая информация: фамилия, имя, отчество, год рождения, серия и номер паспорта, дата выдачи и адрес прописки, номер и категория прав,
 список правонарушений. Об автотранспорте хранится следующая информация: марка автомобиля и название модели, дата выпуска, дата прохождения последнего ТО,
 номерной знак, факт участия в ДТП. Организовать данные о паспорте и автотранспорте в виде отдельных структур, которые используются внутри структуры, описывающей автовладельца.
 Учесть возможность владения несколькими автомобилями. Возможные правонарушения организовать в виде перечисления. Краткая информация о ДТП, представленная битовыми полями,
 должна включать информацию о вине водителя, количестве пострадавших и количестве транспортных средств, пострадавших в ДТП.
 В программе создать хранить 10 автовладельцев. Программа должна предоставлять следующий набор функций:
 д) вывод информации о всех транспортных средствах (ФИО владельца в том числе);
 е) поиск информации о транспортных средствах, зарегистрированных на данного автовладельца (поиск осуществлять по фамилии);
 ж) поиск информации о владельце по части номерного знака;
 з) вывод информации о всех транспортных средствах, вовремя не прошедших ТО;
 и) вывод информации о всех автовладельцах, которые управляли транспортом в нетрезвом виде;
 к) вывод информации о всех транспортных средствах, участвовавших в ДТП.
 * Created by Эдуард on 28.06.15.
 */
public class Main_Gai {
    public static void main(String[]args){
        Registration registration=new Registration();
        CarOwner s=new CarOwner();
        Scanner scanner = new Scanner(System.in);
        System.out.println(s.getCarsOwners());
        System.out.println(registration.getRegistration());
        System.out.println("SearchByName");
        System.out.println(registration.SearchByName("Owner" + 6));
        System.out.println("SearchByNamber");
        System.out.println("Input namber");
        String options=null;
        if (scanner.hasNext()) {
            options = (String)scanner.next();
        } else System.out.println("Incorrect number of retry");

        System.out.println(registration.SearchByNamber(options));
        System.out.println("NotTtimelyServise");
        System.out.println(registration.notTtimelyServise(1));
        System.out.println("whoViolated");
        System.out.println(registration.whoViolated(Offenses.DRUNK_DRIVER));
        System.out.println("carsAccident");
        System.out.println(registration.carsAccident());



    }
}
