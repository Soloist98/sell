<html>
<head>
    <meta charset="UTF-8">
    <title>错误提示</title>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="alert alert-dismissable alert-warning">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                <h4>错误!</h4>
                <h3><strong>错误信息:</strong>${msg}</h3>
                <a href="${url}" class="alert-link">点击跳转</a>
            </div>
        </div>
    </div>
</div>

</body>

<#--<script>-->
<#--    setTimeout('location.href="${url}"',5000);-->
<#--</script>-->

</html>
