
import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
/**
 * Servlet implementation class GetPointServlet
 */
@WebServlet("/getPoint")
public class GetPointServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPointServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//--- 入出力用文字エンコード
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		//ポイント格納用変数
		int point;
		
		try {
			//--- パラメータ（TENPO_IDとUSER_ID）の取得
			String tenpoId = request.getParameter("TENPO_ID");
			String userId = request.getParameter("USER_ID");
			
			//--- DAOオブジェクトのインスタンス化
			DAO dao = new DAO();
			//--- DAOのsearchAndInsertメソッドを使ってデータを取得
			point = dao.searchAndInsert(tenpoId, userId);
			
			//--- 表示用のJSPへ転送
			//--- 転送するデータにpointという名前を付けて設定
			request.setAttribute("point", point);
			//--- getPoint.jsp へ転送
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/getPoint.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			//--- 改行コードや空白文字を有効にするタグを発行
			response.getWriter().println("<pre>");
			response.getWriter().println(e.getMessage());
			e.printStackTrace();
		}	
	}

}
