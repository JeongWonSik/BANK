package banking.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import banking.service.AccountService;

@WebServlet("/account/deposit.do")
public class DepositServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AccountService accountService = new AccountService();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String accNumber = request.getParameter("addNumber");
		String amount = request.getParameter("amount");
		double amount2 = Double.parseDouble(amount);
		
		accountService.findAccountByNum(accNumber);
		
		accountService.depositService(accNumber, amount2);
	}
 
}
