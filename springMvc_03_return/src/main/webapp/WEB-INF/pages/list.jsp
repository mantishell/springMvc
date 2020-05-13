<%--
  Created by IntelliJ IDEA.
  User: liang
  Date: 2020/5/12
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <title>Title</title>
</head>
<body>
    <c:forEach items="${ users }" var="user">
        ${ user.username }
    </c:forEach>
    <script>
        $(function(){
            $('.btn').click(function(){
                $.ajax({
                    url:'user/testJson',
                    contentType:'application/json;charset=UTF-8',
                    data:'{"address":"南京","addressNum":"010"}',
                    dataType:'json',
                    type:'post',
                    success: function(data){
                        console.log(data)
                        console.log(data.address)
                    }
                })
            })
        })
    </script>
</body>
</html>
