@modeltype IEnumerable(Of MvcMusicStore.Genre)

@Code
    ViewData("Title") = "GenreMenu"
End Code

<ul id="categories">
    @For Each genre In Model
    
        @<li>@Html.ActionLink(genre.Name,
                "Browse", "Store",
                New With {Key .Genre = genre.Name}, Nothing)
        </li>
    Next genre
</ul>