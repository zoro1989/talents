@modeltype List(Of MvcMusicStore.Album)
@Code
    ViewData("Title") = "ASP.NET MVC Music Store"
End Code

<div id="promotion">
</div>

<h3><em>Fresh</em> off the grill</h3>

<ul id="album-list">
    @For Each album In Model
    
        @<li><a href="@Url.Action("Details", "Store",
                New With {Key .id = album.AlbumId})">

            <img alt="@album.Title" src="@album.AlbumArtUrl" />
            <span>@album.Title</span> </a>
        </li>
    Next album
</ul>
