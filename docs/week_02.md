2주차
=====
```txt
1. 개발환경
  - Eclipse: Dynamic Web Project[1]
  - Java: 1.8
2. 인덱스 페이지 로드 시 조회 화면으로 리다이렉트 한다.
  - 리다이렉트 vs. 포워드
  - 절대경로 vs. 상대경로
  + 로그인 여부에 따라 다른 페이지 리다이렉트
3. 컨트롤러(서블릿)으로 JSP 페이지를 연동한다[2].
4. 서버에서 받은 데이터를 JSP에 뿌려준다[3].
5. 화면단 소스를 정리한다[4].
```

- - -
1. 디렉토리 구조는 다음과 같다.  
```txt
project
  ├ src
  
```
2. [doGet and doPost in Servlets](https://stackoverflow.com/questions/2349633/doget-and-dopost-in-servlets)
3. JSTL을 사용하기 위해 다음 두 가지를 지켜야 한다.
	* 메이븐 프로젝트가 아닌, 즉 `pom.xml`이 없는 경우기에 JSTL을 사용하기 위해 직접 라이브러리를 추가해주어야 한다. 이때, `WebContent > WEB-INF > lib` 폴더에 jar 파일을 위치시켜야 한다.
	* 자바 클래스에 `getter`를 추가해야 한다. 이때 메소드뿐 아니라 클래스 접근제어자도 `public`이어야 한다.
4. 아래 사항을 신경쓴다.
	* HTML, CSS, JS를 분리한다.
		* [window.onload vs. document.onload](https://stackoverflow.com/questions/588040/window-onload-vs-document-onload)
		* [jQuery> ready vs. onload](https://hahahoho5915.tistory.com/28)
	* [네이밍 컨벤션](https://okky.kr/article/679014)을 준수한다.