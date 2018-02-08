﻿@modeltype MvcMusicStore.Order
@Code
    ViewData("Title") = "AddressAndPayment"
End Code

<script src="@Url.Content("~/Scripts/jquery.validate.min.js")" type="text/javascript"></script>
<script src="@Url.Content("~/Scripts/jquery.validate.unobtrusive.min.js")" type="text/javascript"></script>

@Using Html.BeginForm()
    
    @<h2>Address And Payment</h2>
    @<fieldset>
        <legend>Shipping Information</legend>

        @Html.EditorForModel()
    </fieldset>
    @<fieldset>
        <legend>Payment</legend>
        <p>We're running a promotion: all music is free with the promo code: "FREE"</p>

        <div class="editor-label">
            @Html.Label("Promo Code")
        </div>
        <div class="editor-field">
            @Html.TextBox("PromoCode")
        </div>
    </fieldset>
    
    @<input type="submit" value="Submit Order" />
End Using