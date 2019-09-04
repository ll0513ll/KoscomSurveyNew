<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="./top.jsp" %>
<c:set var="index" value="0"/>
<c:set var="count" value="0"/>
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header" style="padding-bottom: 0px;height: 56px;">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">설문참여 완료.</h4><br>
            </div>
            <div class="modal-body" style="text-align:center;">
                <input type="hidden" name="modalDel" value="">
                <h5 style="margin-top: 30px;">KOSCOM 설문에 참여해주셔서 감사합니다.</h5><br>
                <div class="buttonBox" style="margin-top:10%;margin-bottom: 5%;">

                    <button type="button" onclick="surveyEnd();" class="btn btn-warning">확인</button>
                    <button type="button" data-dismiss="modal" aria-label="Close" class="btn btn-default"
                            style="margin-left: 10px;">취소
                    </button>

                </div>
            </div>
        </div>
    </div>
</div>


<div class="row marketing">
    <div class="col-lg">
        <form method="post" class="quesList-form" id="formname1">
            <div class="jumbotron" style="text-align:center; display: table;width: 100%;">
            	<input type="hidden" id="cateName" name="cateName" value="${surveyVo[0].cateName}">
            	<input type="hidden" id="quesFormGroupNo" name="quesFormGroupNo" value="${quesFormGroupNo}">
                <h2 id="HcateName" name="HcateName" style="margin-top: 0px; margin-bottom: 4%;color: inherit;"
                    value="${surveyVo[0].cateName}">${surveyVo[0].cateName}</h2>
                <p><select class="form-control" id="selectCompany" name="companyNo"
                           style="width: 250px; margin: 0 auto;">
                    <option id="choicCompany">회사를 선택하세요.</option>
                    <c:forEach var="vo" items="${cliVo}" varStatus="status">
                        <c:set var="index" value="${index + 1}"/>
                        <option name="selCompanyName[${index}]" value="${vo.companyNo}">${vo.companyName}</option>
                        <!-- <p><input type="text" id="companyName" name = "companyName" placeholder="회사명" style = "width: 250px;height:38px;font-size:1.5rem;"></p> -->
                    </c:forEach>
                </select></p>
                <p><input type="text" id="manager" name="manager" placeholder="&nbsp&nbsp&nbsp담당자"
                          style="width: 250px;height:38px;font-size:1.5rem;"></p>
            </div>
            <div class="svPart">
                <c:forEach var="vo" items="${surveyVo}" varStatus="status">
                    <div class="quesArea">
                    <input type="hidden" class="type" name="type[${index}]" value="${vo.type}">
                    <input type="hidden" class="quesName" name="quesName[${index}]" value="${vo.quesName}">
                    <c:set var="count" value="${count + 1}"/>
                    <c:if test="${vo.type eq 1 }">
                        <table class="table" style="margin-bottom: 35px;">
                            <caption style="font-weight:bolder;font-size:1.8rem;">${count}. ${vo.quesName}</caption>
                            <tbody>
                            <tr>
                                <td><input type="radio" class="choice" name="multipleVal[${index}]" value="1"/>아주 나쁨</td>
                                <td><input type="radio" class="choice" name="multipleVal[${index}]" value="2"/>나쁨</td>
                                <td><input type="radio" class="choice" name="multipleVal[${index}]" value="3"/>보통</td>
                                <td><input type="radio" class="choice" name="multipleVal[${index}]" value="4"/>좋음</td>
                                <td><input type="radio" class="choice" name="multipleVal[${index}]" value="5"/>아주 좋음</td>
                            </tr>
                            </tbody>
                        </table>
                        <div class="str" name="quesNo" id="strNo" value="${vo.quesNo}">
                            <h4 style="font-weight: normal;" id="reasonHeader" name="voQuesNO">사유를 작성해 주세요(필수).</h4>
                            <textarea class="form-control" id="dissatisReason" name="dissatisReason[${index}]" id="reason" type="text" style="width: 600px; height:80px;margin-bottom: 30px;" value=""></textarea>
                        </div>
                    </c:if>
                    <c:if test="${vo.type eq 2 }">
                        <table class="table" style="margin-bottom: 35px;">
                            <caption style="font-weight:bolder;font-size:1.8rem;">${count}. ${vo.quesName}</caption>
                            <tbody>
                            <tr>
                                <td><textarea class="form-control" type="text" id="answer" name="answer[${index}]" style="width: 90%; height:100px;"></textarea></td>
                            </tr>
                            </tbody>
                        </table>
                    </c:if>
                    <c:set var="index" value="${index + 1}"/>
                    </div>
                </c:forEach>
            </div>
        </form>
    </div>
</div>
<div style="text-align: center; padding-top: 10px;margin-bottom: 5%;">
    <input type="button" id="surveyAdd" class="btn btn-lg btn-warning" value="제출하기">
</div>


<script src="/assets/js/ie10-viewport-bug-workaround.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $(".str").hide();
    });

    $('.choice').click(function () {
        if ($(this).val() >= 3) {
            $(this).closest(".quesArea").find(".str").hide();
        } else {
            $(this).closest(".quesArea").find(".str").show();
        }
    });

    $("#surveyAdd").click(function () {
        var quesName = new Array();
        var type = new Array();
        var answer = new Array();
        var multipleVal = new Array();
        var dissatisReason = new Array();

        $(".quesName").each(function (i, e) {
            quesName.push($(this).val());
            type.push($(this).closest(".quesArea").find(".type").val());
            answer.push($(this).closest(".quesArea").find("#answer").val());
            if (typeof $(this).closest(".quesArea").find(".choice:checked").val() != undefined) {
                multipleVal.push($(this).closest(".quesArea").find(".choice:checked").val());
            } else {
                multipleVal.push(null);
            }
            if ($(this).closest(".quesArea").find("#dissatisReason").val() != "") {
                dissatisReason.push($(this).closest(".quesArea").find("#dissatisReason").val());
            } else {
                dissatisReason.push(null);
            }

        });

        var report = {
            quesFormGroupNo : $("#quesFormGroupNo").val(),
            cateName: $("#cateName").val(),
            manager: $("#manager").val(),
            companyNo: $("#selectCompany").val(),
            quesName: quesName,
            type: type,
            multipleVal: multipleVal,
            dissatisReason: dissatisReason,
            answer: answer
        };

        $.ajax({
            url: '/survey/surveyAdd',
            type: "post",
            data: JSON.stringify(report),
            contentType: 'application/json',
            success: function (result) {
                if(result==1){
                    console.log(result);
                    console.log("ajax 저장완료!");
                    surveyEnd();

                }
            }
        });

    });

    function formSubmit() {

        console.log("새로운 스크립트");

        //var report = $("#formname1").serializeObject();

        jQuery.fn.serializeObject = function () {
            var obj = null;
            try {
                if (this[0].tagName && this[0].tagName.toUpperCase() == "FORM") {
                    var arr = this.serializeArray();
                    if (arr) {
                        obj = {};
                        jQuery.each(arr, function () {
                            obj[this.name] = this.value;
                        });
                    }//if ( arr ) {
                }
            } catch (e) {
                alert(e.message);
            } finally {
            }

            return obj;
        };

        var report = $("#formname1").serializeObject();
        console.log(report);

        $.ajax({
            url: '/survey/surveyAdd',
            type: "post",
            data: report,
            dataType: 'jason',
            success: function (result) {
					if(result==1){
					console.log(result);
	                console.log("ajax 저장완료!");
	                surveyEnd();

					}
           		 }
       	 });

    }

    function surveyEnd() {

        location.href = "/survey/thanks"
    }

</script>
<%@ include file="./bottom.jsp" %>