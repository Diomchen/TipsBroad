<%--
  Created by IntelliJ IDEA.
  User: Shuhan Chen
  Date: 2018/10/9
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <link rel="stylesheet" href="../../css/register.css">
    <script type="text/javascript">
        function changeImg() {
            var img = document.getElementById("img");
            img.src = "/verificationCode.do?date = "+ new Date();
        }

        function checkVerificationCode(){
            var verificationCode = document.getElementById("verificationCode").value;
            var flag = (getCookie('v_c_v').toLowerCase() == verificationCode.toLowerCase());

            if(!flag){
                alert('验证码错误');
            }
            return flag;
        }

        function getCookie(cookie_name){
            var allCookies = document.cookie;
            var cookie_pos = allCookies.indexOf(cookie_name);
            if(cookie_pos != -1){
                cookie_pos += cookie_name.length + 1;
                var cookie_end = allCookies.indexOf(";",cookie_pos);
                if(cookie_end == -1){
                    cookie_end = allCookies.length;
                }
                return unescape(allCookies.substring(cookie_pos,cookie_end));
            }
            return null;
        }
    </script>
</head>
    <div class="register">
        <div class="header">
            <h1>
                <a href="/login.do">登录</a>
                <a href="/regPrompt.do">注册</a>
            </h1>
        </div>
        <form action="/re.do" method="post">
            <div>
                <input type="text" id="username" name="username" placeholder="请输入用户名">
            </div>

            <div>
                <input type="password" id="password" name="password" placeholder="请输入密码">
            </div>

            <div>
                <input type="text" id="realname" name="realname" placeholder="请输入真实姓名">
            </div>

            <%--这个地方得用到复选框--%>
            <%--<div>--%>
                <%--<input type="text" id="birth" name="username" placeholder="请输入生日">--%>
            <%--</div>--%>

            <div>
                <input type="text" id="phone" name="phone" placeholder="请输入电话号码">
            </div>

            <div>
                <input type="text" id="address" name="address" placeholder="请输入真实地址">
            </div>

            <div class="idcode">
                <input type="text" id="verificationCode"  placeholder="请输入验证码">
                <a href="#" onclick = "javascript:changeImg()"></a>
                <span><img id="img" src="/verificationCode.do"></span>
                <div class="clear"></div>
            </div>

            <div>
                <input type="submit" id="reg-submit" name="reg-submit" value="登录">
            </div>
        </form>
    </div>
<body>



</body>
</html>
