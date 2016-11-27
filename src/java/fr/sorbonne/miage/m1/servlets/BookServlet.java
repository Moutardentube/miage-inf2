package fr.sorbonne.miage.m1.servlets;

import fr.sorbonne.miage.m1.beans.Book;
import fr.sorbonne.miage.m1.dao.BookDAO;
import fr.sorbonne.miage.m1.dao.DAO;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ludovic
 */
public class BookServlet extends HttpServlet {
    
    private DAO<Book> bookDao;

    /**
     * Processes show requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void show(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Processing request in BookServlet (show)");
        request.getRequestDispatcher("/book.jsp").forward(request, response);
    }
    
    /**
     * Processes edit requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void edit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Processing request in BookServlet (edit)");
        request.getRequestDispatcher("/book_edit.jsp").forward(request, response);
    }

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
        Pattern p = Pattern.compile("\\/(\\d+)(\\/edit)?");
        Matcher m = p.matcher(request.getPathInfo());
        int id;

        if (m.matches()) {
            id =Integer.valueOf(m.group(1));
            bookDao = new BookDAO();
            Book book = bookDao.findById(id);
            response.setContentType("text/html;charset=UTF-8");
            request.setAttribute("id", id);
            request.setAttribute("book", book);
            request.setAttribute("context", request.getContextPath());

            if (null == m.group(2)) {
                show(request, response);
            } else {
                edit(request, response);
            }
        } else {
            
        }
        //processRequest(request, response);
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
        //processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "BookServlet";
    }

}
