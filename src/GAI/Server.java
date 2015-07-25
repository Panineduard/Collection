package GAI;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

public class Server{
    static Servise servise = new Servise();
    public static void main(String[] ar)    {
        int port = 9000; // ��������� ���� (����� ���� ����� ����� �� 1025 �� 65535)

        try {
            ServerSocket ss = new ServerSocket(port); // ������� ����� ������� � ����������� ��� � �������������� �����
            System.out.println("Waiting for a client...");

            Socket socket = ss.accept(); // ���������� ������ ����� ����������� � ������� ��������� ����� ���-�� �������� � ��������
            System.out.println("Client conect");
            System.out.println();
            // ����� ������� � �������� ������ ������, ������ ����� �������� � �������� ������ �������.
            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();
            // ������������ ������ � ������ ���, ���� ����� ������������ ��������� ���������.
            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);
            String line = null;
            String standartMessage="You may point wat yuo want. "+"\n"+"If you write 1, see cars are not passed servise."+"\n"+"If you write 2. You can search by namber";
            out.writeUTF(standartMessage);
            out.flush();

//            Thread threadServise = new Thread(servise);

            while(true) {
                line = in.readUTF(); // ������� ���� ������ ������� ������ ������.
                System.out.println("The client sent me this line : " + line);

//                out.writeUTF(line); // �������� ������� ������� �� ����� ������ ������.
                out.flush(); // ���������� ����� ��������� �������� ������.
                if(line.equals("1")) {
                    Servise servise = new Servise();
                    HashSet<Car> hashMap = new HashSet();
                    hashMap=servise.notTtimelyServise(1);
                    String avto="These cars are not passed in time servise - ";
                    for (Car car:hashMap) {
                    avto += car.getNamber();
                    }
                    out.writeUTF(avto);
                    out.flush();
                    }
                if(line.equals("2")) {
                    String carOwnere="Owner of the car you were looking for resides at - ";
                    Servise servise = new Servise();
                    out.writeUTF("Please enter the number of cars");
                    out.flush();
                    String namber=null;
                    namber=in.readUTF();
                    List<CarOwner> carOwners=new ArrayList<>();
                    carOwners=servise.SearchByNamber(namber);
                    for (CarOwner carOwner:carOwners){
                    carOwnere+=carOwner.getAdress();
                    }

                    out.writeUTF(carOwnere);
                    out.flush();
                }
                System.out.println("Waiting for the next line...");
                System.out.println();
            }

        } catch(Exception x) { x.printStackTrace(); }
    }
}