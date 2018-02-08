Imports System.ComponentModel
Imports System.ComponentModel.DataAnnotations
Imports System.Web.Mvc
Imports System.Collections.Generic

<Bind(Exclude:="AlbumId")>
Public Class Album
    <ScaffoldColumn(False)>
    Public Property AlbumId As Integer

    <DisplayName("Genre")>
    Public Property GenreId As Integer

    <DisplayName("Artist")>
    Public Property ArtistId As Integer

    <Required(ErrorMessage:="An Album Title is required"),
    StringLength(160)>
    Public Property Title As String

    <Required(ErrorMessage:="Price is required"),
    Range(0.01, 100.0, ErrorMessage:="Price must be between 0.01 and 100.00")>
    Public Property Price As Decimal

    <DisplayName("Album Art URL"),
    StringLength(1024)>
    Public Property AlbumArtUrl As String

    Public Overridable Property Genre As Genre
    Public Overridable Property Artist As Artist
    Public Overridable Property OrderDetails As List(Of OrderDetail)
End Class