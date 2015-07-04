package GAI;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
import java.util.Random;

/**
 * Created by denis.selutin on 6/18/2015.
 */
public class Client {
    public static void main(String[] ar) {
        int serverPort = 9000; // ����� ����������� ����� ������� ���� � �������� ������������� ������.
        String address = "127.0.0.1"; // ��� IP-����� ����������, ��� ����������� ���� ��������� ���������.
        // ����� ������ ����� ���� ������ ���������� ��� ����� ����������� � ������.

        try {
            InetAddress ipAddress = InetAddress.getByName(address); // ������� ������ ������� ���������� ������������� IP-�����.
            Socket socket = new Socket(ipAddress, serverPort); // ������� ����� ��������� IP-����� � ���� �������.
            // ����� ������� � �������� ������ ������, ������ ����� �������� � �������� ������ ��������.
            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();
            String line = null;
            // ������������ ������ � ������ ���, ���� ����� ������������ ��������� ���������.
            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);
            line = in.readUTF(); // ���� ���� ������ ������� ������ ������.
            System.out.println(line);
            // ������� ����� ��� ������ � ����������.
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));



            while (true) {
                line = keyboard.readLine(); // ���� ���� ������������ ������ ���-�� � ������ ������ Enter.
                System.out.println("Sending this line to the server...");
                out.writeUTF(line); // �������� ��������� ������ ������ �������.
                out.flush(); // ���������� ����� ��������� �������� ������.

                line = in.readUTF(); // ���� ���� ������ ������� ������ ������.
                System.out.println("The server sent me this : " + line);
                System.out.println();

            }
        } catch (Exception x) {
            x.printStackTrace();
        }
    }
}