<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="./top.jsp" %>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header" style="padding-bottom: 0px;height: 56px;">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">질문 삭제 확인.</h4><br>
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
<div class="jumbotron" id="mainBox">
    <%-- <h2 style="color: #646464;">${cateVo.cateName}</h2> --%>
    <!-- <p></p> -->
    <h3 style="font-weight: normal;" id="titel">질문 제목</h3>
    <p><input type="text" id="Qtitle" name="Qtitle" style="width: 600px;" value=""></p>
    <input type="radio" name="Qtype" checked="checked" value="1" style="font-size:8px !important;"/> 객관식 &nbsp;&nbsp;&nbsp;
    <input type="radio" name="Qtype" value="2" style="font-size:8px !important;"/> 주관식
    <p></p>
    <div id="addBtnDiv" style="text-align: center; padding-top: 10px;"><a class="btn btn-warning" id="addBtn"
                                                                          role="button">추가하기</a></div>
</div>
<form if="from" method="post" class="quesList-form" action="${pageContext.request.contextPath}/survey/">
    <div class="row marketing">
        <div class="selectCate" style="margin-bottom: 3%;">
            <label style="font-size:1.5em;">카테고리 선택</label>
            <select class="form-control" id="selectCate" name="selectCate">
                <c:forEach var="cateList" items="${cateList}" varStatus="status">
                    <option value="${cateList.cateName}">${cateList.cateName}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-lg-6">
            <h4>주관식</h4>
            <p style="margin-top: 20px;"></p>
            <div id="quesList2">
                <c:forEach var="vo" items="${quesList}" varStatus="status">
                    <c:if test="${vo.type eq 2 }">
                        <p>
                            <input class="Qchoice" name="quesName[]" value="${vo.quesName}" qtype="${vo.type}" type="checkbox"/>
                            &nbsp;&nbsp;&nbsp;${vo.quesName}
        					<button class="btn btn-default quesSel" value="${vo.quesName}">선택</button>
                        </p>
                    </c:if>
                </c:forEach>
            </div>
        </div>
        <div class="col-lg-6">
            <h4>객관식</h4>
            <p style="margin-top: 20px;"></p>
            <div id="quesList1">
                <c:forEach var="vo" items="${quesList}" varStatus="status">
                    <c:if test="${vo.type eq 1 }">
                        <p>
                            <input class="Qchoice" name="quesName[]" value="${vo.quesName}" qtype="${vo.type}" type="checkbox"/>
                            &nbsp;&nbsp;&nbsp;${vo.quesName}
                        </p>
                    </c:if>
                </c:forEach>
            </div>
        </div>
        <div class="col-lg-12">
        	<table boder="1">
        		<thead>
        			<tr></tr>
        			<tr>문제</tr>
        			<tr>관리</tr>
        		</thead>
        		<tbody id="quesSelTd">
        			<tr><td colspan="3" align="center">생성할 문제를 선택해주세요.</td></tr>
        		</tbody>
        	</table>
        </div>
    </div>
    <div class="buttonBox" style="margin-left: 40%;margin-top:10%;margin-bottom: 5%;">

        <button type="button" id="surveyFormAddBtn" class="btn btn-warning">생성하기</button>
        <button type="button" class="btn btn-default" id="editBtn">수정</button>
        <button type="button" id="ques_del" class="btn btn-default" style="margin-left: 10px;">삭제</button>

    </div>
</form>


<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="/assets/js/ie10-viewport-bug-workaround.js"></script>
<script type="text/javascript">

    $(document).ready(function () {
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
        $(".quesSel").on("click", function () {
        	var quesSelTd = "<tr>"
        					+ "<input type='hidden' value='" + $(this).val() + "'>"
        					+ "<td></td>"
        					+ "<td>" + $(this).val() + "</td>"
        					+ "<td>"
        					+ "<button class='up'>▲</button>"
        					+ "<button class='down'>▼</button>"
        					+ "<button class='delBtn'>삭제</button>"
        					+ "</td>"
        					+ "<tr>";
        	if (quesSelCnt == 0) {
        		$("#quesSelTd").html(quesSelTd);
        	} else {
        		$("#quesSelTd").append(quesSelTd);
        	}
        	quesSelCnt++;
        	return false;
        });
        
/*         $( document ).on( "click", ".up", function () {
        	console.log($(this).closet("tr").prev());
        	alert($(this).closet("tr").prev());
        	return false;
        	} );  */
        $(".up").delegate("click", function () {
        	console.log($(this).closet("tr").prev());
        	alert($(this).closet("tr").prev());
        	return false;
        });

        $("#surveyFormAddBtn").on("click", function () {

            var quesArray = new Array();

            $(".Qchoice:checked").each(function () {
                var quesInfo = {
                    quesName : $(this).val(),
                    quesType : $(this).attr("qtype")
                };
                quesArray.push(quesInfo);
            });

            var data = {
                cateName: $("#selectCate option:selected").val(),
                quesList: quesArray
            };

            $.ajax({
                url: "/surveyForm/add",
                type: "post",
                data: JSON.stringify(data),
                dataType: "json",
                contentType: 'application/json',
                success: function (result) {
                    colsole.log(result);

                },
                error: function () {
                    alert("카테고리 추가에 실패했습니다.");
                }
            })
        });

    });

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
            var str = "";
            str += "<p><input class='Qchoice' id ='Qchoice' name='quesName' value='" + quesList.quesNo + "' type='checkbox'>&nbsp;&nbsp;&nbsp;" + quesList.quesName + "</p>";
            $("#quesList1").append(str);

        }

        //질문 리스트 그리기 type.val(2).
        function renderApplied2(quesList) {
            var str = "";
            str += "<p><input id ='Qchoice' name='quesName' value='" + quesList.quesNo + "' type='checkbox'>&nbsp;&nbsp;&nbsp;" + quesList.quesName + "</p>";
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

    $("#editBtn").click(function () {

        var choiceCate = $("input[class=Qchoice]:checked").parent().text();
        console.log(choiceCate);

        $("#titel").text("수정 질문");
        $("#Qtitle").val(choiceCate);
        $("#addBtn").text("수정 하기")

        //document.getElementById("mainBox").scrollIntoView();
        $('html').scrollTop(0);

    });
</script>
<%@ include file="./bottom.jsp" %>