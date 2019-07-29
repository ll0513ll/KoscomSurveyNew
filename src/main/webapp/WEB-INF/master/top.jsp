<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>설문조사 편집</title>

    <!-- Bootstrap core CSS -->
    <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/css/jumbotron-narrow.css" rel="stylesheet">

    <!-- sidebar styles for this template -->
    <link href="/css/dashboard.css" rel="stylesheet">
    
    <link href="/css/style.css" rel="stylesheet">


    <script src="/assets/js/ie-emulation-modes-warning.js"></script>
    <script src="/assets/js/jquery.min.js"></script>
    <script src="/assets/js/widgets.js"></script>
    <script src="/bootstrap/js/bootstrap.min.js"></script>

</head>

<body>

<div class="container" style="margin-top:30px;">
    <div class="navbar navbar-inverse navbar-fixed-top" style="background-color: white;">
        <nav>
            <ul class="nav nav-pills pull-right" style=" margin-right: 330px;">
                <li role="presentation" class="active" style="margin-top: 20px;"><a href="/cateEdit/">Edit</a></li>
                <li role="presentation" style="margin-top: 20px;"><a href="/survey/">Survey</a></li>
            </ul>
        </nav>
        <h4 class="text-muted">
            <img src="/assets/images/KoscomLogo.PNG"
                 style="width: 14rem; height: 4rem;flot:left;margin-bottom: 1%;">
            설문조사 편집
        </h4>
    </div>
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar" style="margin-top:30px;">
            <ul class="nav nav-sidebar">
                <li><a href="/cateEdit/">카테고리 편집 <span class="sr-only">(current)</span></a></li>
                <li class="active"><a href="/quesEdit/quesList">질문 편집</a></li>
                <li><a href="/master/surveyManage">설문조사 관리</a></li>
            </ul>
        </div>