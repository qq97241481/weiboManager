<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <jsp:include page="title.jsp" flush="true"/><!--动态包含-->
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp" flush="true"/><!--动态包含-->
<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#" class="current">微博</a> </div>
    <h1>微博</h1>
  </div>
  <div class="container-fluid">
    <hr>
    <div class="row-fluid">
      <div class="span12">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-signal"></i> </span>
            <h5>微博</h5>
          </div>
          <br>
          	<div class="progress progress-striped active">
              <div class="bar" style="width: 100%;"></div>
            </div>
          <div class="widget-content">
            <pre class="prettyprint linenums">
            	<center><h5>${blog.title}</h5><br></center>
            	作者：${blog.userId}  /  时间：${blog.date} <br>
            	<center>${blog.context}</center>
            </pre>
             <div class="progress progress-striped progress-danger active">
              <div class="bar" style="width: 100%;"></div>
            </div>
        </div>
        
        <c:forEach items="${comments}" var="item" varStatus="status">
	        <div class="widget-box">
	          <div class="widget-title"> <span class="icon"> <i class="icon-hand-right"></i> </span>
	            <h5>${item.userid}   /   ${item.date}</h5>
	          </div>
	          <div class="widget-content">
	            <p> ${item.content}  </p>
	            <p>
	              <button class="btn tip-top" data-original-title="删除"><a href="deleteComment?commentid=${item.id}&blogid=${blog.id}">删除</a></button>
	            </p>
	          </div>
	        </div>
		</c:forEach>  
        </div>
      </div>
    </div>
  </div>
</div>
<!--end-main-container-part-->

<!--Footer-part-->
<div class="row-fluid">
 <div id="footer" class="span12"> 2017 &copy; BiLin</div>
</div>
<!--End-Footer-part-->
<script src="js/jquery.min.js"></script> 
<script src="js/jquery.ui.custom.js"></script> 
<script src="js/bootstrap.min.js"></script> 
<script src="js/jquery.gritter.min.js"></script> 
<script src="js/jquery.peity.min.js"></script> 
<script src="js/matrix.js"></script> 
<script src="js/matrix.popover.js"></script>
</body>
</html>