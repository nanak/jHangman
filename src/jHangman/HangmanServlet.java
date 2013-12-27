package jHangman;

import java.io.FileNotFoundException;
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
	private HangmanGamelogic hg = new HangmanGamelogic();
	private int hangmanState;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HangmanServlet() {
        super();
//        HangmanGamelogic hgl = new HangmanGamelogic();
        HangmanModel hm = new HangmanModel();
//        hangmanState = hm.getHangmanState();
        this.initialize();
    }
    
    private void initialize(){
    	try {
			hm.readWordList();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	hm.chooseRandomWord();
    }
    
    protected void communicate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setAttribute("hangmanState", hm.getHangmanState());
    	request.setAttribute("hiddenWord", hm.getHiddenWord());
    	request.setAttribute("wrongLetters", hm.getWrongLetters());
        request.getRequestDispatcher("HangmanView.jsp").forward(request, response);
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setAttribute("hangmanState", hm.getHangmanState());
//		request.getRequestDispatcher("HangmanView.jsp").forward(request, response);
		communicate(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s = (request.getParameter("post_text")).toLowerCase();
		if(s.length()==1){
			char letter = s.charAt(0);
        	hm.setLetter(letter);
    		String result = hg.gamelogic(hm.getRandomWord(), hm.getHiddenWord(), letter, hm.getHangmanState());
    		if(result == "false"){
    			hm.addLetterToWrongLetters(letter);
    			hm.increaseHangmanState();
    		} else {
    			hm.setHiddenWord(result);
    		}
		}
		String isReset = (request.getParameter("post_reset"));
		if(isReset != null && isReset == "Reset")
			this.initialize();

//        request.setAttribute("hangmanState", hm.getHangmanState());
//        request.getRequestDispatcher("HangmanView.jsp").forward(request, response);
		communicate(request, response);
	}
	

}
