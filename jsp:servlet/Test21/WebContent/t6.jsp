<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>


<%!
	
	int a = 10;
	public void me1(){
		System.out.println(a);
	}
	
	a = 30; 
	/* decleartion 영역은 클래스의 필드와 같은 역할을 하기 때문에 */
	/* decleartion영역에서 선언 된 변수의 대입은 필드에서 멤버변수에 대입을 하려는 것과 같다 : 안된다는 말 */
	/* decleartion 영역 = 클래스의 필드영역 이기 때문에 멤버변수나 메서드의 선언이 가능하다. */

%>

<%! 

	int a = 20;
	/* jsp파일은 나중에 class파일로 저장된다 */
	/* 선언 태그가 몇개씩 있다 해도, 클래스 필드는 하나뿐이다. */
	/* 따라서, 첫번째 선언태그에서 선언된 변수 a를 두번째 태그에서 다시 선언하려고 하면 */
	/* 중복된 이름이라는 오류가 발생하게 된다. */

%>
<!-- 지역변수로도 구현이 가능하고, 멤버변수로도 구현이 된다면, 지역변수를 이용한다 -->
<!-- - 보안을 위해서 / - 스레드에 안전한 변수가 되도록 -->
<!-- 따라서, 선언태그 내부에서 변수를 선언해도 구현이 되고, 스크립틀릿 태크 내부에서 변수를 선언해도 구현이 된다면, 
	스크립틀릿태그 내부에서 선언하도록 한다 -->
</body>
</html>