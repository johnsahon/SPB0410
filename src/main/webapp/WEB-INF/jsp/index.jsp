<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>myindex</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<style>
  body {background-color: powderblue;}
  h1   {color: blue;}
  p    {color: red;}

  #bookmark {
  color: red;
  font-family: courier;
  font-size: 160%;
}

</style>

</head>
<body>
  hello,welcome to you 123!test=[${test }] test2=[${test2 }]
  <br>
  ![](${pageContext.request.contextPath}/image/picture01.png)
  <c:if test="${1 == 1 }"><br>this is good, bye bye!</c:if>

  <h1>This is a heading</h1>
  <p>This is a paragraph.</p>

</body>
<script>
    var para = "1";

</script>
</html>