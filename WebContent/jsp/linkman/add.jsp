﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>添加联系人</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css"
	type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css"
	type=text/css rel=stylesheet>


<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<!-- upload requirement: -->
	<!-- if using upload, the mothod should be "post", because "get" has size restriction -->
	<!-- use attribute "enctype" -->

	<FORM id=form1 name=form
		action="${pageContext.request.contextPath }/linkman_addLinkMan.action"
		method="post" enctype="multipart/form-data">


		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG
						src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0></TD>
					<TD width="100%"
						background="${pageContext.request.contextPath }/images/new_020.jpg"
						height=20></TD>
					<TD width=15><IMG
						src="${pageContext.request.contextPath }/images/new_021.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background=${pageContext.request.contextPath }
						/images/new_022.jpg><IMG
						src="${pageContext.request.contextPath }/images/new_022.jpg"
						border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：联系人管理 &gt; 添加联系人</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE cellSpacing=0 cellPadding=5 border=0>
							<tr>
								<td>所属客户：</td>
								<!-- name="customer.cid" shorthand encapsulate -->
								<td colspan="3"><select name="customer.cid">
										<c:forEach var="customer" items="${list }">
											<!-- value would be add as clid in database when form was post -->
											<option value="${customer.cid}">${customer.custName }</option>
										</c:forEach>
								</select></td>
							</tr>
							<TR>
								<td>联系人名称：</td>
								<td><INPUT class=textbox id=sChanne1 style="WIDTH: 180px"
									maxLength=50 name="lkmName"></td>
								<td>联系人性别：</td>
								<td><input type="radio" value="男" name="lkmGender">男
									<input type="radio" value="女" name="lkmGender">女</td>
							</TR>
							<TR>
								<td>联系人办公电话 ：</td>
								<td><INPUT class=textbox id=sChanne2 style="WIDTH: 180px"
									maxLength=50 name="lkmPhone"></td>
								<td>联系人手机 ：</td>
								<td><INPUT class=textbox id=sChanne3 style="WIDTH: 180px"
									maxLength=50 name="lkmMobile"></td>
							</TR>
							<TR>
								<td>选择文件</td>
								<td><input type="file" name="upload"></td>
								<td></td>
								<td></td>
							</TR>
							<tr>
								<td rowspan=2><INPUT class=button id=sButton2 type=submit
									value="保存 " name=sButton2></td>
							</tr>
						</TABLE>


					</TD>
					<TD width=15
						background="${pageContext.request.contextPath }/images/new_023.jpg">
						<IMG src="${pageContext.request.contextPath }/images/new_023.jpg"
						border=0>
					</TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG
						src="${pageContext.request.contextPath }/images/new_024.jpg"
						border=0></TD>
					<TD align=middle width="100%"
						background="${pageContext.request.contextPath }/images/new_025.jpg"
						height=15></TD>
					<TD width=15><IMG
						src="${pageContext.request.contextPath }/images/new_026.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
</BODY>
</HTML>
