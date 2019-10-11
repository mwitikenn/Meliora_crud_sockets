package tech.meliora.training.web.rest;

/**
 *
 * @author kamochu
 */
public class StaticContentController {

    public String home() {
        String content = "<html>\n"
                + "    <head>\n"
                + "        <title>HTTP 101</title>\n"
                + "    </head>\n"
                + "    <body>\n"
                + "    <h1>Home</h1>\n"
                + "    <p>Where your heart is!</p>\n"
                + "    <a href=\"about\">About us</a>\n"
                + "    </body>\n"
                + "</html>";

        return content;
    }

    public String about() {
        String content = "<html>\n"
                + "    <head>\n"
                + "        <title>HTTP 101</title>\n"
                + "    </head>\n"
                + "    <body>\n"
                + "    <h1>About Us</h1>\n"
                + "    <p>It's all about us...</p>\n"
                + "    <a href=\"home\">Home</a>\n"
                + "    </body>\n"
                + "</html>";

        return content;
    }

    public String notFound() {
        String content = "<html>\n"
                + "    <head>\n"
                + "        <title>HTTP 404</title>\n"
                + "    </head>\n"
                + "    <body>\n"
                + "    <h1>HTTP 404 Page Not Found</h1>\n"
                + "    <p>It's all about us...</p>\n"
                + "    <a href=\"home\">Home</a>\n"
                + "    </body>\n"
                + "</html>";

        return content;
    }

}
