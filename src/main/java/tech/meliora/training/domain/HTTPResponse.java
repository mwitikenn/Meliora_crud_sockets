package tech.meliora.training.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kamochu
 */
public class HTTPResponse {

    public int status;
    public String statusCode;

    public String contentType;
    public String body;

    public List<String> headers;

    public HTTPResponse() {
        headers = new ArrayList<>();
    }

    public void addHeader(String header) {
        headers.add(header);
    }

    public List<String> getHeaders() {
        return headers;
    }

    public void setHeaders(List<String> headers) {
        this.headers = headers;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "HTTPResponse{" + "status=" + status + ", statusCode=" + statusCode + ", contentType=" + contentType + ", body=" + body + ", headers=" + headers + '}';
    }

}
