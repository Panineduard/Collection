package GAI;

import java.util.Scanner;

/**
 * * 3. ����������� ���������, ��������������� ��� ��������� ������ ��� � ���������� �������������� � ������������������ �� ��� �����������.
 � ���������� �������������� �������� ��������� ����������: �������, ���, ��������, ��� ��������, ����� � ����� ��������, ���� ������ � ����� ��������, ����� � ��������� ����,
 ������ ��������������. �� �������������� �������� ��������� ����������: ����� ���������� � �������� ������, ���� �������, ���� ����������� ���������� ��,
 �������� ����, ���� ������� � ���. ������������ ������ � �������� � �������������� � ���� ��������� ��������, ������� ������������ ������ ���������, ����������� �������������.
 ������ ����������� �������� ����������� ������������. ��������� �������������� ������������ � ���� ������������. ������� ���������� � ���, �������������� �������� ������,
 ������ �������� ���������� � ���� ��������, ���������� ������������ � ���������� ������������ �������, ������������ � ���.
 � ��������� ������� ������� 10 ��������������. ��������� ������ ������������� ��������� ����� �������:
 �) ����� ���������� � ���� ������������ ��������� (��� ��������� � ��� �����);
 �) ����� ���������� � ������������ ���������, ������������������ �� ������� ������������� (����� ������������ �� �������);
 �) ����� ���������� � ��������� �� ����� ��������� �����;
 �) ����� ���������� � ���� ������������ ���������, ������� �� ��������� ��;
 �) ����� ���������� � ���� ��������������, ������� ��������� ����������� � ��������� ����;
 �) ����� ���������� � ���� ������������ ���������, ������������� � ���.
 * Created by ������ on 28.06.15.
 */
public class Main_Gai {
    public static void main(String[]args){
        Registration registration=new Registration();
        Servise servise = new Servise();
        Builder s=new Builder();
        Scanner scanner = new Scanner(System.in);
        System.out.println(s.getCarsOwners());
        System.out.println(registration.getRegistration());
        System.out.println("SearchByName");
        String options1=null;
        if (scanner.hasNext()) {
            options1 = scanner.next();
        } else System.out.println("Incorrect number of retry");
        System.out.println(servise.SearchByName(options1));
        System.out.println("SearchByNamber");
        System.out.println("Input namber");
        String options=null;
        if (scanner.hasNext()) {
            options = (String)scanner.next();
        } else System.out.println("Incorrect number of retry");
        System.out.println(options);
        System.out.println(servise.SearchByNamber(options));
        System.out.println("NotTtimelyServise");
        System.out.println(servise.notTtimelyServise(1));
        System.out.println("whoViolated");
        System.out.println(servise.whoViolated(Offenses.DRUNK_DRIVER));
        System.out.println("carsAccident");
        System.out.println(servise.carsAccident());
    }
}
