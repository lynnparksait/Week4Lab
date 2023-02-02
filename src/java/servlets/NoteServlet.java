package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Person;

/**
 *
 * @author awarsyle
 */
public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        // to read files
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        // to write to a file
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // get the two parameters from the POST request
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");

        // validation: if the parameters don' t exist or are empty, show the first page again
        if (firstname == null || firstname.equals("") || lastname == null || lastname.equals("")) {
            // set the attributes for the JSP
            request.setAttribute("firstname", firstname);
            request.setAttribute("lastname", lastname);
            // set an attribute for a message
            request.setAttribute("invalid",true);
            // forward the request and response objects to the JSP
            // display the form again
            getServletContext().getRequestDispatcher("/WEB-INF/helloWorldForm.jsp")
                    .forward(request, response);
            return; // very important!
        }

        Person person = new Person(firstname, lastname);
        request.setAttribute("person", person);

        // display the second page
        getServletContext().getRequestDispatcher("/WEB-INF/sayHello.jsp")
                .forward(request, response);
    }
}
