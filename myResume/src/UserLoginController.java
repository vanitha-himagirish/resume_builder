package model;


import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/LoginServlet")
public class UserLoginController extends HttpServlet {
  private UserLoginDAO userLogin = new UserLoginDAO();
  String address;
  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    
	String UserName = request.getParameter("txtUserName");
    String Password = request.getParameter("txtPassword");
    if (UserName == null && Password == null) {
      UserName = "";
    }
    boolean login = userLogin.UserLogin(UserName, Password);
    if (login == true) {
    	 address = "/WEB-INF/userprofile.jsp";
    }else {
    	address =  "/WEB-INF/userlogin.jsp";
    }
     RequestDispatcher dispatcher =
      request.getRequestDispatcher(address);
    dispatcher.forward(request, response);
  }
}