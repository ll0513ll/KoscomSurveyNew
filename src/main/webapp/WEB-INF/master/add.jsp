<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="./top.jsp" %>
<c:set var="index" value="0"/>
<c:set var="count" value="0"/>

<!-- 삭제 Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header" style="padding-bottom: 0px;height: 56px;">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">질문 삭제 확인.</h4>
            </div>
            <div class="modal-body" style="text-align:center;">
                <input type="hidden" name="modalDel" value="">
                <h5 style="margin-top: 30px;">해당 질문을 삭제 할 경우 관련 설문이 모두 삭제됩니다.</h5><br>
                <h5>삭제 하시겠습니까?</h5>
                <div class="buttonBox" style="margin-top:10%;margin-bottom: 5%;">

                    <button type="button" onclick="delQues()" class="btn btn-warning">삭제</button>
                    <button type="button" data-dismiss="modal" aria-label="Close" class="btn btn-default"
                            style="margin-left: 10px;">취소
                    </button>

                </div>
            </div>
        </div>
    </div>
</div>
<!-- 생성완료 Modal -->
<div class="modal fade" id="completeModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header" style="padding-bottom: 0px;height: 56px;">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
		            <img src="/assets/images/KoscomLogo.PNG"
		                 style="width: 14rem; height: 4rem;flot:left;margin-bottom: 1%;">
               <h4 class="modal-title" style="float:right;margin-right: 80px;margin-top: 15px;">새로운 설문지 생성이 완료되었습니다.</h4><br>
            </div>
            <div class="modal-body" style="text-align:center;">
            <div class="jumbotron" style="text-align:center; display: table;width: 100%;">
                <h3 style="margin-top: 30px;" id="modalCateName"></h3><br>
                <p><input type="text" id="manager" name="manager" placeholder="&nbsp&nbsp&nbsp회사명"
                          style="width: 250px;height:38px;font-size:1.5rem;"></p>
                 <p><input type="text" id="manager" name="manager" placeholder="&nbsp&nbsp&nbsp담당자"
                          style="width: 250px;height:38px;font-size:1.5rem;"></p>
            </div>
                <div class="svPart" >
                        <c:set var="count" value="${count + 1}"/>
                        <div id='modalQuesList1'>
                            <input type="hidden" name="modalSurveyFormNo" value="">
                                
                        </div>
                        <c:set var="index" value="${index + 1}"/>
            </div>
            <div class="svPart" id="modalQuesList2">
            
            </div>
            <br>
            <form method="post" action="/surveyURL/">
                <div class="buttonBox" style="margin-top:10%;margin-bottom: 5%;">

					<input type="hidden" id="FormId" value="">
                    <input type="submit" class="btn btn-warning" value="확인">
                    <button type="button" data-dismiss="modal" aria-label="Close" class="btn btn-default"
                            style="margin-left: 10px;">취소
                    </button>

                </div>
             </form>
            </div>
        </div>
       </div>
    </div>
<div class="jumbotron" id="mainBox">
    <!-- <p></p> -->
    <h3 style="font-weight: normal;" id="title">질문 제목</h3>
    <p><input type="text" id="Qtitle" name="Qtitle" style="width: 600px;" value=""></p>
    <span>
    <input type="radio" name="Qtype" checked="checked" value="1" style="font-size:8px !important;"/> 객관식 &nbsp;&nbsp;&nbsp;
    <input type="radio" name="Qtype" value="2" style="font-size:8px !important;"/> 주관식
    </span>
    <p></p>
    <div id="addBtnDiv" style="text-align: center; padding-top: 10px;">
    	<button class="btn btn-warning" id="addBtn" role="button">추가하기</button>
    	<button class="btn btn-warning" id="updateBtn" role="button">수정하기</button>
    </div>
</div>
<form if="from" method="post" class="quesList-form" action="${pageContext.request.contextPath}/survey/">
    <div class="row marketing">
        <div class="selectCate" style="margin-bottom: 3%;">
            <label style="font-size:1.5em;">제목 선택</label>
            <select class="form-control" id="selectCate" name="selectCate">
                <c:forEach var="cateList" items="${cateList}" varStatus="status">
                    <option value="${cateList.cateName}">${cateList.cateName}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-lg-6">
            <h4>주관식</h4>
            <p style="margin-top: 20px;"></p>
            <table class="table table-hover">
            	<colgroup>
        			<col class="col-lg-10">
        			<col class="col-lg-1" >
        			<col class="col-lg-1" >
        		</colgroup>
        		<tbody id="quesList2">
                <c:forEach var="vo" items="${quesList}" varStatus="status">
                    <c:if test="${vo.type eq 2 }">
                       <tr>
                        <td style="font-size:13px;">
                            ${vo.quesName}
                        </td>
                        <td>
	                        <input type="hidden" name="quesType" value="${vo.type}">
                        	<button type="button" class="btn btn-default btn-xs quesSel" value="${vo.quesName}">폼 추가</button>
                        </td>
                        <td>
                        	<input type="checkbox" name="quesName" value="${vo.quesNo}">
                        </td>
                       </tr>
                    </c:if>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="col-lg-6">
            <h4>객관식</h4>
            <p style="margin-top: 20px;"></p>
            <table class="table table-hover" >
            	<colgroup>
        			<col class="col-lg-10">
        			<col class="col-lg-1" >
        			<col class="col-lg-1" >
        		</colgroup>
        		<tbody id="quesList1">
                <c:forEach var="vo" items="${quesList}" varStatus="status">
                    <c:if test="${vo.type eq 1 }">
                         <tr>
	                        <td style="font-size:13px;">
	                            ${vo.quesName}
	                        </td>
	                        <td>
	                        	<input type="hidden" name="quesType" value="${vo.type}">
	                        	<button type="button" class="btn btn-default btn-xs quesSel" value="${vo.quesName}">폼 추가</button>
	                        </td>
	                        <td>
	                        	<input type="checkbox" name="quesName" value="${vo.quesNo}">
	                        </td>
                        </tr>
                    </c:if>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="buttonBox" style="float:right;padding-top: 25px;">
	        <button type="button" class="btn btn-default" id="editBtn">수정</button>
	        <button type="button" id="ques_del" class="btn btn-default" style="margin-left: 10px;">삭제</button>
		</div>
	 </div>
        <div class="jumbotron">
        	<table class="table table-hover" >
        		<colgroup>
        			<col class="col-lg-8">
        			<col class="col-lg-4">
        		</colgroup>
        		<thead>
        			<tr>
        				<th style="font-size: 14px;">문제</th>
        				<th style="font-size: 14px;">관리</th>
        			</tr>
        		</thead>
        		<tbody id="quesSelTd">
        			<tr><td colspan="3" align="center">생성할 문제를 선택해주세요.</td></tr>
        		</tbody>
        	</table>
        	<table class="table table-hover">
        		<colgroup>
        			<col class="col-lg-2">
        			<col class="col-lg-4">
        			<col class="col-lg-2">
        			<col class="col-lg-4">
        		</colgroup>
        		<thead>
        			<tr>
        				<td style="font-size: 14px;font-weight: bold;" colspan="4" align="center">날짜를 지정해 주세요.</td>
        			</tr>
        		</thead>
				<tbody>
        			<tr>
        				<td style="font-size: 14px;padding-top: 20px; padding-left: 65px;">시작일 :</td>
        				<td align="left">
        					<input type="date" id="start" value="${vo.startDate}">
						</td>
						<td style="font-size: 14px;padding-top: 20px; padding-left: 65px;">종료일 :</td>
						<td align="left">
							<input type="date" id="end" value="${vo.endDate}">
						</td>
        			</tr>
				</tbody>        	
        	</table>
        </div>
    
    <div class="buttonBox" style="margin-left: 40%;margin-bottom: 5%;float:left;">

        <button type="button" id="surveyFormAddBtn" class="btn btn-warning" style=" width: 106px;height: 54px;">생성하기</button>
    </div>
       
</form>


<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="/assets/js/ie10-viewport-bug-workaround.js"></script>
<script type="text/javascript">

    $(document).ready(function () {
    	$('table thead tr th').addClass('ui-state-default');
    	$('table tbody tr td').addClass('ui-widget-content td-clear');
    	$("#updateBtn").hide();
        var selectCate = $("#selectCate option:selected").val();

        //추가버튼 누를때
        $("#addBtn").on("click", function () {
            console.log("추가버튼됨");
            report = {
                quesName: $("#Qtitle").val(),
                type: $("input[name=Qtype]:checked").val()
            };
            console.log(report);
            $.ajax({
                url: "/quesEdit/addQues",
                type: "post",
                data: report,
                dataType: "json",
                success: function (result) {
                    if (result == 1) {
                        alert("질문 추가 완료");
                        getQuesList();
                    }
                },
                error: function () {
                    alert("카테고리 추가에 실패했습니다.");
                }
            })
        });
        
        var quesSelCnt = 0;
       //폼추가버튼 누를때 
        $(".quesSel").on("click", function () {
        	
        	var quesSelTd = $(this).val();
        	var quesSelTd = "<tr class='selList'>"
        					+ "<input type='hidden' name='finalQues' value='" + $(this).val() + "'>"
        					+ "<input type='hidden' name='finalQtype' value='" + $(this).prev().val() + "'>"
        					+ "<td class='ui-widget-content td-clear'>" + $(this).val() + "</td>"
        					+ "<td class='ui-widget-content td-clear'>"
        					+ "<button type='button' class='up'>▲</button>"
        					+ "<button type='button' class='down'>▼</button>"
        					+ " &nbsp;&nbsp;&nbsp;<button type='button' class='delBtn'>삭제</button>"
        					+ "</td>"
        					+ "</tr>";
        	if (quesSelCnt == 0) {
        		$("#quesSelTd").html(quesSelTd);
        	} else {
        		$("#quesSelTd").append(quesSelTd);
        	}
        	quesSelCnt++;
        });
        
        $( document ).on( "click", ".up", function () {
        	if ($(this).closest("tr").prev().html() == undefined) {
        		alert("더이상 위로 이동할수 없습니다.");	
        	}
        	$(this).closest("tr").prev().before($(this).closest("tr"));
        });
        
        $( document ).on( "click", ".down", function () {
        	if ($(this).closest("tr").next().html() == undefined) {
        		alert("더이상 위로 이동할수 없습니다.");	
        	}
        	$(this).closest("tr").next().after($(this).closest("tr"));
        });
        
        $( document ).on( "click", ".delBtn", function () {
        	$(this).closest("tr").remove();
        });
		
        //생성하기 버튼 누를때
        $("#surveyFormAddBtn").on("click", function () {

            var quesArray = new Array();
            quesIndex = 1;
            $(".selList").each(function () {
                var quesInfo = {
                    quesName : $(this).find("input[name=finalQues]").val(),
                    quesType : $(this).find("input[name=finalQtype]").val(),
                    quesOrder : quesIndex++
                };
                quesArray.push(quesInfo);
            });

                console.log(quesArray);
            var data = {
                cateName: $("#selectCate option:selected").val(),
                startDate: $("#start").val(),
                endDate: $("#end").val(),
                quesList: quesArray
            };
            
            $.ajax({
                url: "/surveyForm/add",
                type: "post",
                data: JSON.stringify(data),
                dataType: "json",
                contentType: 'application/json',
                success: function (data) {
                		console.log(data);
                		
                		$("#modalCateName").text(data.cateName);
                		
                		var results = data.result;
                		
                		for(var i in results){
                			console.log("포문을 탔네");
							var result = results[i];	
                			$("#FormId").val(result.surveyFormGroupNo);
                			
	                		if(result.type == 1){
	                			console.log("객관식  탔네");
	                			var quesName = result.quesName;
	                			var str1 = modalList1(quesName);
	                			$("#modalQuesList1").append(str1);
	                			
		                		 
	                		}
	                		
	                		if(result.type == 2){
	                			console.log("주관식  탔네");
	                			var quesName = result.quesName;
	                			var str2 = modalList2(quesName);
	                			$("#modalQuesList2").append(str2);
		                		 
	                		}
                		};
                		
                		$("#completeModal").modal();
                			
                		
                },
                error: function () {
                    alert("설문지 추가에 실패했습니다.");
                }
            })
        });

    });
    
    //생성하기 버튼처리 후 생성된 간략 설문지 화면 modal 객관식 그림.
    function modalList1(quesName){
    	
    	console.log(quesName);
    	var str1 ="<table class='table' style='margin-bottom: 35px;'>"
        	+	"<caption class='quesName' name='modalcaption1' style='font-weight:bolder;font-size:1.8rem;'>"+ quesName +"</caption>"
        	+	"<tbody>"
        	+   "<tr>"
            +	"<td><input type='radio' class='choice' name='multipleVal[${index}]' value='1'/>아주 나쁨</td>"
            +	"<td><input type='radio' class='choice' name'multipleVal[${index}]' value='2'/>나쁨</td>"
            +	"<td><input type='radio' class='choice' name='multipleVal[${index}]' value='3'/>보통</td>"
            +	"<td><input type='radio' class='choice' name='multipleVal[${index}]' value='4'/>좋음</td>"
            +	"<td><input type='radio' class='choice' name='multipleVal[${index}]' value='5'/>아주 좋음</td>"
            +	"</tr>"
            +	"</tbody>"
            +	"</table>";
            return str1;
    	
    }
    
    //생성하기 버튼처리 후 생성된 간략 설문지 화면 modal 주관식 그림.
    function modalList2(quesName){
    	
    	 var str2 ="<h4 class='quesName' name='modaltype2' style='color:#777;font-weight:bolder;font-size:1.8rem;text-align:left;'>"+ quesName +"</h4>"
	              + "<textarea class='form-control' type='text' id='answer' name='answer[${index}]' style='width: 90%; height:100px;'></textarea>";
	              
         return str2;
    	
    }

    // 카테고리 추가/삭제 후 카테고리 리스트 호출.
    function getQuesList() {

        console.log("추가/삭제 후 새로고침");

        $.ajax({
            url: "/quesEdit/ajaxQuesList",
            type: "get",
            dataType: "json",
            success: function (quesList) {
                console.log("추가완료하고 리스트가져오기 성공")
                $("#quesList1").empty();
                $("#quesList2").empty();
                $("input[name='Qtype']").checked = false;
                $("input[name='Qtitle']").val("")

                console.log(quesList);

                for (var i = 0; i < quesList.length; i++) {
                    if (quesList[i].type == 2) {
                        renderApplied2(quesList[i])
                    } else if (quesList[i].type == 1) {
                        renderApplied1(quesList[i])
                    }
                }

            },
            error: function (request, status, error) {
                alert("code:" + request.status + "\n" + "message:" +
                    request.responseText + "\n" + "error:" + error);
            }

        });

        //질문 리스트 그리기 type.val(1).
        function renderApplied1(quesList) {
            var str ="<tr>"
		            +	"<td style='font-size:13px;' name='tdQname'>" + quesList.quesName + "</td>"
		            +	"<td>"
		            +	"<button type='button' class='btn btn-default btn-xs quesSel' value='"+ quesList.quesName +"'>폼 추가</button>"
		            +	"</td>"
		            +	"<td>"
		            +	"<input type='checkbox' name='quesName' class='Qchoice' value='"+ quesList.quesNo +"'>"
		            +	"</td>"
		            +	"</tr>";
		            	$("#quesList1").append(str);

        }

        //질문 리스트 그리기 type.val(2).
        function renderApplied2(quesList) {
            var str ="<tr>"
	            +	"<td style='font-size:13px;' name='tdQname'>" + quesList.quesName + "</td>"
	            +	"<td>"
	            +	"<button type='button' class='btn btn-default btn-xs quesSel' value='"+ quesList.quesName +"'>폼 추가</button>"
	            +	"</td>"
	            +	"<td>"
	            +	"<input type='checkbox' name='quesName' class='Qchoice' value='"+ quesList.quesNo +"'>"
	            +	"</td>"
	            +	"</tr>";
            $("#quesList2").append(str);
        }

    }

    //삭제버튼 누를때
    $("#ques_del").click(function () {
        console.log("삭제모달");
        var quesNo = [];
        $("input[name=quesName]:checked").each(function (i, e) {
            quesNo[i] = $(this).val();
        });

        if (quesNo == [null]) {
            alert("질문을 선택해 주세요.");
        }//체크한 값이 없으면 띄우기

        console.log(quesNo);
        $("input[name=modalDel]").val(quesNo);
        $("#myModal").modal();
    });

    //삭제 모달내부 삭제버튼 누를때
    function delQues() {

        console.log("삭제버튼 누르고 스크립트");
        var delQuesList = [];
        $("input[name=quesName]:checked").each(function (i, e) {
            delQuesList[i] = $(this).val();
        });
        console.log(delQuesList);

        $.ajax({
            url: "/quesEdit/delQues",
            type: "POST",
            data: {"delQuesList": delQuesList},
            dataType: "json",
            success: function (result) {
                console.log(result)
                if (result >= 1) {
                    $("#myModal").modal("hide")
                    getQuesList();
                }
            },
            error: function () {
                alert("질문 삭제에 실패했습니다.");

            }
        })

    }

	//수정버튼 누를때   
    $("#editBtn").click(function () {
        var choiceCate = $("input[name=quesName]:checked").parents("tr").children("td").html();
        choiceCate.replace(/^\s*/, "") ;
        var count = $("input[name=quesName]:checked").length;
        
        var quesNo = $("input[name=quesName]:checked").val();
        console.log($("input[name=quesName]:checked").val());
        
        if(count >= 2){
        	alert("질문 수정은 한번에 하나씩만 가능합니다.");
        	return;
        }

        $("#title").text("수정 질문");
        $("#Qtitle").val(choiceCate.trim());
        $("#addBtn").hide();
        $("input[name=Qtype]").parent().hide();
        $("#updateBtn").show();
        $("#updateBtn").val(quesNo);
        
        
        
        $('html').scrollTop(0);

    });
	
	//상위 수정하기 버튼 누를때
    $("#updateBtn").click(function () {
   	
    	var report = {
    			quesNo: $(this).val(),
                quesName: $("#Qtitle").val()
    	}
    	console.log(report);
    	
    	$.ajax({
            url: "/quesEdit/quesUpdate",
            type: "POST",
            data: report,
            dataType: "json",
            success: function (result) {
                console.log(result)
                if (result >= 1) {
                	alert("질문이 수정되었습니다.");
                	location.reload();
                }
            },
            error: function () {
                alert("질문 삭제에 실패했습니다.");

            }
        })
    
    });
</script>
<%@ include file="./bottom.jsp" %>