4주차
=====
```txt
1. 리팩토링
  - 공통을 따로 빼주었다(JsonUtil.java => ResponseUtil.java).
  - 테이블 갱신하는 다른 방법으로, 테이블 템플릿을 숨김으로 만들어 놓는 방법이 있다.
2. 유틸성 기능이므로 static 메소드로 선언하기 위해, 제네릭 메소드를 이용한다[1].
3. 상태 유지를 위해 회원가입/로그인 기능을 추가한다.
  - 
```

- - -
1. 자바 제네릭 관련 참고사항이다.
	* [The Basics of Java Generics](https://www.baeldung.com/java-generics)
	* [Java Generics - `<?>` vs `<? extends Object>`](https://www.baeldung.com/java-generics-vs-extends-object)
	* [자바 제네릭 이해하기](https://yaboong.github.io/java/2019/01/19/java-generics-1/)
	* [Java의 Generics](https://medium.com/@joongwon/java-java%EC%9D%98-generics-604b562530b3)
2. .