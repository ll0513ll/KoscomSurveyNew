<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="./top.jsp" %>
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
	<div class="modal-content">
	  <div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		<h4 class="modal-title" id="myModalLabel">참여 설문 내용 상세보기.</h4>
	  </div>
	  <div class="modal-body">
			<div class="col-lg">
				<div style = "width: 100%; height:150px; background-color: #eee;margin-bottom: 30px;">
					<div style = "margin-top: 20px;margin-bottom: 20px;margin-left: 10%;padding-top: 55px;border-top-width: 30px;">
						 <table  style="width: 500px;float:left;">
							<tr>
								<th style = "font-size:1.5rem;width: 80px;color: inherit;">증권사 : </th>
								<td id = "cliName" style = "font-size:3rem;"></td>
								<th style = "font-size:1.5rem;width: 80px;">담당자 : </th>
								<td id = "cliManager" style = "font-size:3rem;color: inherit;"></td>
							</tr>
						 </table>
					</div>
				</div>
				<h4>문의요청시 응대가 빨랐나요?</h4>
				<table class="table" style="margin-bottom: 35px;">
					<tbody>
						<tr>
							<td><input type="radio" name="multiple" value="1" />아주 나쁨</td>
							<td><input type="radio" name="multiple" value="2" />나쁨</td>
							<td><input type="radio" name="multiple" value="3" />보통</td>
							<td><input type="radio" name="multiple" value="4" />좋음</td>
							<td><input type="radio" name="multiple" value="5" />아주 좋음</td>
						</tr>
					</tbody>
				</table>

			  <h4>직원은 친절하게 응대했나요?</h4>
			  <table class="table" style="margin-bottom: 35px;">
					<tbody>
						<tr>
							<td><input type="radio" name="multiple" value="1" />아주 나쁨</td>
							<td><input type="radio" name="multiple" value="2" />나쁨</td>
							<td><input type="radio" name="multiple" value="3" />보통</td>
							<td><input type="radio" name="multiple" value="4" />좋음</td>
							<td><input type="radio" name="multiple" value="5" />아주 좋음</td>
						</tr>
					</tbody>
				</table>

			  <h4>응대받은 내용이 도움이 되었나요?</h4>
			 <table class="table" style="margin-bottom: 35px;">
					<tbody>
						<tr>
							<td><input type="radio" name="multiple" value="1" />아주 나쁨</td>
							<td><input type="radio" name="multiple" value="2" />나쁨</td>
							<td><input type="radio" name="multiple" value="3" />보통</td>
							<td><input type="radio" name="multiple" value="4" />좋음</td>
							<td><input type="radio" name="multiple" value="5" />아주 좋음</td>
						</tr>
					</tbody>
				</table>

			  <h4>다시 같은 직원에게 업무요청을 하고싶은가요?</h4>
			  <table class="table" style="margin-bottom: 35px;">
					<tbody>
						<tr>
							<td><input type="radio" name="multiple" value="1" />아주 나쁨</td>
							<td><input type="radio" name="multiple" value="2" />나쁨</td>
							<td><input type="radio" name="multiple" value="3" />보통</td>
							<td><input type="radio" name="multiple" value="4" />좋음</td>
							<td><input type="radio" name="multiple" value="5" />아주 좋음</td>
						</tr>
					</tbody>
				</table>

				<h4>문의요청시 응대가 빨랐나요?</h4>
				<table class="table" style="margin-bottom: 35px;">
					<tbody>
						<tr>
							<td><input type="radio" name="multiple" value="1" />아주 나쁨</td>
							<td><input type="radio" name="multiple" value="2" />나쁨</td>
							<td><input type="radio" name="multiple" value="3" />보통</td>
							<td><input type="radio" name="multiple" value="4" />좋음</td>
							<td><input type="radio" name="multiple" value="5" />아주 좋음</td>
						</tr>
					</tbody>
				</table>

				 <h4>직원은 친절하게 응대했나요?</h4>
			  <table class="table" style="margin-bottom: 35px;">
					<tbody>
						<tr>
							<td><input type="radio" name="multiple" value="1" />아주 나쁨</td>
							<td><input type="radio" name="multiple" value="2" />나쁨</td>
							<td><input type="radio" name="multiple" value="3" />보통</td>
							<td><input type="radio" name="multiple" value="4" />좋음</td>
							<td><input type="radio" name="multiple" value="5" />아주 좋음</td>
						</tr>
					</tbody>
				</table>

				 <h4>응대받은 내용이 도움이 되었나요?</h4>
			 <table class="table" style="margin-bottom: 35px;">
					<tbody>
						<tr>
							<td><input type="radio" name="multiple" value="1" />아주 나쁨</td>
							<td><input type="radio" name="multiple" value="2" />나쁨</td>
							<td><input type="radio" name="multiple" value="3" />보통</td>
							<td><input type="radio" name="multiple" value="4" />좋음</td>
							<td><input type="radio" name="multiple" value="5" />아주 좋음</td>
						</tr>
					</tbody>
				</table>

			  <h4>다시 같은 직원에게 업무요청을 하고싶은가요?</h4>
			  <table class="table" style="margin-bottom: 35px;">
					<tbody>
						<tr>
							<td><input type="radio" name="multiple" value="1" />아주 나쁨</td>
							<td><input type="radio" name="multiple" value="2" />나쁨</td>
							<td><input type="radio" name="multiple" value="3" />보통</td>
							<td><input type="radio" name="multiple" value="4" />좋음</td>
							<td><input type="radio" name="multiple" value="5" />아주 좋음</td>
						</tr>
					</tbody>
				</table>

			  <h4>하고싶은 말이 있나요?</h4>
			  <p><textarea class="form-control" type="text" style = "width: 90%; height:100px;"></textarea>
		  </div>
	  </div>
	  <div class="modal-footer">
		<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		<!-- <button type="button" class="btn btn-primary">Save changes</button> -->
	  </div>
	</div>
  </div>
</div>  <!-- Modal -->

	  <div class="jumbotron">
		<div class="selectCate" style="margin-bottom: 3%;">
            <label style="font-size:1.5em;">설문조사 선택</label>
            <select class="form-control" id="selectCate" name="selectCate">
                <c:forEach var="surveyList" items="${surveyList}" varStatus="status">
                    <option value="${surveyList.surveyGroupNo}">${surveyList.cateName}</option>
                </c:forEach>
            </select>
        </div>
			<p></p>
		<div style = "text-align: center; padding-top: 10px;">
			<button class="btn btn-warning" id="getSurvey" role="button">확인하기</button>
		</div>
	  </div>
		 <div class="row marketing">
			<p ><h3 style="margin-bottom: 3%;">참여 증권사 리스트</h3></p>
			<table class="table table-bordered">
			  <thead>
				<tr>
					<th colspan="6" style="text-align:center;font-size:2rem;" id="selectSurvey"></th>
				 </tr>
				<tr>
				  <th></th>
				  <th>증권사 명</th>
				  <th>제출 일</th>
				  <th>담당자</th>
				  <th>만족도 지수</th>
				</tr>
			  </thead>
			  <tbody id="finshTbody">
				 
			  </tbody>
			</table>

			 <div class = "buttonBox" style="margin-left: 45%;margin-top:5%;margin-bottom: 5%;">

			<!-- <button type="button"  onclick="location.href='/master/survey_del'"  class="btn btn-default" style="width:80px;">삭제</button> -->
			 </div>
	  </div>


<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="/assets/js/ie10-viewport-bug-workaround.js"></script>
<script type="text/javascript">
  $(document).ready(function () {
	
	var surveyTop = $("#selectCate option:selected").text();
	$("#selectSurvey").text(surveyTop);
	
	selectSurveyList();

	  $(document).on("click",".myModal",function(){

		  $.ajax({
			  url: "/surveyManage/getResultSurvey",
			  type: "post",
			  data: JSON.stringify({"surveyNo": $(this).parent().children("[name=surveyGroupNo]").val(), "companyNo": $(this).parent().children("[name=companyNo]").val()}),
			  dataType: "json",
			  contentType: 'application/json',
			  success: function (survey) {
			  	
			  	var modalData = "<div class=\"col-lg\">" +
						"<div style = \"width: 100%; height:150px; background-color: #eee;margin-bottom: 30px;\">" +
						"<div style = \"margin-top: 20px;margin-bottom: 20px;margin-left: 10%;padding-top: 55px;border-top-width: 30px;\">" +
						"<table  style=\"width: 500px;float:left;\">" +
						"<tr>" +
						"<th style = \"font-size:1.5rem;width: 80px;color: inherit;\">증권사 : " + survey[0].companyName + "</th>" +
						"<td id = \"cliName\" style = \"font-size:3rem;\"></td>" +
						"<th style = \"font-size:1.5rem;width: 80px;\">담당자 : " + survey[0].manager + "</th>" +
						"<td id = \"cliManager\" style = \"font-size:3rem;color: inherit;\"></td>" +
						"</tr>\n" +
						"</table>\n" +
						"</div>\n" +
						"</div>";
			  	
				$.each(survey, function(i,o) {
					console.log(o);

					if (o.type == 1) {
						modalData += "<h4>" + o.quesName + "</h4>" +
								"<table class=\"table\" style=\"margin-bottom: 35px;\">" +
								"<tbody>" +
								"<tr>" +
								"<td><input type=\"radio\" value=\"1\" " + (o.satisVal==1?"checked":"") + "/>아주 나쁨</td>" +
								"<td><input type=\"radio\" value=\"2\" " + (o.satisVal==2?"checked":"") + "/>나쁨</td>" +
								"<td><input type=\"radio\" value=\"3\" " + (o.satisVal==3?"checked":"") + "/>보통</td>" +
								"<td><input type=\"radio\" value=\"4\" " + (o.satisVal==4?"checked":"") + "/>좋음</td>" +
								"<td><input type=\"radio\" value=\"5\" " + (o.satisVal==5?"checked":"") + "/>아주 좋음</td>" +
								"</tr>" +
								"</tbody>" +
								"</table>";
						if (o.satisVal < 3) {
							modalData += "<p><textarea class=\"form-control\" type=\"text\" style = \"width: 90%; height:100px;\">" +
									o.dissatisReason +
									"</textarea></p>";
						}
					} else {
						modalData += "<h4>" + o.quesName + "</h4>" +
								"<p><textarea class=\"form-control\" type=\"text\" style = \"width: 90%; height:100px;\">" +
								o.answer +
								"</textarea></p>";
					}
					
				});
				  modalData += "</div>";
				$(".modal-body").html(modalData);
				$("#myModal").modal();
			  },
			  error: function (request, status, error) {
				  alert("code:" + request.status + "\n" + "message:" +
						  request.responseText + "\n" + "error:" + error);
			  }

		  });
	  });
	
  });
  
  $("#getSurvey").on('click',function () {
	  
	  selectSurveyList();
	  
  });
  
  //선택된 설문조사 완료 설문 가져오기
  function selectSurveyList(){
	  
	  var surveyNo = $("#selectCate option:selected").val();
	  console.log($("#selectCate option:selected").val());
	  
	  $.ajax({
          url: "/surveyManage/getSelectSurvey",
          type: "post",
          data: {"surveyNo": surveyNo},
          dataType: "json",
          success: function (result) {
              console.log(result);
              $("#finshTbody").empty();
              $("#selectSurvey").text("");
              $("#selectSurvey").text(result[0].cateName);
             
              for(var i = 0; i < result.length; i++){
            	  
 	             finshSurveyList(result[i]);
            	  
              }
              

          },
          error: function (request, status, error) {
              alert("code:" + request.status + "\n" + "message:" +
                  request.responseText + "\n" + "error:" + error);
          }

      })  
	  
  }
  var index = 1;
//확인하기 버튼처리 후 아래 내역 그리기.
  function finshSurveyList(result){
  	console.log(result);
  	var str1 = "<tr>"
			 + "<input type='hidden' name='surveyGroupNo' value='"+ result.surveyGroupNo +"'>"
			 + "<input type='hidden' name='companyNo' value='"+ result.companyNo +"'>"
          	 +	"<th scope='row' style='text-align:center;'>" + index++ + "</th>"
          	 +	"<td class='myModal' name='cliName' style='cursor:pointer;'>"+ result.companyName +"</td>"
          	 +	"<td>"+ result.surveyDate +"</td>"
          	 +	"<td name='cliManager'>"+ result.manager +"</td>"
          	 +	"<td>" + result.satisfaction + "%</td>"
          	 +	"</tr>";
  			
          	 $("#finshTbody").append(str1);
  		
  }
</script>

<%@ include file="./bottom.jsp" %>