package tech.meliora.training;

import java.io.IOException;
import tech.meliora.training.server.OurSocketServer;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello World!");

        OurSocketServer server = new OurSocketServer();

        server.start(1505);
    }
}
