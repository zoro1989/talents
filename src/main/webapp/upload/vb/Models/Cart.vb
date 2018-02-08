Imports System.ComponentModel.DataAnnotations

Public Class Cart
    <Key()>
    Public Property RecordId As Integer
    Public Property CartId As String
    Public Property AlbumId As Integer
    Public Property Count As Integer
    Public Property DateCreated As Date

    Public Overridable Property Album As Album
End Class