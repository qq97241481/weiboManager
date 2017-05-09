<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!--Header-part-->
<div id="header">
  <h1><a href="dashboard.html">比邻微博</a></h1>
</div>
<!--close-Header-part-->
<!--top-Header-menu-->
<div id="user-nav" class="navbar navbar-inverse">
  <ul class="nav">
    <li  class="dropdown" id="profile-messages" ><a title="" href="#" data-toggle="dropdown" data-target="#profile-messages" class="dropdown-toggle"><i class="icon icon-user"></i>  <span class="text">欢迎Admin</span><b class="caret"></b></a>
    </li>
    <li class=""><a title="" href="login.html"><i class="icon icon-share-alt"></i> <span class="text">退出</span></a></li>
  </ul>
</div>

<div id="sidebar"><a href="#" class="visible-phone"><i class="icon icon-home"></i> 控制台</a>
  <ul>
    <li class="active"><a href="getUserinfo"><i class="icon icon-home"></i> <span>首页</span></a> </li>
    <li> <a href="charts.jsp"><i class="icon icon-signal"></i> <span>微博统计</span></a> </li>
    <li><a href="getUserChart"><i class="icon icon-th"></i> <span>用户列表</span></a></li>
    <li><a href="getBlog"><i class="icon icon-th"></i> <span>微博列表</span></a></li>
  </ul>
</div>
<!--sidebar-menu-->
