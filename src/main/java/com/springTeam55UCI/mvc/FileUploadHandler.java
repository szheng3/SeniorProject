package com.springTeam55UCI.mvc;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Shuai Zheng on 11/23/16.
 */
public class FileUploadHandler extends HttpServlet {
    private String UPLOAD_DIRECTORY = ".";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().setMaxInactiveInterval(1440);
        //process only if its multipart content
        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                List<FileItem> multiparts = new ServletFileUpload(
                        new DiskFileItemFactory()).parseRequest(request);

                for (FileItem item : multiparts) {
                    if (!item.isFormField()) {
                        item.write(new File(request.getSession().getServletContext().getRealPath("") + File.separator + new File(item.getName()).getName()));
                        ProOut Profile = new ProOut();
                        Profile.ProFileOutApplication(request.getSession().getServletContext().getRealPath(""), new File(item.getName()).getName());
                        String[] args = new String[2];
                        args[0] = "@" + request.getSession().getServletContext().getRealPath("") + File.separator + "proguard.pro";
                        Main Obfusacate = new Main();
                        Obfusacate.obfuscation(args);


                    }
                }

                //File uploaded successfully
                request.setAttribute("message", "File Uploaded Successfully");
            } catch (Exception ex) {
                request.setAttribute("message", "File Upload Failed due to " + ex);
            }

        } else {
            request.setAttribute("message",
                    "Sorry this Servlet only handles file upload request");
        }


        request.getRequestDispatcher("/WEB-INF/pages/result.jsp").forward(request, response);

    }

}