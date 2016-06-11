<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="./css/default.css" />
	<link rel="stylesheet" type="text/css" href="./css/query.css" />
<body>
<div id="navi">
	<div id='naviDiv'>
		<span><img src="./images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;guitar管理&nbsp;
		<span><img src="./images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;<a href="./Guitars_query.action">guitar列表</a>&nbsp;
	</div>
</div>

<div id="mainContainer">

	 <div style="height:30px" >
	 	<form action="Guitars_search.action" method="post">
	 		<label>Builder:</label>
	 		<select name="builder"  style="border:solid 1px">
	 			<option value=""></option>
	 			<option value="rosen">rosen</option>
	 			<option value="Lankro">Lankro</option>
	 			<option value="Kepma">Kepma</option>
	 			<option value="Geek">Geek</option>
	 			<option value="Matilda">Matilda</option>
	 			<option value="Hailun">Hailun</option>
	 			<option value="Califor">Califor</option>
	 			<option value="Califor">Aidy Music</option>
	 			<option value="Califor">enya</option>
	 			<option value="Califor">Minsine</option>
	 		</select>
	 		
	 		<label>Type:</label>
	 		<select name="type" style="border:solid 1px">
	 			<option value=""></option>
	 			<option value="D15">D15</option>
	 			<option value="D16">D16</option>
	 			<option value="A1C">A1C</option>
	 			<option value="CLF390C">CLF390C</option>
	 			<option value="youth599">youth599</option>
	 			<option value="AD401">AD401</option>
	 			<option value="D1C">D1C</option>
	 		</select>
	 		
	 		<label>BackWood:</label>
	 		<select name="backWood" style="border:solid 1px">
	 			<option value=""></option>
	 			<option value="椴木">椴木</option>
				<option value="杉木">杉木</option>
				<option value="沙比利">沙比利</option>
				<option value="云杉木">云杉木</option>
				<option value="桃花心木">桃花心木</option>
	 		</select>
	 		
	 		<label>TopWood:</label>
	 		<select name="topWood" style="border:solid 1px">
	 			<option value=""></option>
	 			<option value="椴木">椴木</option>
				<option value="杉木">杉木</option>
				<option value="云杉木">云杉木</option>
	 		</select>	 	 
				<input type="submit" name="search" value="查找guitar"  style="border:solid 1px" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'"/>
	 	</form>
	 </div>
<table class="default"  style="width:90%">

	<tr class="title">
		<td>serialNumber</td>
		<td>price</td>
		<td>builder</td>
		<td>type</td>
		<td>backWood</td>
		<td>topWood</td>
		<td>model</td>
		<td>numStrings</td>
		<td>操作</td>
	</tr>
	
	<c:forEach var="guitar" items="${guitars_list}"> 
	<tr class="list">
		<td>${guitar.serialNumber}</td>
	 			<td>${guitar.price}</td>
	 			<td>${guitar.spec.builder}</td>
	 			<td>${guitar.spec.type}</td>
	 			<td>${guitar.spec.backWood}</td>
	 			<td>${guitar.spec.topWood}</td>
	 			<td>${guitar.model}</td>
	 			<td>${guitar.numStrings}</td>
		<td><a href="./Guitars_delete.action?serialNumber=${guitar.serialNumber}" onclick="javascript: return confirm('真的要删除吗？');">删除</a></td>
	</tr>
	</c:forEach>

</table>
</div>
</body>
</html>