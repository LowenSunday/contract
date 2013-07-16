<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统登陆</title>
<script type="text/javascript">

function myReload()
{  
  document.getElementById("createCheckCode").src=document.getElementById("createCheckCode").src + "?nocache="+new Date().getTime();  
}
function mit()
{
  var regu="^[0-9a-zA-Z_]{4,20}$";
  re=new RegExp(regu);
  
  var str=document.getElementById("userName").value;
  
  if(str.length==0 || !re.test(str))
  {
  alert("用户名不能为空！且长度为4-20！只能包含数字,字母,下划线");
  document.getElementById("userName").focus();
  return false;
  }
  
  /*
  regu="^[0-9a-zA-Z_]{1,20}@[0-9a-zA-Z_]+\.[a-z0-9]{2,3}$";
  re=new RegExp(regu);
  str=document.getElementById("email").value;
  if(str.length==0 || !re.test(str))
  { 
  alert("邮箱格式不对！");
  document.getElementById("email").focus();
  return false;
  
  }
  */
  var regu="^[0-9a-zA-Z_]{4,20}$";
  re=new RegExp(regu);
  
  var str=document.getElementById("password").value;
  
  if(str.length==0 || !re.test(str))
  {
  alert("密码不能为空！且长度为4-20！只能包含数字,字母,下划线");
  document.getElementById("password").focus();
  return false;
  }
  
}  
</script>
<style type="text/css">#c_content{border:1px solid #598edd;margin-top:5px}#r_table{width:100%;margin-top:1px}#r_table tr:hover td{background-color:#f5f8fb}#r_table td{vertical-align:middle;padding-top:10px;padding-bottom:3px;border-bottom:1px solid #c9d7f1}#r_table span{display:block;font-size:14px;font-weight:bold;color:#666;padding-bottom:3px}#r_table input{font-size:18px;margin-right:10px}#r_table samp{height:26px;width:15px;margin-right:4px}#r_table .button{font-size:12px}.r_cell_1{width:350px;padding-left:40px}.r_su{display:block;margin:15px}.r_submit{margin-left:140px;margin-right:-130px}#t_auth,#authimg{float:left}#t_auth{margin-top:6px}</style>
</head>
<body>
<font color="red">
<s:if test="userName != null">
<s:fielderror><s:param>userName</s:param></s:fielderror><br/>
</s:if>
<s:if test="password != null">
<s:fielderror><s:param>password</s:param></s:fielderror><br/>
</s:if>
<s:if test="validatecode != null">
<s:fielderror><s:param>validatecode</s:param></s:fielderror><br/></s:if>
</font><br/>
<form action="login" method="post" id="f_reset">
<table id="r_table" width="100%" cellpadding="0" cellspacing="0" border="0">
<tbody>
<tr>
<td class="r_cell_1"><span>用户名</span><font color="red">请输入您的用户名</font></td>
<td class="r_cell_2"><input type="text" class="input-text" name="userName" id="userName"></td>
</tr>

<tr>
<td class="r_cell_1"><span>密码</span><font color="red">请输入您的密码</font></td>
<td class="r_cell_2"><input type="text" class="input-text" name="password" id="password"></td>
</tr>

<tr>
<td class="r_cell_1"><span>验证码</span><font color="red">请输入右边图片中的字符</font></td>
<td class="r_cell_2">
<input name="validatecode" type="text" id="validatecode" title="验证码区分大小写" maxlength="4">  
        <img id="createCheckCode" src="PictureCheckCode">  
        <a href="#" onClick="myReload()">看不清，换一个</a><br />
</td>
</tr>
</tbody>
</table>

<div class="r_su"><input type="submit" class="button r_submit" value="登陆" onClick="return mit()" /></div>
</form>


</body>
</html>