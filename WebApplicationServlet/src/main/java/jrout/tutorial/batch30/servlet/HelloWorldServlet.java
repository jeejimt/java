package jrout.tutorial.batch30.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/helloworld")
public class HelloWorldServlet extends HttpServlet {

    public HelloWorldServlet(){
        System.out.println("This is my Constructor...");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("This is INIT Method");
    }

    @Override
    public void destroy() {
        System.out.println("This is Destroy Method....");
    }

   /* @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }
    */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Inside the doGet Method ");

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String occupation = req.getParameter("occupation");
        // dbService.getDetails(myname)
        writer.print("Hello <b>" + firstname + " "+ lastname +"</b> " +
                "Time is : <h1>"+  new java.util.Date()+"</h1> </br>");
        writer.print("My Occupation is "+ occupation);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Inside the doPost Method ");
       doGet(req,resp);
    }

}
