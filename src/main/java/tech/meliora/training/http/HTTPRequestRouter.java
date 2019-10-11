package tech.meliora.training.http;

import java.io.IOException;
import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;
import tech.meliora.training.domain.HTTPRequest;
import tech.meliora.training.domain.HTTPResponse;
import tech.meliora.training.utils.FileUtils;
import tech.meliora.training.utils.HTTPPUtils;
import tech.meliora.training.web.rest.StaticContentController;

/**
 *
 * Receive the HTTP Request from the socket server Check header - first line
 * (extract the resource) Use resource to route to controllers... > about ->
 * StaticController.about() > home -> StaticController.home()
 *
 * @author kamochu
 */
public class HTTPRequestRouter {

    public static String process(String httpRequest, InetAddress clientIP, int clientPort) {

        HTTPResponse response = new HTTPResponse();

        try {

            //parse the http request 
            HTTPRequest req = HTTPPUtils.parse(httpRequest);

            switch (req.getResource()) {

                case "/api/add":

                    StaticContentController controller = new StaticContentController();

                    String body = controller.home();

                    response.setStatus(200);
                    response.setStatusCode("OK");
                    response.setContentType("text/html; charset=UTF-8");
                    response.setBody(body);

                    break;

                case "/api/multiply":
                    StaticContentController controller2 = new StaticContentController();

                    String body2 = controller2.home();

                    response.setStatus(200);
                    response.setStatusCode("OK");
                    response.setContentType("text/html; charset=UTF-8");
                    response.setBody(body2);
                    break;

                default:

                    String fileContent;
                    //check the file from the root directory - if not found, we return http 
                    try {
                        //check if file or resource exists
                        if (FileUtils.fileExists(req.getResource())) {

                            // read the file 
                            fileContent = FileUtils.readFile(req.getResource());

                            response.setStatus(200);
                            response.setStatusCode("OK");
                            response.setContentType("text/" + FileUtils.getExtension(req.getResource()) + "; charset=UTF-8");
                            response.setBody(fileContent);

                        } else {
                            //read the /error/404.html -
                            fileContent = FileUtils.readFile("/error/404.html");
                            response.setStatus(404);
                            response.setStatusCode("Not Found");
                            response.setContentType("text/html; charset=UTF-8");
                            response.setBody(fileContent);

                        }

                    } catch (IOException ex) {
                        Logger.getLogger(HTTPRequestRouter.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    break;
            }

        } catch (Exception ex) {

            String fileContent;

            fileContent = "<html>\n"
                    + "    <head>\n"
                    + "        <title>HTTP 500 Internal Server Error</title>\n"
                    + "    </head>\n"
                    + "    <body>\n"
                    + "    <h1>HTTP 500 Internal Server Error</h1>\n"
                    + "    <p>Error: " + ex.getMessage() + "</p>\n"
                    + "    <a href=\"home\">Home</a>\n"
                    + "    </body>\n"
                    + "</html>";

            response.setStatus(500);
            response.setStatusCode("Internal Server Error");
            response.setContentType("text/html; charset=UTF-8");
            response.setBody(fileContent);

        }

        return HTTPPUtils.prepareResponse(response);

    }

}
