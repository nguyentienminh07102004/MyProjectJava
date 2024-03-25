package CONTROLLER;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import MODEL.Number;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "Game", urlPatterns = {"/game"})
public class gameDoanSo extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String UserNumber = req.getParameter("number");
        String maxNumberLength = req.getParameter("maxNumberLength");
        String AINumber = "0";
        HttpSession session = req.getSession();
        try {
            if (session.getAttribute("AI") == null) {
                int maxLength = Integer.parseInt(maxNumberLength);
                AINumber = Number.genderRandomNumber(maxLength);
                session.setAttribute("AI", AINumber);
                session.setAttribute("hadValue", "none");
            } else {
                AINumber = (String) session.getAttribute("AI");
            }
            String result;
            if (Number.compareTwoBigNumber(AINumber, UserNumber) < 0) {
                result = "Lower";
            } else if (Number.compareTwoBigNumber(AINumber, UserNumber) > 0) {
                result = "Higher";
            } else {
                result = "Accpect";
            }
            req.setAttribute("result", result);
            req.getRequestDispatcher("game.jsp").forward(req, resp);
        } catch (ServletException | IOException | NumberFormatException e) {
            System.out.println("Error: " + e);
        }
    }
}
