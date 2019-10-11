package tech.meliora.training;

import junit.framework.TestCase;
import tech.meliora.training.domain.HTTPRequest;
import tech.meliora.training.utils.HTTPPUtils;

/**
 *
 * @author kamochu
 */
public class HTTPUtilsTest extends TestCase {

    public void testHTTPParsingGET() {

        String request = "GET /home HTTP/1.1\r\n"
                + "Content-Length: 13\r\n"
                + "Content-Type: application/json\r\n";

        HTTPRequest req = HTTPPUtils.parse(request);

        System.out.println("req parsed: " + req);

        assertTrue(req.getResource().equals("/home"));

    }

    public void testHTTPParsingPOST() {

        String request = "POST /api/multiply HTTP/1.1\r\n"
                + "Content-Length: 13\r\n"
                + "Content-Type: application/json\r\n"
                + "\r\n"
                + "{\"a\":5,\"b\":6}";

        HTTPRequest req = HTTPPUtils.parse(request);

        System.out.println("req parsed: " + req);

        assertTrue(req.getResource().equals("/api/multiply") && req.getBody().equals("{\"a\":5,\"b\":6}"));

    }

}
