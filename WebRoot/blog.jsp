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
    <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#" class="current">微博列表</a> </div>
    <h1>微博列表</h1>
  </div>
  <div class="container-fluid">
    <hr>
    <div class="row-fluid">
      <div class="span12">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"><i class="icon-th"></i></span>
            <h5>微博列表</h5>
          </div>
          <div class="widget-content nopadding">
            <table class="table table-bordered data-table">
              <thead>
                <tr>
                  <th>微博号</th>
                  <th>微博标题</th>
                  <th>作者</th>
                  <th>发布时间</th>
                  <th>评论数</th>
                  <th>操作</th>
                </tr>
              </thead>
              <tbody>
              	<c:forEach items="${blogs}" var="item" varStatus="status">  
	  				<tr class="gradeA">  
	    				<td>${item.id}</td>  
	    				<td><a href="getBlogByID?id=${item.id}">${item.title}</a></td>  
	    				<td>${item.userId}</td>  
	    				<td>${item.date}</td>  
	    				<td>${item.comment}</td>  
	    				<td><a href="deleteBlog?blogid=${item.id}" data-toggle="modal" class="btn btn-info">删除</a></td>
	  				</tr>  
				</c:forEach>  
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<!--Footer-part-->
<div class="row-fluid">
  <div id="footer" class="span12"> 2017 &copy; BiLin</div>
</div>
<!--end-Footer-part-->
<script src="js/jquery.min.js"></script> 
<script src="js/jquery.ui.custom.js"></script> 
<script src="js/bootstrap.min.js"></script> 
<script src="js/jquery.uniform.js"></script> 
<script src="js/select2.min.js"></script> 
<script src="js/jquery.dataTables.min.js"></script> 
<script src="js/matrix.js"></script> 
<script src="js/matrix.tables.js"></script>
</body>
</html>
