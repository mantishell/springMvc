<%--
  Created by IntelliJ IDEA.
  User: liang
  Date: 2020/5/4
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>参数传递</h3>

<a href="param/testParam?username=xiaowang&password=123456">get请求传递参数</a>

<div>
表单提交，把数据封装到Account类中：
        <form action="param/saveAccount" method="post">
            姓名：<input type="text" name="username">
            密码：<input type="text" name="password">
            金额：<input type="text" name="money">
            用户姓名：<input type="text" name="user.uname">
            用户年龄：<input type="text" name="user.age">
            <input type="submit" value="提交">
        </form>
</div>
<div>
    表单提交，把数据封装到Account类中,类中存在list和map的集合：
    <form action="param/saveAccount2" method="post">
        姓名：<input type="text" name="username">
        密码：<input type="text" name="password">
        金额：<input type="text" name="money">

        用户姓名：<input type="text" name="list[0].uname">
        用户年龄：<input type="text" name="list[0].age">

        用户姓名：<input type="text" name="map['one'].uname">
        用户年龄：<input type="text" name="map['one'].age">
        <input type="submit" value="提交">
    </form>
</div>
<div>
    自定义类型转换器：
    <form action="param/saveUser" method="post">
        姓名：<input type="text" name="uname">
        出生日期：<input type="text" name="birthday">
        <input type="submit" value="提交">
    </form>
</div>

<a href="param/testRequestParam?username=xiaowang">RequestParam</a>

<div>
    RequestBody：
    <form action="param/testRequestBody" method="post">
        姓名：<input type="text" name="uname">
        出生日期：<input type="text" name="birthday">
        <input type="submit" value="提交">
    </form>
</div>

<a href="param/testPathVariable">PathVariable</a>

<div>
        ModelAttribute：
        <form action="param/testModelAttribute" method="post">
            姓名：<input type="text" name="uname">
            年龄：<input type="text" name="age">
            <input type="submit" value="提交">
        </form>
</div>

        <a href="param/setSessionAttributes">SessionAttributes</a>
        <a href="param/getSessionAttributes">get</a>
        <a href="param/delSessionAttributes">del</a>

</body>
</html>
