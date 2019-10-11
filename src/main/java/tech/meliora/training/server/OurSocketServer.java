package tech.meliora.training.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import tech.meliora.training.http.HTTPRequestRouter;

/**
 *
 * @author kamochu
 */
public class OurSocketServer {

    private ServerSocket server;

    //start the server and accept connections 
    public void start(int port) throws IOException, InterruptedException {

        //start the server 
        server = new ServerSocket(port);

        System.out.println("Server started on port : " + port);

        while (true) {

            //accept a connection - this is a blocking call... it will proceed after a TCP connection is established
            Socket clientSocket = server.accept();

            InetAddress clientIP = clientSocket.getInetAddress();
            int clientPort = clientSocket.getPort();

            System.out.println(clientIP + "|" + clientPort + "|received  connection");

            //prepare to read data
            clientSocket.getInputStream();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String content = "";

            //read headers
            String headerLine;
            while ((headerLine = in.readLine()).length() != 0) {
                System.out.println(clientIP + "|" + clientPort + "|header|" + headerLine);

                //append header to content - line by line
                content += headerLine + "\r\n";
            }

            //read the body
            StringBuilder payload = new StringBuilder();
            while (in.ready()) {
                payload.append((char) in.read());
            }
            System.out.println(clientIP + "|" + clientPort + "|body|" + payload);

            //add payload to content 
            content += payload.toString();

            System.out.println(clientIP + "|" + clientPort + "|request|" + content.replace("\r\n", "\\r\\n"));
            String response = HTTPRequestRouter.process(content, clientIP, clientPort);
            out.println(response);

            System.out.println(clientIP + "|" + clientPort + "|response|" + response.replace("\r\n", "\\r\\n").replace("\n", "\\n"));

            out.close();
            in.close();
            clientSocket.close();

            System.out.println(clientIP + "|" + clientPort + "|closing connection");

        }

    }

    public void stop() {

    }

}
