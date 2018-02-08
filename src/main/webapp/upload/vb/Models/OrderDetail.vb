Public Class OrderDetail
    Public Property OrderDetailId As Integer
    Public Property OrderId As Integer
    Public Property AlbumId As Integer
    Public Property Quantity As Integer
    Public Property UnitPrice As Decimal

    Public Overridable Property Album As Album
    Public Overridable Property Order As Order
End Class