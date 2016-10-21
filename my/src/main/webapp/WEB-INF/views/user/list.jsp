<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="${jsPath!}jquery-1.7.2.min.js"></script>
<link href="${jsPath!}bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="${jsPath!}bootstrap/docs/examples/grid/grid.css" rel="stylesheet">
<script>
	jQuery(document).ready(function(){ 
		//查询
		$("#form_submit").live("click",function(){
			var userName = $("#userName").val();
			var phone = $("#phone").val();
			var email = $("#email").val();
			if(userName =="" && phone =="" && phone =="")
				return ;
			$("#theForm").submit();
		});
		//删除
		$("#user_del").live("click",function(){
			if(confirm("确定要删除该条记录嘛？")){
				var user_id = $(this).attr("user_id");
				window.open("${basePath}UserManager/user/del?userId="+user_id);
			}
		});
		//编辑
		$("#user_edt").live("click",function(){
			window.onload("${basePath}UserManager/user/edt");
		});
	})
</script>
<title>search</title>
</head>
<body>
	<div id="search">
		<h2>查询</h2>
		<form id="theForm" action="${basePath}UserManager/user/search_user" method="post">
			用户名：<input name="userName" id="userName" />
			电话：<input name="phone" id="phone" />
			邮箱：<input name="email" id="email"/>
			<input type="button" value="查询" id="form_submit" />
		</form>
	</div>
	<br>
	<table>
		<tr>
			<td></td>
			<td>用户名</td>
			<td>联系电话</td>
			<td>邮箱</td>
			<td>个人简介</td>
			<td>心情感言</td>
		</tr>
		<#if users??>
		<#list users as user>
		<tr>
			<td><input type="checkbox" user_id="${user.uId!}" /></td>
			<td>${user.userName!}</td>
			<td>${user.phone!}</td>
			<td>${user.email!}</td>
			<td>${user.personIntroduction!}</td>
			<td>${user.feelWord!}</td>
			<td><a id="user_del" user_id="${user.uId!}">删除</a></td>
			<td><a id="user_edt" user_id="${user.uId!}">编辑</a></td>
		</tr>
		</#list>
		</#if>
	</table>
</body>
</html>