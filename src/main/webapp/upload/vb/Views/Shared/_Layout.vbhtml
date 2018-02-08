﻿<!DOCTYPE html>
<html>
<head>
    <title>@ViewBag.Title</title>
    <link href="@Url.Content("~/Content/Site.css")" rel="stylesheet" 
        type="text/css" />
    <script src="@Url.Content("~/Scripts/jquery-1.5.1.min.js")" 
        type="text/javascript"></script>
</head>
<body>
    <div id="header">
        <h1><a href="/">ASP.NET MVC MUSIC STORE</a></h1>
        <ul id="navlist">
            <li class="first"><a href="@Url.Content("~")" id="current">Home</a></li>
            <li><a href="@Url.Content("~/Store/")">Store</a></li>
            <li>@Code Html.RenderAction("CartSummary", "ShoppingCart")
            End Code </li>
            <li><a href="@Url.Content("~/StoreManager/")">Admin</a></li>
        </ul>        
    </div>

    @Code
    Html.RenderAction("GenreMenu", "Store")
    End code
    <div id="main">
        @RenderBody()
    </div>

    <div id="footer">
        built with <a href="http://asp.net/mvc">ASP.NET MVC 3</a>
    </div>
</body>
</html>