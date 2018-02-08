﻿@modeltype integer
@Code
    ViewData("Title") = "Checkout Complete"
End Code

<h2>Checkout Complete</h2>

<p>Thanks for your order! Your order number is: @Model</p>

<p>How about shopping for some more music in our 
    @Html.ActionLink("store", "Index", "Home")
</p>
