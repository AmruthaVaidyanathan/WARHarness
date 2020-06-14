package edu.cityuniversity.warharness.service.servlet;

import edu.cityuniversity.warharness.service.context.DefaultServiceContext;
import edu.cityuniversity.warharness.service.handler.HandlerChain;
import edu.cityuniversity.warharness.service.entity.Request;
import edu.cityuniversity.warharness.service.handler.RequestHandler;
import edu.cityuniversity.warharness.service.entity.Response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 */
@WebServlet(
        name = "Servlet to process requests",
        description = "Servlet to process requests",
        urlPatterns = "/api"
)
public class APIServlet extends HttpServlet {

    private RequestHandler<Request, Response> handler;

    public void init() {
        // Do required initialization
        this.handler = HandlerChain.create(new DefaultServiceContext());
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final Request simpleRequest = Request.builder()
                .withServletRequest(request)
                .build();

        final Response finalResponse = handler.handle(simpleRequest);

        // Set response content type
        response.setContentType(finalResponse.contentType());

        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        out.println(finalResponse.payload());
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: Have separate logic to get items from request body for a POST request
        doGet(request, response);
    }

    public void destroy() {
        // do nothing.
    }
}
