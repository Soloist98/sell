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
					<form role="form" method="post" action="/sell/admin/save">
						<div class="form-group">
							<label>名字</label>
							<input name="username" type="text" class="form-control"
								   value="${(sellerInfo.username)!''}"/>
						</div>
						<div class="form-group">
							<label>密码</label>
							<input name="password" type="text" class="form-control"
								   value="${(sellerInfo.password)!''}"/>
						</div>
						<div class="form-group">
							<label>手机号</label>
							<input name="phone" type="text" class="form-control"
								   value="${(sellerInfo.phone)!''}"/>
						</div>
						<input hidden type="text" name="sellerId"
							   value="${(sellerInfo.sellerId)!''}">
						<button type="submit" class="btn btn-default">提交</button>
					</form>
				</div>
			</div>
		</div>
	</div>

</div>
</body>
</html>