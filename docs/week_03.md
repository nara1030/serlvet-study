3주차
=====
```txt
1. SSR
  - 검색 조건에 따라[1] 그리드를 갱신[2]해주고자 하였다.
  - 하지만 서버에서 데이터만 넘겨주는 것이 아니라,
    완성된 JSP 페이지를 반환[3][4]하다보니 그리드만 갱신해주기가 쉽지 않았다.
  - 지금껏 스프링을 사용하다보니 그냥 별 생각 없었던 것 같은데,
    이 경우 어떤 식으로 해결해야할지 생각해봐야 한다.
2. Dynamic Web Project
  - 버전에 따라 webapp 혹은 WebContent 폴더가 생기는 것 같다.
  - 구버전이 WebContent이다.
3. 인코딩
  - 프로젝트 우클릭 > Properties > Resource > Text file encoding > UTF-8
  - JSP
    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <meta charset="UTF-8">
4. 서블릿에서 JSON 객체를 반환하기 위해 응답 객체의 출력 스트림에 JSON 객체를 쓴다.
5. 처음 화면을 로드하는 서블릿과 데이터를 갱신하는 서블릿을 꼭 따로 만들어야 하나?
```

- - -
1. `GET` 방식으로 요청을 보낼 때, 쿼리스트링이 깨져서 전달되는 이슈가 있었다.
	* [`GET` 방식 한글깨짐 현상](https://joohee46.tistory.com/17)
	* 기타
		* [`GET` 방식으로 쿼리스트링을 넘길 때 특수문자 사라짐 이슈](https://steady-snail.tistory.com/111)
		* [`POST` 요청과 `Content-Type`의 관계](https://blog.naver.com/PostView.nhn?blogId=writer0713&logNo=221853596497&redirect=Dlog&widgetTypeCall=true&directAccess=false)
2. AJAX
	* [ZEROCHO) AJAX](https://www.zerocho.com/category/HTML&DOM/post/594bc4e9991b0e0018fff5ed)
	* [PoiemaWeb) AJAX](https://poiemaweb.com/js-ajax)
	* [table 행 추가, 삭제](https://lee1535.tistory.com/30)
3. 서버 사이드 렌더링
	* [NAVER D2) 어서 와, SSR은 처음이지? - 도입편](https://d2.naver.com/helloworld/7804182)
	* [브라우저 렌더링](https://12bme.tistory.com/140)
4. 반환된 JSP로 덮어쓰니 이벤트 안 걸리는 이슈가 발생했다.