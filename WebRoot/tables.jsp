<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="title.jsp" flush="true" /><!--动态包含-->
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp" flush="true" /><!--动态包含-->
	
	<div id="content">
		<div id="content-header">
			<div id="breadcrumb">
				<a href="#" title="Go to Home" class="tip-bottom"><i
					class="icon-home"></i> Home</a> <a href="#" class="current">用户列表</a>
			</div>
			<h1>用户列表</h1>
		</div>
		<div class="container-fluid">
			<hr>
			<div class="row-fluid">
				<div class="span12">
					<div class="widget-box">
						<div class="widget-title">
							<span class="icon"><i class="icon-th"></i></span>
							<h5>用户列表</h5>
						</div>
						<div class="widget-content nopadding">
							<table class="table table-bordered data-table">
								<thead>
									<tr>
										<th>id号</th>
										<th>用户名</th>
										<th>头像链接</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${users}" var="item" varStatus="status">
										<tr class="gradeA">
											<td>${item.id}</td>
											<td>${item.username}</td>
											<td>${item.headerUrl}</td>
											<td>
												<div>
													<a href="#myAlert" data-toggle="modal" class="btn btn-warning" onclick="senduser('${item.username}','${item.headerUrl}','${item.id}')">私信</a> 
													<a href="#myModal2" data-toggle="modal" class="btn btn-info" onclick="deleteuser('${item.username}','${item.id}')">删除</a>
													<form action="deleteUser">
													<div id="myModal2" class="modal hide">
														<div class="modal-header">
															<button data-dismiss="modal" class="close" type="button">×</button>
															<h3>删除用户</h3>
														</div>
														<div class="modal-body" id="user-modal-body">
															
														</div>
														<div class="modal-footer">
															<input type="hidden" name="userinfo" id="deleteuserinfo">
															<input type="submit" value="删除" class="btn btn-inverse"> 
															<a data-dismiss="modal" class="btn" href="#">取消</a>
														</div>
													</div>
													</form>
													<div id="myAlert" class="modal hide">
														<form action="MesaageServlet" method="post">
														<div class="widget-content nopadding collapse in"
															id="collapseG4">
															<div class="chat-users panel-right2">
																<div class="panel-title">
																	<h5>私信</h5>
																</div>
																<div class="panel-content nopadding">
																	<ul class="contact-list">
																		<li id="user-Alex" class="online">
																		</li>
																	</ul>
																</div>
															</div>
															<div class="chat-content panel-left2">
																<div class="chat-messages" id="chat-messages">
																	<div id="chat-messages-inner">
																		
																	</div>
																</div>
																<div class="chat-message well">
																	<input type="text" name="msg-box" id="msg-box">
																	<p></p>
																	<input class="btn btn-warning" data-dismiss="modal"  value="取消">
																	<input class="btn btn-success" type="submit"  value="发送">
																	<span class="input-box"> 
																	<input type="hidden" name="user" id="hiddenuerid" value=${item.id}>
																	</span>
																</div>
															</div>
														</div>
														</form>
													</div>
											</td>
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
 		<div id="footer" class="span12"> 2017 &copy; BiLin. </div>
	</div>
	<!--end-Footer-part-->
	<script src="js/jquery.min.js"></script>
	<script src="js/jquery.ui.custom.js"></script>
	<script src="js/matrix.chats.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.uniform.js"></script>
	<script src="js/select2.min.js"></script>
	<script src="js/jquery.dataTables.min.js"></script>
	<script src="js/matrix.js"></script>
	<script src="js/matrix.tables.js"></script>
	<script src="js/matrix.popover.js"></script>
	
	<script type="text/javascript">
	
	function deleteuser(m,d){
		   $("#user-modal-body").html('<center><p>确定删除用户'+m+'？</p></center>');
		   /* $("#deleteuerinfo").html('<a data-dismiss="modal" class="btn btn-inverse"  href="deleteUser">删除</a>'
										+'<a data-dismiss="modal" class="btn" href="#">取消</a>'); */
		   $("#deleteuserinfo").val(d);
		   
	   }
 
	 function senduser(e,a,b){
 	 	$("#user-Alex").html('<img src='+a+' /> <span>'+e+'</span>');
 	 	$("#hiddenuerid").val(b);
	 }
	</script>
</body>
</html>
