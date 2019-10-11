package tech.meliora.training.domain;

/**
 *
 * @author kamochu
 */
public class HTTPRequest {

    private String method;
    private String resource;
    private String body;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "HTTPRequest{" + "method=" + method + ", resource=" + resource + ", body=" + body + '}';
    }

}
