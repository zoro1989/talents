Public Class StoreController
    Inherits Controller
    Private storeDB As New MusicStoreEntities

    '
    ' GET: /Store/

    Public Function Index() As ActionResult
        Dim genres = storeDB.Genres.ToList()

        Return View(genres)
    End Function

    '
    ' GET: /Store/Browse?genre=Disco

    Public Function Browse(ByVal genre As String) As ActionResult
        ' Retrieve Genre and its Associated Albums from database
        Dim genreModel = storeDB.Genres.Include("Albums").Single(Function(g) g.Name = genre)

        Return View(genreModel)
    End Function

    '
    ' GET: /Store/Details/5

    Public Function Details(ByVal id As Integer) As ActionResult
        Dim album = storeDB.Albums.Find(id)

        Return View(album)
    End Function

    '
    ' GET: /Store/GenreMenu

    <ChildActionOnly()>
    Public Function GenreMenu() As ActionResult
        Dim genres = storeDB.Genres.ToList()

        Return PartialView(genres)
    End Function

End Class