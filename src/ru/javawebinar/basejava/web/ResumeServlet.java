package ru.javawebinar.basejava.web;

import ru.javawebinar.basejava.model.Resume;
import ru.javawebinar.basejava.storage.SqlStorage;
import ru.javawebinar.basejava.storage.Storage;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResumeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
//        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String name = request.getParameter("name");
        PrintWriter writer = response.getWriter();
        writer.write(name == null ? "Hello Resumes!" : "Hello " + name + '!');

        Storage storage = new SqlStorage("jdbc:postgresql://localhost:5432/resumes", "postgres", "postgres");

        writer.write("<table>");
        writer.write("<tr>");
        writer.write("<th>");
        writer.write("Resume ID");
        writer.write("</th>");
        writer.write("<th>");
        writer.write("Resume Name");
        writer.write("</th>");
        writer.write("</tr>");
        for (Resume resume : storage.getAllSorted()) {
            writer.write("<tr>");
            writer.write("<td>");
            writer.write(resume.getUuid());
            writer.write("</td>");
            writer.write("<td>");
            writer.write(resume.getFullName());
            writer.write("</td>");
            writer.write("</tr>");
        }
        writer.write("</table>");
    }
}