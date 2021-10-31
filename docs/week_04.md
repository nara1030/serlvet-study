4주차
=====
```txt
1. 리팩토링
  - 공통을 따로 빼주었다(JsonUtil.java => ResponseUtil.java).
  - 테이블 갱신하는 다른 방법으로, 테이블 템플릿을 숨김으로 만들어 놓는 방법이 있다.
2. 유틸성 기능이므로 static 메소드로 선언하기 위해, 제네릭 메소드를 이용한다[1].
3. 상태 유지[2]를 위해 회원가입/로그인 기능을 추가한다.
  - 플로우
    1. 세션 확인[3]
      1-A. 세션 O -> 직원관리(기 로그인)
      1-B. 세션 X -> 로그인 페이지
    2. 로그인 페이지
      2-A. 회원 -> 로그인 페이지(쿠키 확인[4] 후 ID 표시)
      2-B. 비회원 -> 회원가입 페이지[5]
```

- - -
1. 자바 제네릭 관련 참고사항이다.
	* [The Basics of Java Generics](https://www.baeldung.com/java-generics)
	* [Java Generics - `<?>` vs `<? extends Object>`](https://www.baeldung.com/java-generics-vs-extends-object)
	* [자바 제네릭 이해하기](https://yaboong.github.io/java/2019/01/19/java-generics-1/)
	* [Java의 Generics](https://medium.com/@joongwon/java-java%EC%9D%98-generics-604b562530b3)
2. 상태 유지에 대한 참고사항이다.
	* [Scope](https://lazymankook.tistory.com/58)
3. 세션 처리에 대한 참고사항이다.
	* [스프링 세션, 쿠키 구현](https://engkimbs.tistory.com/696)
	* [스프링에서 세션 이용하기](https://devkingdom.tistory.com/9)
	* [SessionFilter - 세션 유무 확인하는 필터](https://sarc.io/index.php/java/296-sessionfilter)
4. 쿠키에 대한 참고사항이다.
	* [톰캣 서버와 브라우저간 세션 유지 및 쿠키 활용](https://m.blog.naver.com/misschip/221988026781)
	* [쿠키란? Tomcat과 JSESSIONID](https://dmobi.tistory.com/136)
5. .
6. 필터 적용 사례 참고사항이다.
	* [Servlet Filter 사용하기](https://atoz-develop.tistory.com/entry/Servlet-Filter-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0)