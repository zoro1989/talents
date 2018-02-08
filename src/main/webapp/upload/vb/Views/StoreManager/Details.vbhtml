@modeltype MvcMusicStore.Album

@Code
    ViewData("Title") = "Details"
End Code

<h2>Details</h2>

<fieldset>
    <legend>Album</legend>

    <div class="display-label">Genre</div>
    <div class="display-field">
        @Html.DisplayFor(Function(model) model.Genre.Name)
    </div>

    <div class="display-label">Artist</div>
    <div class="display-field">
        @Html.DisplayFor(Function(model) model.Artist.Name)
    </div>

    <div class="display-label">Title</div>
    <div class="display-field">
        @Html.DisplayFor(Function(model) model.Title)
    </div>

    <div class="display-label">Price</div>
    <div class="display-field">
        @Html.DisplayFor(Function(model) model.Price)
    </div>

    <div class="display-label">AlbumArtUrl</div>
    <div class="display-field">
        @Html.DisplayFor(Function(model) model.AlbumArtUrl)
    </div>
</fieldset>
<p>
    @Html.ActionLink("Edit", "Edit", New With {Key .id = Model.AlbumId}) |
    @Html.ActionLink("Back to List", "Index")
</p>

