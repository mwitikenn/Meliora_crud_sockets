package tech.meliora.training.utils;

import tech.meliora.training.domain.HTTPRequest;
import tech.meliora.training.domain.HTTPResponse;

/**
 *
 * @author kamochu
 */
public class HTTPPUtils {

    public static HTTPRequest parse(String httpRequest) {

        //get the first line 
        String httpFirstLine = httpRequest.split("\r\n")[0];
        int strartBraceIndex = httpRequest.indexOf("{");

        //get the method and resource  - POST /api/add HTTP/1.1
        String parts[] = httpFirstLine.split(" ");

        String method = parts[0];
        String resource = parts[1];

        //get the body 
        String body = null;

        if (!method.equals("GET") && strartBraceIndex != -1) {
            body = httpRequest.substring(strartBraceIndex);
        }

        HTTPRequest request = new HTTPRequest();
        request.setMethod(method);
        request.setResource(resource);
        request.setBody(body);

        return request;
    }

    public static String prepareResponse(HTTPResponse response) {

        String responseStr = "HTTP/1.1 " + response.getStatus() + " " + response.getStatusCode() + "\r\n"
                + "Server: MelioraWebServer/2.4.6 (CentOS) PHP/7.0.33\r\n"
                + "Content-Length: " + response.getBody().length() + "\r\n"
                + "Content-Type: text/html; charset=UTF-8\r\n"
                + "\r\n"
                + response.getBody();

        return responseStr;
    }

}
