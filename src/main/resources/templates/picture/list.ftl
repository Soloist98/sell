<html>
<head>
	<meta charset="UTF-8">
	<title>轮播图管理</title>
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
							<th>图片id</th>
							<th>图片描述</th>
							<th>创建时间</th>
							<th>图片url</th>
							<th>操作</th>
						</tr>
						</thead>
						<tbody>

						<#list pictureList as picture>
							<tr>
								<td>${picture.picId}</td>
								<td>${picture.picMessage}</td>
								<td>${picture.picCreate}</td>
								<td>${picture.picUrl}</td>
								<td><a href="/sell/picture/index?picId=${picture
									.picId}">修改</a></td>
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