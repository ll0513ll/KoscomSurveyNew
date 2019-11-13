<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="./top.jsp" %>
<c:set var="index" value="${paging.startLimit}"/>
<p><h3>오픈 설문지 리스트</h3>
<c:forEach var="vo" items="${urlList}" varStatus="status">
<c:set var="index" value="${index + 1}"/>
	<div class="row marketing"><!-- style="background-color: #ededed;padding-top: 20px;" -->
	<input type="hidden" name="surveyNo" value="${vo.surveyFormGroupNo}">
	<table class="table table-bordered" id="totalList">
		<colgroup>
   			<col class="col-lg-1" >
   			<col class="col-lg-5">
   			<col class="col-lg-1" >
   			<col class="col-lg-4" >
   			<col class="col-lg-1" >
   		</colgroup>
   		<tbody>
   		<tr style="font-size: larger; font-weight: 600;">
   			<td rowspan="4" style="padding-top: 80px;padding-left: 30px;">${index}</td>
   			<td colspan="2"style="background-color: #f8f5f5;">제목</td>
   			<td colspan="2"style="background-color: #f8f5f5;">생성일</td>
   		</tr>
		<tr>
			<td colspan="2">${vo.cateName}</td>
			<td colspan="2">${vo.regDate}</td>
		</tr>
		<tr style="font-size: larger; font-weight: 600;">
			<td colspan="2" style="background-color: #f8f5f5;">전송 URL</td>
   			<td colspan="2"style="background-color: #f8f5f5;">설문 기간</td>
		</tr>
		<tr>
			<td name="urlVal" style="padding-top: 20px;">
				<input type="hidden" class = "GroupNo" value = "${vo.surveyFormGroupNo}">
				<a class="sendUrlList" target="_blank" href="/survey/?quesFormGroupNo=${vo.surveyFormGroupNo}&master=true">http://localhost:8080/surveyURL/?surveyFormGroupNo=${vo.surveyFormGroupNo}</a>
			</td>
			<td name="copyBtnTd">
				<button type="button" name="copyBtn" class="btn btn-default btn-xs" style="margin-top: 5px; margin-left: 5px;">복사</button>
			</td>
			<td class="dateTd">
				${vo.startDate}&nbsp;&nbsp;&nbsp;~&nbsp;&nbsp;&nbsp;${vo.endDate}
			</td>
			<td class="str">${vo.startDate}&nbsp;&nbsp;&nbsp;~&nbsp;&nbsp;&nbsp;<input type="date" class="date" name="endDate">
			</td>
			<td>
				<button type="button" name="dateBtn" class="btn btn-default btn-xs" style="margin-top: 5px; margin-left: 5px;" value="${vo.startDate}">수정</button>
				<button type="button" name="addBtn" class="btn btn-default btn-xs" style="margin-top: 5px; margin-left: 5px;" value="${vo.startDate}">저장</button>
			</td>
		</tr>
   		</tbody>
	</table>
	</div>
</c:forEach>
<div class="paginate" style="text-align: center;margin-bottom: 20px;">
    <a href="javascript:goPage(${paging.firstPageNo})" class="first">
    	<button type="button" class="btn btn-default btn-xs" aria-label="Left Align">
		  <span class="glyphicon glyphicon-backward" aria-hidden="true"></span>
		</button>
    </a>
    <a href="javascript:goPage(${paging.prevPageNo})" class="prev">
    	<button type="button" class="btn btn-default btn-xs" aria-label="Left Align">
		  <span class="glyphicon glyphicon-triangle-left" aria-hidden="true"></span>
		</button>
    </a>
    <span>
    	<c:forEach var="i" begin="${paging.startPageNo}" end="${paging.endPageNo}" step="1">
            <c:choose>
                <c:when test="${i eq paging.pageNo}"><a href="javascript:goPage(${i})" class="choice">${i}</a></c:when>
                <c:otherwise><a href="javascript:goPage(${i})">${i}</a></c:otherwise>
            </c:choose>
        </c:forEach>
    </span>
    <a href="javascript:goPage(${paging.nextPageNo})" class="next">
    	<button type="button" class="btn btn-default btn-xs" aria-label="Left Align">
		  <span class="glyphicon glyphicon-triangle-right" aria-hidden="true"></span>
		</button>
    </a>
    <a href="javascript:goPage(${paging.finalPageNo})" class="last">
    	<button type="button" class="btn btn-default btn-xs" aria-label="Left Align">
		  <span class="glyphicon glyphicon-forward" aria-hidden="true"></span>
		</button>
    </a>
</div>

<script src="/assets/js/ie10-viewport-bug-workaround.js"></script>
<script type="text/javascript">
	$(document).ready(function () {
   		 $(".str").hide();
   		 $("button[name=addBtn]").hide();
	});

	$("button[name=copyBtn]").on("click", function () {
		
		var copyinfo = document.createElement('textarea');
		$("body").append(copyinfo);
		copyinfo.value = $(this).parent().prev().text();
		serveyUrl = copyinfo.value;
		
		
		copyinfo.select();
		document.execCommand("copy");
		document.body.removeChild(copyinfo);
		alert("복사되었 습니다.");
		
		
	 });
	
	$("button[name=dateBtn]").on("click", function () {
	
		$(this).parents().prev(".str").show();
		$(this).parent().prev().prev().hide();
		$(this).hide();
		$(this).next("button").show();
		
		
	});
	
	$("button[name=addBtn]").on("click", function () {
		
		var report = {endDate : $(this).parent().prev().children(".date").val(),
					  startDate : $(this).val(),
					  surveyFormGroupNo : $(this).parents("tr").find(".GroupNo").val()
					 }
					  
		
	 	
		$.ajax({
            url: "/surveyURL/addDate",
            type: "post",
            data: report,
            dataType: "json",
            success: function (result) {
                
            	if (result != 0) {
                    alert("날짜 설정 완료");
                    location.reload();
                }
            },
            error: function () {
                alert("날짜 설정에 실패했습니다.");
            }
        }) 
		
	});
	
	var goPage = function (pageNo) {
		location.href = "?pageNo="+pageNo;
	}
	

	
</script>

<%@ include file="./bottom.jsp" %>