﻿@modeltype MvcMusicStore.Album
@Code
    ViewData("Title") = "Details"
End Code

<h2>@Model.Title</h2>

<p>
    <img alt="@Model.Title" src="@Model.AlbumArtUrl" />
</p>

<div id="album-details">
    <p>
        <em>Genre:</em>
        @Model.Genre.Name
    </p>
    <p>
        <em>Artist:</em>
        @Model.Artist.Name
    </p>
    <p>
        <em>Price:</em>
        @String.Format("{0:F}", Model.Price)
    </p>
    <p class="button">
        @Html.ActionLink("Add to cart", "AddToCart",
        "ShoppingCart", New With {Key .id = Model.AlbumId}, "")
    </p>
</div>
