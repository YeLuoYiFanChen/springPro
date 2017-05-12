<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <form action="/save.do" method="post">
       <table>
          <tr>
              <td>用户名</td>
              <td><input type="text" name="username" value="${user.username}"></td>
          </tr>
           <tr>
               <td>密码</td>
               <td><input type="password" name="password" value="${user.password}" /> </td>
           </tr>
           <tr>
               <td>性别</td>
               <td><input type="radio" value="男" name="sex">男
               <input type="radio" value="女" name="sex">女</td>
           </tr>
           <tr>
               <td>年龄</td>
               <td><input type="number" name="age" value="${user.age}"> </td>
           </tr>
           <tr>
               <td colspan="2"><input type="submit" value="提交"></td>
           </tr>
       </table>
   </form>

</body>
</html>
