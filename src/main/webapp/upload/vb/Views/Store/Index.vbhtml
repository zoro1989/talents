@modeltype IEnumerable(Of MvcMusicStore.Genre)
@Code
    ViewData("Title") = "Index"
End Code

<h3>Browse Genres</h3>

<p>
    Select from @Model.Count() genres:</p>
<ul>
    @For Each genre In Model
    
        @<li>@Html.ActionLink(genre.Name, "Browse", New With {Key .genre = genre.Name})</li>
    Next genre
</ul>
