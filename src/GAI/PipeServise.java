package GAI;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * Created by Ёдуард on 07.07.15.
 */
public class PipeServise implements Runnable{
     PipedReader in;

    PipeServise (PipedWriter pipe)throws IOException{
        PipedReader in = new PipedReader(pipe);
        this.in=in;
    }
        public void run() {
            try {
             while (true) {
                    char[] buffer = new char[200];//!!!!!!!!!!!!!!!!!!!!!!
                    in.read(buffer);// сделать вейт
                 char r=buffer[199];
//                    in.wait(1000);
                    if(new String(buffer).contains("=")) {
                        Helper helper=new Helper();
                        Servise servise=new Servise();
                    String namber = new String(buffer);
                        String[] string = namber.split("=");
                        System.out.println("Get the mame of the carOvner -  "+string[1] );
                        String name = string[1];
                        name = name.replaceAll("" + r, "");
                        System.out.println("Owner this car - " + servise.SearchByName(name));
                    }
                }
            } catch(IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            }
        }
    }







