package jHangman;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class HangmanServlet
 * @author Nanak
 */
public class HangmanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HangmanModel hm = new HangmanModel();
	private int hangmanState;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HangmanServlet() {
        super();
        HangmanGamelogic hgl = new HangmanGamelogic();
        HangmanModel hm = new HangmanModel();
//        hangmanState = hm.getHangmanState();
    }
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("hangmanState", hm.getHangmanState());
		request.getRequestDispatcher("HangmanView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s = (request.getParameter("post_text"));
		char letter = s.charAt(0);
        hm.setLetter(letter);
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
//        response.sendRedirect("HangmanView.jsp");
        System.out.println(request);
        System.out.println(response);
        request.getRequestDispatcher("HangmanView.jsp").forward(request, response);
	}
	

}
