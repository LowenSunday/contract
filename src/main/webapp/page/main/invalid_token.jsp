<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/page/main/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>通知后台重复提交错误提示</title>
<script type="text/javascript" >
   $(function(){
     setTimeout(function(){
       history.go(-1);
     },5000);
   });
</script>
</head>
<body>
  <div class="Container">
    <!------------ 错误页面 ------------>
    <div class="weberror">
      <div class="web_tit">
        <div class="web_l"></div>
        <h2>温馨提示</h2>
        <div class="web_r"></div>
      </div>
      <div class="web_con">
        <div class="web_left"></div>
        <div class="web_right">
          <h3>请不要重复提交！</h3>
          <p>系统将在5秒钟后  返回 上一页</p>
          <p class="kongbai"></p>
          <p>您现在可以返回：<span><a href="javascript:history.go(-1);">上一页</a></span></p>
        </div>
      </div>
    </div>
  </div>
</body>
</html>
