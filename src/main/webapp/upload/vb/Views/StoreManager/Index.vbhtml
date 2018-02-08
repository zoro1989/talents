@modeltype IEnumerable(Of MvcMusicStore.Album)
@helper Truncate(input,length)

If Input.Length <= length Then
        @Input()
Else
        @input.Substring(0, length)@<text>...</text>
    End If
End helper

@Code
    ViewBag.Title = "Index"
End Code

<h2>Index</h2>

<p>
    @Html.ActionLink("Create New", "Create")
</p>
<table>
    <tr>
        <th>
            Genre
        </th>
        <th>
            Artist
        </th>
        <th>
            Title
        </th>
        <th>
            Price
        </th>
        <th></th>
    </tr>

@For Each item In Model
    @<tr>
        <td>
            @Html.DisplayFor(Function(modelItem) item.Genre.Name)
        </td>
        <td>
            @Truncate(item.Artist.Name, 25)
        </td>
        <td>
            @Truncate(item.Title, 25)
        </td>
        <td>
            @Html.DisplayFor(Function(modelItem) item.Price)
        </td>
        <td>
            @Html.ActionLink("Edit", "Edit", New With {Key .id = item.AlbumId}) |
            @Html.ActionLink("Details", "Details", New With {Key .id = item.AlbumId}) |
            @Html.ActionLink("Delete", "Delete", New With {Key .id = item.AlbumId})
        </td>
    </tr>
Next item

</table>