/**
 * 
 */
package phc.first;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author pcomitz
 * 8/3/2014 Summerville S.C.
 *
 */

public class MyServlet extends HttpServlet {
	
	private List<String> videos = new ArrayList<String>();
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("text/plain"); 
		
		PrintWriter sendToClient = resp.getWriter(); 
		
		for(int i = 0; i < videos.size(); i++) 
		{
			sendToClient.write(videos.get(i) + "\n"); 
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		String name = req.getParameter("name"); 
		resp.setContentType("text/plain"); 
		
		if(name==null)
		{
			resp.sendError(400); 
			resp.getWriter().write("name is is missing"); 
		}
		else
		{
			videos.add(name); 
			resp.getWriter().write("added:"+name); 
		}
		
	}
		

} ///~
