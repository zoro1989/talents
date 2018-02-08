Imports System
Imports System.Collections.Generic
Imports System.Data
Imports System.Data.Entity
Imports System.Linq
Imports System.Web
Imports System.Web.Mvc

<Authorize(Roles:="Administrator")>
Public Class StoreManagerController
    Inherits Controller
    Private db As New MusicStoreEntities

    '
    ' GET: /StoreManager/

    Public Function Index() As ViewResult
        Dim albums = db.Albums.Include(Function(a) a.Genre).Include(Function(a) a.Artist)
        Return View(albums.ToList())
    End Function

    '
    ' GET: /StoreManager/Details/5

    Public Function Details(ByVal id As Integer) As ViewResult
        Dim album = db.Albums.Find(id)
        Return View(album)
    End Function

    '
    ' GET: /StoreManager/Create

    Public Function Create() As ActionResult
        ViewBag.GenreId = New SelectList(db.Genres, "GenreId", "Name")
        ViewBag.ArtistId = New SelectList(db.Artists, "ArtistId", "Name")
        Return View()
    End Function

    '
    ' POST: /StoreManager/Create

    <HttpPost()>
    Public Function Create(ByVal album As Album) As ActionResult
        If ModelState.IsValid Then
            db.Albums.Add(album)
            db.SaveChanges()
            Return RedirectToAction("Index")
        End If

        ViewBag.GenreId = New SelectList(db.Genres, "GenreId", "Name", album.GenreId)
        ViewBag.ArtistId = New SelectList(db.Artists, "ArtistId", "Name", album.ArtistId)
        Return View(album)
    End Function

    '
    ' GET: /StoreManager/Edit/5

    Public Function Edit(ByVal id As Integer) As ActionResult
        Dim album = db.Albums.Find(id)
        ViewBag.GenreId = New SelectList(db.Genres, "GenreId", "Name", album.GenreId)
        ViewBag.ArtistId = New SelectList(db.Artists, "ArtistId", "Name", album.ArtistId)
        Return View(album)
    End Function

    '
    ' POST: /StoreManager/Edit/5

    <HttpPost()>
    Public Function Edit(ByVal album As Album) As ActionResult
        If ModelState.IsValid Then
            db.Entry(album).State = EntityState.Modified
            db.SaveChanges()
            Return RedirectToAction("Index")
        End If
        ViewBag.GenreId = New SelectList(db.Genres, "GenreId", "Name", album.GenreId)
        ViewBag.ArtistId = New SelectList(db.Artists, "ArtistId", "Name", album.ArtistId)
        Return View(album)
    End Function

    '
    ' GET: /StoreManager/Delete/5

    Public Function Delete(ByVal id As Integer) As ActionResult
        Dim album = db.Albums.Find(id)
        Return View(album)
    End Function

    '
    ' POST: /StoreManager/Delete/5

    <HttpPost(), ActionName("Delete")>
    Public Function DeleteConfirmed(ByVal id As Integer) As ActionResult
        Dim album = db.Albums.Find(id)
        db.Albums.Remove(album)
        db.SaveChanges()
        Return RedirectToAction("Index")
    End Function

    Protected Overloads Overrides Sub Dispose(ByVal disposing As Boolean)
        db.Dispose()
        MyBase.Dispose(disposing)
    End Sub
End Class