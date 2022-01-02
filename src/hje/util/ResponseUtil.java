package hje.util;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class ResponseUtil {
	/**
	 * List를 Json으로 변환하여 응답한다.
	 * 
	 * @param list
	 * @return
	 * @throws IOException 
	 */
	public static <T> void responseToJson(HttpServletResponse response, List<T> list) throws IOException {
		Gson gson = new Gson();
		String result = gson.toJson(list);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(result);
	}
	
	/**
	 * 코드 및 메세지를 Json으로 변환하여 응답한다.
	 * 
	 * @param list
	 * @return
	 * @throws IOException 
	 */
	public static void responseToJson(HttpServletResponse response, Response data) throws IOException {
		Gson gson = new Gson();
		String result = gson.toJson(data);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(result);
	}
}
