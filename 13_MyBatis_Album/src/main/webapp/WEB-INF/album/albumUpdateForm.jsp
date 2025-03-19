<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        
<%@ include file="../common/common.jsp" %> 
albumUpdateForm.jsp<br> 
<style type="text/css">
	.err{
		font-size: 10pt;
		color: red;
		font-weight: bold;
	}
</style>

<h1>앨범 수정</h1>
<form:form commandName="album" action="update.ab" method="post">
	<input type="hidden" name="num" value="${album.num }">
	<p>
		<label>노래제목</label>
		<input type="text" name="title" value="${album.title }">
		<form:errors cssClass="err" path="title"/>
	</p>
	
	<p>
		<label>가수명</label>
		<input type="text" name="singer" value="${album.singer }">
		<form:errors cssClass="err" path="singer"/>
	</p>
	
	<p>
		<label>가격</label>
		<input type="text" name="price" value="${album.price }">
		<form:errors cssClass="err" path="price"/>
	</p>
	
	<p>
		<label>발매일</label>
		
		<fmt:parseDate var="parseDate" value="${album.day }" pattern="yyyy-MM-dd"/>
		<fmt:formatDate var="newDateString" value="${parseDate }" pattern="yyyy-MM-dd"/>
		<input type="text" name="day" value="${newDateString}">
	</p>
	
	<p>
		<input type="submit" value="수정하기">
	</p>

</form:form>