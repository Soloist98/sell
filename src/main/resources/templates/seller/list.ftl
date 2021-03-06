<html>
<head>
	<meta charset="UTF-8">
	<title>管理员</title>
	<link href="https://cdn.bootcss.com/twitter-bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="/sell/css/style.css">
</head>

<body>
<div id="wrapper" class="toggled">

	<#--边栏sidebar-->
	<#include "../common/nav.ftl">

	<#--主要内容content-->
	<div id="page-content-wrapper">
		<div class="container-fluid">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<table class="table table-bordered table-condensed">
						<thead>
						<tr>
							<th>id</th>
							<th>名字</th>
							<th>密码</th>
							<th>手机号</th>
							<th>创建时间</th>
							<th>修改时间</th>
							<th>操作</th>
						</tr>
						</thead>
						<tbody>

						<#list sellerInfoList as sellerInfo>
							<tr>
								<td>${sellerInfo.sellerId}</td>
								<td>${sellerInfo.username}</td>
								<td>${sellerInfo.password}</td>
								<td>${sellerInfo.phone}</td>
								<td>${sellerInfo.createTime}</td>
								<td>${sellerInfo.updateTime}</td>
								<td><a href="/sell/admin/index?sellerId=${sellerInfo
									.sellerId}">修改</a></td>
							</tr>
						</#list>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

</div>
</body>
</html>