Imports System.Data.Entity
Public Class MusicStoreEntities
    Inherits DbContext
    Public Property Albums As DbSet(Of Album)
    Public Property Genres As DbSet(Of Genre)
    Public Property Artists As DbSet(Of Artist)
    Public Property Carts As DbSet(Of Cart)
    Public Property Orders As DbSet(Of Order)
    Public Property OrderDetails As DbSet(Of OrderDetail)
End Class