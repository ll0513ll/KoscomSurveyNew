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
                <h4 class="modal-title" id="myModalLabel">카테고리 삭제 확인.</h4><br>
            </div>
            <div class="modal-body" style="text-align:center;">
                <input type="hidden" name="modalDel" value="">
                <h5 style="margin-top: 30px;">해당 카테고리를 삭제 할 경우 관련 설문이 모두 삭제됩니다.</h5><br>
                <h5>삭제 하시겠습니까?</h5>
                <div class="buttonBox" style="margin-top:10%;margin-bottom: 5%;">

                    <button type="button" onclick="delCate();" class="btn btn-warning">삭제</button>
                    <button type="button" data-dismiss="modal" aria-label="Close" class="btn btn-default"
                            style="margin-left: 10px;">취소
                    </button>

                </div>
            </div>
        </div>
    </div>
</div>


<div class="jumbotron">
    <h3 style="font-weight: normal;" id="cateTitle">설문지 제목</h3>
    <div class="addCate">
        <p>
            <input type="text" id="cateName" name='addCateName' style="width: 600px;" value="">
        </p>
    </div>
    <h4 style="font-weight: normal;">설명</h4>
    <div class="addCate">
        <p>
            <textarea class="form-control" id="cateInfo" name='addCateInfo' type="text"
                      style="width: 600px; height:80px;" value=""></textarea>
        </p>
    </div>
    <p></p>
    <div id="addBtnDiv" style="text-align: center; padding-top: 10px;">
        <button class="btn btn-warning" id="addBtn" role="button">추가하기</button>
        <button class="btn btn-warning" id="updateBtn" role="button">수정하기</button>
    </div>
</div>
<form method="post" class="cateList-form" action="${pageContext.request.contextPath}/quesEdit/">
    <div class="row marketing">
        <div style="text-align: left;">
            <table class="table table-striped" id="cateListTable">
                <thead><h3 style=" margin-bottom: 20px;">카테고리 리스트</h3></thead>
                <tbody>
                <c:forEach items="${cateList}" var="vo">
                    <tr>
                        <td name="cateInfo" title="${vo.cateInfo}" style="font-weight: bold;font-size:14px;">
                        	<input type="hidden" name="hiddenInfo" value="${vo.cateInfo}">
                            <input class="Qchoice" name="cateName" type="checkbox" value="${vo.cateNo}"/>&nbsp;&nbsp;&nbsp;${vo.cateName}
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="buttonBox" style="text-align:center;padding-top: 25px;">
		        <button type="button" class="btn btn-primary" id="editBtn">수정</button>
		        <button type="button" id="cate_del" class="btn btn-default" style="margin-left: 10px;">삭제</button>
			</div>
        </div>
    </div>
</form>


<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="/assets/js/ie10-viewport-bug-workaround.js"></script>

<script type="text/javascript">

	$(document).ready(function () {
	 	$("#updateBtn").hide();
	
	});
    //삭제버튼 누를때
    $("#cate_del").click(function () {
        console.log("삭제모달");
        var cateNo = [];
        $("input[name=cateName]:checked").each(function (i, e) {
            cateNo[i] = $(this).val();
        });

        if (cateNo.length == 0) {
            alert("카테고리를 선택해 주세요.");
            return;
        }//체크한 값이 없으면 띄우기

        console.log(cateNo);
        $("input[name=modalDel]").val(cateNo);
        $("#myModal").modal();
    });

    //추가버튼 누를때
    $("#addBtnDiv").on("click", "#addBtn", function () {
        console.log("추가버튼됨");

        report = {
            cateName: $("#cateName").val(),
            cateInfo: $("#cateInfo").val()
        };

        console.log(report);

        $.ajax({
            url: "/cateEdit/addCate",
            type: "post",
            data: report,
            dataType: "json",
            success: function (result) {

                if (result == 1) {
                    alert("카테고리 추가 완료");
                    getCateList();

                }
            },
            error: function () {
                alert("카테고리 추가에 실패했습니다.");
            }
        })
    });

    // 카테고리 추가 후 카테고리 리스트 호출.
    function getCateList() {

        console.log("추가 후 새로고침");

        $.ajax({
            url: "/cateEdit/getCateList",
            type: "get",
            dataType: "json",
            success: function (cateList) {

                $("#cateListTable").empty();
                $("input[name='addCateName']").val("")
                $("textarea[name='addCateInfo']").val("")

                if (cateList.length > 0) {
                    for (var i = 0; i < cateList.length; i++) {
                        renderApplied(cateList[i])
                    }
                } else {
                    var str = "<tr><td align='center'>등록된 정보가 없습니다.</td></tr>";
                    $("#cateListTable").append(str);
                }
            },
            error: function (request, status, error) {
                alert("code:" + request.status + "\n" + "message:" +
                    request.responseText + "\n" + "error:" + error);
            }

        });

        //카테고리 리스트 테이블 그리기.
        function renderApplied(cateList) {
            var str = "";
            str += "<tr data-careerno='" + cateList.cateNo + "'>";
            str += "<td name='cateInfo' style='font-weight: bold;font-size:14px;' title='" + cateList.cateInfo + "'><input name='cateName' type='checkbox' value='" + cateList.cateNo + "'>&nbsp;&nbsp;&nbsp;" + cateList.cateName + "</td>";
            $("#cateListTable").append(str);

        }
    }


    //삭제 모달내부 삭제버튼 누를때
    function delCate() {

        console.log("삭제버튼 누르고 스크립트");
        var delCateList = [];
        //cate_no= $("input[name=modalDel]").val();
        $("input[name=cateName]:checked").each(function (i, e) {
            delCateList[i] = $(this).val();
        });
        //cate_no = $("input[name=modalDel]").val();
        console.log(delCateList);

        $.ajax({
            url: "/cateEdit/delCate",
            type: "POST",
            data: {"delCateList": delCateList},
            dataType: "json",
            success: function (result) {
                console.log(result)
                if (result >= 1) {
                    $("#myModal").modal("hide")
                    getCateList();
                }
            },
            error: function () {
                alert("카테고리 삭제에 실패했습니다.");
                //$(".alert").show();
                /* $(“.alert”).on(“close.bs.alert”, function() {
                    alert(“이벤트 실행됨”);
                  }); */
            }
        })

    }
	
    //수정버튼 누를때
    $("#editBtn").click(function () {
    	//<input class="Qchoice" name="cateName" type="checkbox" value="${vo.cateNo}">&nbsp;&nbsp;&nbsp;${vo.cateName}
        var choiceCate = $("input[class=Qchoice]:checked").parent().text();
        console.log(choiceCate);
        choiceCate.replace(/^\s*/, "") ;
        
        var cateInfo = $("input[class=Qchoice]:checked").prev().val();
        console.log(cateInfo);
        
        var count = $("input[name=cateName]:checked").length;
        
        var cateNo = $("input[name=cateName]:checked").val();
        console.log($("input[name=cateName]:checked").val());
        
        if(count >= 2){
        	alert("제목 수정은 한번에 하나씩만 가능합니다.");
        	return;
        }

        $("#cateTitle").text("제목 수정");
        $("#cateName").val(choiceCate);
        $("#addBtn").hide();
        $("#updateBtn").show();
        $("#updateBtn").val(cateNo);
        $("#cateInfo").val(cateInfo);
        
        
        
        $('html').scrollTop(0);

    });
    
    $("#updateBtn").click(function () {
       	
    	var report = {
    			cateNo: $(this).val(),
    			cateName: $("#cateName").val()
    	}
    	console.log(report);
    	
    	$.ajax({
            url: "/cateEdit/cateUpdate",
            type: "POST",
            data: report,
            dataType: "json",
            success: function (result) {
                console.log(result)
                if (result >= 1) {
                	alert("제목이 수정되었습니다.");
                	location.reload();
                }
            },
            error: function () {
                alert("제목 수정에 실패했습니다.");

            }
        })
    
    });

</script>

<%@ include file="./bottom.jsp" %>