@modeltype MvcMusicStore.Genre
@Code
    ViewData("Title") = "Browse"
End Code

<div class="genre">
    <h3><em>@Model.Name</em> Albums</h3>
 
    <ul id="album-list">
        @For Each album In Model.Albums
        
           @<li>
                <a href="@Url.Action("Details", New With {Key .id = album.AlbumId})">
                    <img alt="@album.Title" src="@album.AlbumArtUrl" />
                    <span>@album.Title</span>
                </a>
            </li>
        Next album
    </ul>
</div>
