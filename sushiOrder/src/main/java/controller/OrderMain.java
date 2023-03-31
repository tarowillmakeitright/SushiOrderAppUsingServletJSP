package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Order;
import model.OrderLogic;

@WebServlet("/OrderMain")
public class OrderMain extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//フォワード先path
		String forwardPath="/WEB-INF/view/form.jsp";
		//リクエストパラメータの取得
		String action=request.getParameter("action");
		//sessionを使う準備
		HttpSession session=request.getSession();
		//sessionスコープからorderインスタンスの取得を試みる
		Order order=(Order)session.getAttribute("order");
		if(action == null) {
			//action属性が来ていなかったらOrderインスタンスを新しく生成する。
			order=new Order();
		}
		else if(action.equals("back")) {
			//今回ここでやる処理はない
		}
		else if(action.equals("submit")) {
			//OrderLogicインスタンスを作成
			OrderLogic logic = new OrderLogic();
			//executeして会計情報を付与する
			logic.execute(order);
			//フォワード先の変更
			forwardPath="/WEB-INF/view/result.jsp";
		}
		//sessionスコープにorderインスタンスを保存する
		session.setAttribute("order", order);

		//フォワード処理
		RequestDispatcher rd=
				request.getRequestDispatcher(forwardPath);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//getParameterValuesでcountsというname属性で送られてきたデータを配列として取得できる。
		String[] counts=request.getParameterValues("counts");//{"6","2"...."1"}
		HttpSession session = request.getSession();
		//セッションスコープからインスタンスを取り出す。
		Order order = (Order)session.getAttribute("order");
		//counts配列をセットする
		order.setCounts(counts);
		//セッションスコープに格納
		session.setAttribute("order", order);
		
		//フォワード処理
		RequestDispatcher rd=
				request.getRequestDispatcher("/WEB-INF/view/confirm.jsp");
		rd.forward(request, response);
	}

}