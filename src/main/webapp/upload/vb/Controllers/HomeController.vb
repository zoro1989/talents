Public Class HomeController
    Inherits Controller
    '
    ' GET: /Home/

    Private storeDB As New MusicStoreEntities

    Public Function Index() As ActionResult
        ' Get most popular albums
        Dim albums = GetTopSellingAlbums(5)

        Return View(albums)
    End Function

    Private Function GetTopSellingAlbums(ByVal count As Integer) As List(Of Album)
        ' Group the order details by album and return
        ' the albums with the highest count

        Return storeDB.Albums.OrderByDescending(Function(a) a.OrderDetails.Count()).Take(count).ToList()
    End Function
End Class