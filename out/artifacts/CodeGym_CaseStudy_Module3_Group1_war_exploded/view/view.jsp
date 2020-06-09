
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 6/8/2020
  Time: 9:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Tạo Layout Trang Web</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="StyleLayout.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    <style>
        header{
            position: relative;
        }
        .shopping-mall{
            margin-top: auto;
            font-variant: small-caps;
        }
        .shopping-mall h1{
            font-family: Impact;
            font-size: 50px;
            color: white;
            letter-spacing: 0.3px;
            text-shadow: 0 0 2px black;
            padding-bottom:0px;
            border-bottom: 1px dotted gray;
            margin: 0px;
            width: 49%;
        }

        .shopping-mall h5{
            margin-top: 5px;
            letter-spacing: 0.5px;
            font-size: small;
        }
        .poly-cart{
            margin-top: 5px;
        }
        .panel{
            border: 1px solid #dddddd;
            margin-bottom: 20px;
            background-color: #ffffff;
            border-radius: 4px;
        }
        .poly-cart ul{
            margin: auto;
            padding: 0px;
            list-style: none;
            font-variant: small-caps;
        }
        *{
            box-sizing: border-box;
        }
    </style>
</head>
<body>
<div class="container" style="height: auto">
    <header class="row">
        <div class="col-sm-8 shopping-mall">
            <h1>Online shopping mall</h1>
            <h5>The center point of the professional programming</h5>
        </div>
        <img class="col-sm-4" src="https://demo.codegym.vn/web/15/layout-bootstrap/images/header-object.png" alt="Logo"/>
    </header>


    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">
                        <i class="fas fa-home"></i> Trang chủ<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"><i class="fas fa-list-alt"></i> Giới thiệu</a>
                </li>
                <li class="nav-item">
                    <a href="#" class="nav-link"><i class="fas fa-phone"></i> Liên Hệ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"><i class="fa fa-envelope"></i> Góp Ý</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"><i class="fa fa-question"></i> Hỏi Đáp</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-user"></i> Tài Khoản
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="#">Action</a>
                        <a class="dropdown-item" href="#">Another action</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#">Something else here</a>
                    </div>
            </ul>
            <ul class="navbar navbar-nav navbar-right">
                <li class="nav-item">
                    <a class="nav-link" href="#">Đăng Nhập</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Đăng Xuất</a>
                </li>
            </ul>
        </div>
    </nav>




    <div class="row">
        <article class="col-sm-9">
        </article>


        <article class="col-sm-3">
            <div class="poly-cart">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <img src="https://demo.codegym.vn/web/15/layout-bootstrap/images/shoppingcart.gif"
                             class="col-sm-6"/>
                        <ul class="col-sm-6">
                            <li>100 items</li>
                            <li>$56.8</li>
                            <li><a href="#">Xem Giỏ Hàng</a> </li>
                        </ul>
                    </div>
                </div>
                <div class="card card-default">
                    <div class="card-body">
                        <form>
                            <input class="form-control" placeholder="Keywords">
                        </form>
                    </div>
                </div>
                <div class="card-header">
                    <i class="fas fa-th-list"></i>
                    <strong>Chủng Loại</strong>
                </div>
                <div class="list-group">
                    <a href="#" class="list-group-item">Điện Thoại Di Động</a>
                    <a href="#" class="list-group-item">Máy Tính Xách Tay</a>
                    <a href="#" class="list-group-item">Máy Tính Để Bàn</a>
                    <a href="#" class="list-group-item">Quạt Máy</a>
                    <a href="#" class="list-group-item">Tivi</a>
                    <a href="#" class="list-group-item">Tủ Lạnh</a>
                </div>
            </div>
        </article>
    </div>
    <footer class="card">
        <div class="card-header text-center">
            <p>CodeGym &copy; 2017</p>
        </div>
    </footer>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>

