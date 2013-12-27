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
	private HangmanModel hm;
	private HangmanGamelogic hg;
	private int hangmanState;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HangmanServlet() {
        super();
        this.initialize();
    }
    
    private void initialize(){
    	hm = new HangmanModel();
    	hg = new HangmanGamelogic();
    	hangmanState = 0;
    	try {
			hm.readWordList();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	hm.chooseRandomWord();
    	hm.setUniqueChars(hg.checkUniqueChars(hm.getRandomWord()));
    	
    	
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
		String isReset = (request.getParameter("get_reset"));
//		if(isReset != null && isReset == "Reset")
//			this.initialize();
		if (request.getParameter("reset") != null) {
            this.initialize();
		}
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
        	String result;
        	if(!hm.getWrongLetters().contains(letter+"")){
    			result = hg.gamelogic(hm.getRandomWord(), hm.getHiddenWord(), letter, hm.getHangmanState());
        	} else {
        		result = "break";
        	}
        	switch (result){
        	case "false":
        		hm.addLetterToWrongLetters(letter);
    			hm.increaseHangmanState();
    			break;
        	case "lost":
        		hm.setHangmanState(7);
        		break;
        	case "break":
        		break;
        	default:
        		hm.setHiddenWord(result);
    			hm.incrementCorrectGuessCount();
    			if(hm.getCorrectGuessCount() == hm.getUniqueChars())
    				hm.setHangmanState(8);
        	}
		}
		

//        request.setAttribute("hangmanState", hm.getHangmanState());
//        request.getRequestDispatcher("HangmanView.jsp").forward(request, response);
		communicate(request, response);
	}
	

}
