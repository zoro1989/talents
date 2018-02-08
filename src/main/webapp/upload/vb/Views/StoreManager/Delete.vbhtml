@modeltype MvcMusicStore.Album

@Code
    ViewData("Title") = "Delete"
End Code

<h2>Delete Confirmation</h2>

<p>Are you sure you want to delete the album titled 
   <strong>@Model.Title</strong>?
</p>

@Using Html.BeginForm()
    @<p>
        <input type="submit" value="Delete" />
    </p>
    @<p>
        @Html.ActionLink("Back to List", "Index")
    </p>

End Using
