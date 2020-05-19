package edu.cityuniversity.warharness.service.routes;

import edu.cityuniversity.warharness.service.context.DefaultServiceContext;
import edu.cityuniversity.warharness.service.context.ServiceContext;
import edu.cityuniversity.warharness.service.handler.HttpRequestHandler;
import edu.cityuniversity.warharness.service.handler.Request;
import edu.cityuniversity.warharness.service.handler.RequestHandler;
import edu.cityuniversity.warharness.service.handler.Response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author rajarar
 */
@WebServlet(
        name = "Servlet to process requests",
        description = "Test servlet",
        urlPatterns = "/test"
)
public class APIServlet extends HttpServlet {

    private String message;
    private ServiceContext serviceContext;
    private RequestHandler<Request, Response> handler;

    public void init() {
        // Do required initialization
        this.message = "Hello World";
        this.serviceContext = new DefaultServiceContext();
        this.handler = new HttpRequestHandler();

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final Request simpleRequest = new Request(request);
        final Response finalResponse = handler.handle(simpleRequest);

        // Set response content type
        response.setContentType(finalResponse.contentType());

        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        out.println(finalResponse.payload());
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");

        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        out.println("<h1>" + this.message + "</h1>");
    }

    public void destroy() {
        // do nothing.
    }
}
