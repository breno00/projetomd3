package pacotecinema;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 42115152016.1
 */
public class cinemaservlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
             String nome = request.getParameter("txtNome");
           
            
            int idade = Integer.parseInt(request.getParameter("txtIdade"));
            int opiniao = Integer.parseInt(request.getParameter("selOpiniao"));
          
            
            Pessoa p = new Pessoa();
            p.setNome(nome);
            p.setIdade(idade);
            p.setOpiniao(opiniao);            
            
            try {
            Class.forName("com.mysql.jdbc.Driver"); //driver da conexao mysql\\
            Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/amofilmes",
            "root",
            ""); // a senha do root
            
            
           String sql = "insert into cliente(nome,idade,opiniao) values (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, p.getNome());
            ps.setInt(2, p.getIdade());
            ps.setInt(3, p.getOpiniao());
            
            ps.execute();
            
            ps.close();

        
            } catch(Exception e) {
                e.printStackTrace();
            }
            
            request.setAttribute("individuo", p.getNome());
            request.setAttribute("ida", p.getIdade());
            request.setAttribute("opi", p.getOpiniao());
            RequestDispatcher rd = request.getRequestDispatcher("saudacao.jsp");
            rd.forward(request, response);
        
        
        
/*        
            response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet cinemaservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet cinemaservlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
*/            
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
