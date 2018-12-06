<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>

</body>
</html>
<script>
function detail(num){
	$.ajax({
		url: "memo/memodetail",
	data:{"num":num},
	dataType:"json",
	success:function(memo){
		//DOM(Document Object Model):html 문서내에 있는 객체 

	}
	});
}
</script>