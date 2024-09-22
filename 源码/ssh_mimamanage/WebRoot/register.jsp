<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册界面</title>
<link href="login/css/alogin.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function flushCode() {
		document.getElementById("codeimg").src = "imageServlet?random="
				+ Math.random();
	}
</script>
</head>
<body>
	<form id="form1" runat="server" action="register.action" method="post">
		<input type="hidden" name="util.s_11" value="user" />
		<div class="Main">
			<ul>
				<li class="top"></li>
				<li class="top2"></li>
				<li class="topA"></li>
				<li class="topB"><span><div style="float:left;">
							<img src="login/images/login/logo.gif" alt="" style="" />
						</div>
						<div style="float:left;margin-left:20px;margin-top:20px;">
							<div align=center>
								<H1>
									<spring:message code="system_name" />
								</H1>
							</div>
						</div> </span>
				</li>
				<li class="topC"></li>
				<li class="topD">
					<ul class="login" style="margin-top:-30px;">
						<li><span class="left login-text">用户名：</span> <span> <input
								id="Text1" type="text" class="txt" name="util.s_0" /> </span>
						</li>
						<li><span class="left login-text">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</span>
							<span style="left"> <input id="Text2" type="password"
								class="txt" name="util.s_1" /> </span>
						</li>
						<li><span class="left login-text">效验码：</span> <span
							style="left"> <input id="Text2" type="text" class="txt"
								name="code" id="code" style="width:80px;" /> <img id="codeimg"
								src="imageServlet" onClick="flushCode()"
								style="margin-left:20px;height:25px;width:80px;" /> </span>
						</li>


					</ul></li>
				<li class="topE"></li>
				<li class="middle_A"></li>
				<li class="middle_B"></li>
				<li class="middle_C">
					<div style="margin-right:-10px;margin-top:30px;">
						<span class="btn"><input value="注册" type="submit"
							style="width:100px;height:40px;bgcolor:#000000;" /> </span><font
							color=red><s:property value="errMsg" /> </font>
					</div></li>

				<li class="middle_D"></li>
				<li class="bottom_A"><br /> <a id="kanbuq"
					style="margin-left:660px;margin-top:-10px;font-size:16px;" href="login.jsp">已有帐号？登录</a>
				</li>
				<li class="bottom_B">Copyright 2019 BYSJ register</li>
			</ul>
		</div>
	</form>
</body>
</html>