<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../common/common.jsp" %>

<script type="text/javascript">
function insert(){
	location.href="insert.ab";
}
function goUpdate(num){
	location.href="update.ab?num=" + num;
}

</script>
web-inf\album\albumList.jsp<br>
<!-- web-inf\common\common.jsp -->

<form action="list.ab" method="get">
	<select name="whatColumn"> <!-- whatColumn=title, keyword=a -->
		<option value="all">전체 검색</option>
		<option value="title">노래 제목</option>
		<option value="singer">가수명</option>
	</select>
	<input type="text" name="keyword">
	<input type="submit" value="검색">
</form>

<table border="1">
	<tr>
		<td colspan="7" align="right">
			<input type="button" value="추가하기" onClick="insert()"> 
		</td>
	</tr>
	<tr>
		<th>번호</th>
		<th>노래제목</th>
		<th>가수명</th>
		<th>가격</th>
		<th>발매일</th>
		<th>삭제</th>
		<th>수정</th>
	</tr> 
	
	<c:forEach var="ab" items="${albumLists }">    
		<tr>
			<td>${ab.num }</td>
			<td>${ab.title }</td>
			<td>${ab.singer }</td>
			<td>${ab.price }</td>
			<td>
				<fmt:parseDate var="parseDate" value="${ab.day }" pattern="yyyy-MM-dd"/>
				<fmt:formatDate var="newDateString" value="${parseDate }" pattern="yyyy-MM-dd"/>
				${newDateString}
			</td>
			<td><a href="delete.ab?num=${ab.num }">삭제</a></td>
			<td>
				<input type="button" value="수정" onClick="goUpdate('${ab.num }')">
			</td>
		</tr>
	</c:forEach>
	
</table>
<br><br>

${pageInfo.pagingHtml}

