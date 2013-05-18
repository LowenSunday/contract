<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/page/main/taglibs.jsp" %>
<%@ include file="/page/main/metas.jsp"%>
<decorator:usePage id="decoratedPage"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
    String path = request.getContextPath();
    // Decorated pages will typically must set a pageID and optionally set a subPageID
    // and extraParams. Store these values as request attributes so that the tab and sidebar
    // handling tags can get at the data.
    request.setAttribute("pageID", decoratedPage.getProperty("meta.pageID"));
    request.setAttribute("subPageID", decoratedPage.getProperty("meta.subPageID"));
    request.setAttribute("extraParams", decoratedPage.getProperty("meta.extraParams"));

    // Message HTML can be passed in:
    String message = decoratedPage.getProperty("page.message");
%>
<head>
<title>版权监管系统</title>
	<link rel="stylesheet" type="text/css" href="${ctxPath}/style/global.css">
	<link rel="stylesheet" type="text/css" href="${ctxPath}/style/jquery/jquery-ui.css">
	<decorator:head></decorator:head>
</head>
<body id="jive-body">

<!-- BEGIN main -->
<div id="main">

    <div id="jive-header">
        <div id="jive-logo">
            <a href="${ctxPath}/index.jsp"><img src="${ctxPath}/images/login_logo.png" alt="东方网信" width="179" height="53" /></a>
        </div>
      	
        <div id="jive-userstatus" align="right">
				Regulatory 1.0.1<br /> Logged in as <strong></strong> - <a
					href="logout">Logout</a>
		</div>
		
               <div id="jive-nav">
            <div id="jive-nav-left"></div>
            <admin:tabs css="" currentcss="currentlink">
            <a href="[url]" title="[description]" onmouseover="self.status='[description]';return true;" onmouseout="self.status='';return true;">[name]</a>
            </admin:tabs>
            <div id="jive-nav-right"></div>
        </div>
         <div id="jive-subnav">
            <admin:subnavbar css="" currentcss="current">
                <a href="[url]" title="[description]" onmouseover="self.status='[description]';return true;" onmouseout="self.status='';return true;">[name]</a>
            </admin:subnavbar>
        </div>
    </div>
</div>

 <div id="jive-main">
    <table cellpadding="0" cellspacing="0" border="0" width="100%">
    <tbody>
        <tr valign="top">
            <td width="1%">
                <div id="jive-sidebar-container">
                    <div id="jive-sidebar-box">
                        <div id="jive-sidebar">
                            <admin:sidebar css="" currentcss="currentlink" headercss="category">
                                <a href="[url]" title="[description]"
                                  onmouseover="self.status='[description]';return true;" onmouseout="self.status='';return true;"
                                  >[name]</a>
                                 <admin:subsidebar css="" currentcss="currentlink">
                                    <a href="[url]" title="[description]"
                                     onmouseover="self.status='[description]';return true;" onmouseout="self.status='';return true;"
                                     >[name]</a>
                                 </admin:subsidebar>
                            </admin:sidebar>
                            <br>
                            <img src="${ctxPath}/images/blank.gif" width="150" height="1" border="0" alt="">
                        </div>
                    </div>
                </div>
            </td>
            <td width="99%" id="jive-content">
                <h1>
                    <decorator:title default="&nbsp;"/>
                </h1>

                <div id="jive-main-content">
                    <decorator:body/>
                </div>
            </td>
        </tr>
    </tbody>
    </table>
</div>
<!-- END main -->

<!-- BEGIN footer -->
	<div id="jive-footer">
        <div class="jive-footer-nav">
         
        </div>
        <div class="jive-footer-copyright">
            <a href="http://www.net-east.com/">Copyright &copy; 2012 北京东方网信科技股份有限公司 版权所有 京ICP备11019379号</a>
        </div>
    </div>
<!-- END footer -->

</body>

</html>
