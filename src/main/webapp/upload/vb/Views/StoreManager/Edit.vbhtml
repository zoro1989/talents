@modeltype MvcMusicStore.Album
@Code
    ViewData("Title") = "Edit"
End Code

<h2>Edit</h2>

<script src="@Url.Content("~/Scripts/jquery.validate.min.js")" type="text/javascript"></script>
<script src="@Url.Content("~/Scripts/jquery.validate.unobtrusive.min.js")" type="text/javascript"></script>

@Using Html.BeginForm()
    @Html.ValidationSummary(true)
    @<fieldset>
        <legend>Album</legend>

        @Html.HiddenFor(Function(model) model.AlbumId)

        <div class="editor-label">
            @Html.LabelFor(Function(model) model.GenreId, "Genre")
        </div>
        <div class="editor-field">
            @Html.DropDownList("GenreId", String.Empty)
            @Html.ValidationMessageFor(Function(model) model.GenreId)
        </div>

        <div class="editor-label">
            @Html.LabelFor(Function(model) model.ArtistId, "Artist")
        </div>
        <div class="editor-field">
            @Html.DropDownList("ArtistId", String.Empty)
            @Html.ValidationMessageFor(Function(model) model.ArtistId)
        </div>

        <div class="editor-label">
            @Html.LabelFor(Function(model) model.Title)
        </div>
        <div class="editor-field">
            @Html.EditorFor(Function(model) model.Title)
            @Html.ValidationMessageFor(Function(model) model.Title)
        </div>

        <div class="editor-label">
            @Html.LabelFor(Function(model) model.Price)
        </div>
        <div class="editor-field">
            @Html.EditorFor(Function(model) model.Price)
            @Html.ValidationMessageFor(Function(model) model.Price)
        </div>

        <div class="editor-label">
            @Html.LabelFor(Function(model) model.AlbumArtUrl)
        </div>
        <div class="editor-field">
            @Html.EditorFor(Function(model) model.AlbumArtUrl)
            @Html.ValidationMessageFor(Function(model) model.AlbumArtUrl)
        </div>

        <p>
            <input type="submit" value="Save" />
        </p>
    </fieldset>
End Using

<div>
    @Html.ActionLink("Back to List", "Index")
</div>

