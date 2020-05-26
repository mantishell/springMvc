<%--
  Created by IntelliJ IDEA.
  User: liang
  Date: 2020/5/24
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>传统文件上传</h3>
<a href="demo">demo</a>
<form action="fileUpload1" method="post" enctype="multipart/form-data">
    选择文件：<input type="file" name="upload" /><br/>
    <input type="submit" value="上传" />
</form>

<h3>Springmvc文件上传</h3>

<form action="fileUpload2" method="post" enctype="multipart/form-data">
    选择文件：<input type="file" name="upload" /><br/>
    <input type="submit" value="上传" />
</form>

<h3>跨服务器文件上传</h3>

<form action="fileUpload3" method="post" enctype="multipart/form-data">
    选择文件：<input type="file" name="upload" /><br/>
    <input type="submit" value="上传" />
</form>
</body>
</html>
