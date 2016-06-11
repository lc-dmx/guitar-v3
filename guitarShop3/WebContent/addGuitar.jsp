<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Guitars_add.action" method="post">
		<table>
			<tr>
				<td align="right"><label>serialNumber:</label></td>
				<td><input type="text" name="serialNumber"  /></td>
			</tr>
			<tr>
				<td align="right"><label>price:</label></td>
				<td><input type="text" name="price"  /></td>
			</tr>
			<tr>
				<td align="right"><label>builder:</label></td>
				<td><input type="text" name="builder"  /></td>
			</tr>
			<tr>
				<td align="right"><label>type:</label></td>
				<td><input type="text" name="type"  /></td>
			</tr>
			<tr>
				<td align="right"><label>backWood:</label></td>
				<td><input type="text" name="backWood"  /></td>
			</tr>
			<tr>
				<td align="right"><label>topWood:</label></td>
				<td><input type="text" name="topWood"  /></td>
			</tr>
			<tr>
				<td align="right"><label>model:</label></td>
				<td><input type="text" name="model"  /></td>
			</tr>
			<tr>
				<td align="right"><label>numStrings:</label></td>
				<td><input type="text" name="numStrings"  /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" name="add"  value="添加"/></td>
			</tr>
		</table>
	</form>
</body>
</html>