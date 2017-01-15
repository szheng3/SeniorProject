package com.springTeam55UCI.mvc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * Created by Leo on 1/14/2017.
 */
public class JarRunner extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
//        System.out.println("run successful");
            String location = request.getSession().getServletContext().getRealPath("") + File.separator + "obfuscation_out.jar";
//            System.out.println(location);
        Process ps = Runtime.getRuntime().exec(new String[]{"java","-jar",location});
        System.out.println("run successful");

        request.setAttribute("message", "File run successfully.");
        request.getRequestDispatcher("/WEB-INF/pages/result.jsp").forward(request, response);
    }

}