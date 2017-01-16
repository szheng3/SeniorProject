package com.springTeam55UCI.mvc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


/**
 * Created by Leo on 1/14/2017.
 */
public class JarRunner extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
//        System.out.println("run successful");
            String location = request.getSession().getServletContext().getRealPath("") + File.separator + "obfuscation_out.jar";
//            System.out.println(location);
//      Process ps = Runtime.getRuntime().exec(new String[]{"java","-jar",location});

        String[] args = new String[1];
        toposort(args);

        System.out.println("run successful");

        request.setAttribute("message", "File run successfully.");
        request.getRequestDispatcher("/WEB-INF/pages/result.jsp").forward(request, response);
    }



    public static void toposort(String[] args) throws IOException {

        System.out.println("\nReading inputs from graphdata.txt");
        DirectedGraph nextgraph = new DirectedGraph();
        Object[] vertexPair = new Object[2];
        FileReader fin = new FileReader("graphdata.txt");
        Scanner scnr = new Scanner(fin);
        int counter=0;
        while(scnr.hasNext()) {
            vertexPair[counter%2] = scnr.next();
            //System.out.println("counter%2is "+counter%2+"adding "+vertexPair[counter%2]);
            if(counter%2==1) {
                nextgraph.addVertex(vertexPair[0], vertexPair[1]);
                System.out.println("adding vertex("+vertexPair[0]+","+vertexPair[1]+")");
                System.out.println("Current 1st row of glist:");
                nextgraph.PrintGraph();
            }
            counter++;
        }
        System.out.println("Sorting...");
        nextgraph.Sort();
        System.out.println("Sorted. Result graph:");
        nextgraph.PrintGraph();

    }

}