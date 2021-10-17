package hje.util;

import java.util.List;

import com.google.gson.Gson;

public class JsonUtil {
	/**
	 * List를 Json으로 변환한다(제네릭 반영된 거 말고 타 리스트에서 사용하려면...).
	 * 
	 * @param list
	 * @return
	 */
	public String toJsonString(List list) {
		Gson gson = new Gson();
		String result = gson.toJson(list);
		
		return result;
	}
}