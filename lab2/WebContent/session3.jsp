<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head><title>Session示例3</title></head> 
<body>
<font>欢迎您，</font> <%= session.getAttribute("username") %>
</body>
</html>