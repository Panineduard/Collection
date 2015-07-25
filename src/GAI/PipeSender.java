package GAI;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.nio.channels.Pipe;
import java.util.Random;

/**
 * Created by Эдуард on 07.07.15.
 */
public class PipeSender implements Runnable {

        private PipedWriter out = new PipedWriter();
        public PipedWriter getPipedWriter() { return out; }
        public void run() {
            String c = "Name =Igor";
                    try {
                        while (true){
                        out.write(c);
                            out.flush();
                    Thread.sleep(1000);

                    ;}}
                           catch(Exception e) {
                        throw new RuntimeException(e);
                }
            }
        }











//            PipedWriter out = new PipedWriter();
//    public PipedWriter getPipedWriter() { return out; }
//
//
//
//    @Override
//    public void run() {
////
//        System.out.println("Start first thread");
//        String namber = "Namber=23";
//try {
//
//            out.write(namber);
//
////            out.connect(in);
//            }
//catch (Exception e){throw new RuntimeException(e);}
//
//    }
//}
