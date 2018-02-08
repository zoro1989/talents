Imports System
Imports System.Collections.Generic
Imports System.Linq
Imports System.Web
Imports System.Web.Mvc

Partial Public Class ShoppingCart
    Private storeDB As New MusicStoreEntities

    Private Property ShoppingCartId As String

    Public Const CartSessionKey As String = "CartId"

    Public Shared Function GetCart(ByVal context As HttpContextBase) As ShoppingCart
        Dim cart = New ShoppingCart
        cart.ShoppingCartId = cart.GetCartId(context)
        Return cart
    End Function

    ' Helper method to simplify shopping cart calls
    Public Shared Function GetCart(ByVal controller As Controller) As ShoppingCart
        Return GetCart(controller.HttpContext)
    End Function

    Public Sub AddToCart(ByVal album As Album)
        ' Get the matching cart and album instances
        Dim cartItem = storeDB.Carts.SingleOrDefault(Function(c) c.CartId = ShoppingCartId AndAlso
                                                         c.AlbumId = album.AlbumId)

        If cartItem Is Nothing Then
            ' Create a new cart item if no cart item exists
            cartItem = New Cart With
                       {.AlbumId = album.AlbumId,
                        .CartId = ShoppingCartId,
                        .Count = 1,
                        .DateCreated = Date.Now}

            storeDB.Carts.Add(cartItem)
        Else
            ' If the item does exist in the cart, then add one to the quantity
            cartItem.Count += 1
        End If

        ' Save changes
        storeDB.SaveChanges()
    End Sub

    Public Function RemoveFromCart(ByVal id As Integer) As Integer
        ' Get the cart
        Dim cartItem = storeDB.Carts.Single(
            Function(cart) cart.CartId = ShoppingCartId AndAlso cart.RecordId = id)

        Dim itemCount = 0

        If cartItem IsNot Nothing Then
            If cartItem.Count > 1 Then
                cartItem.Count -= 1
                itemCount = cartItem.Count
            Else
                storeDB.Carts.Remove(cartItem)
            End If

            ' Save changes
            storeDB.SaveChanges()
        End If

        Return itemCount
    End Function

    Public Sub EmptyCart()
        Dim cartItems = storeDB.Carts.Where(Function(cart) cart.CartId = ShoppingCartId)

        For Each cartItem In cartItems
            storeDB.Carts.Remove(cartItem)
        Next cartItem

        ' Save changes
        storeDB.SaveChanges()
    End Sub

    Public Function GetCartItems() As List(Of Cart)
        Return storeDB.Carts.Where(Function(cart) cart.CartId = ShoppingCartId).ToList()
    End Function

    Public Function GetCount() As Integer
        ' Get the count of each item in the cart and sum them up
        Dim count? = (
         From cartItems In storeDB.Carts
         Where cartItems.CartId = ShoppingCartId
         Select CType(cartItems.Count, Integer?)).Sum()

        ' Return 0 if all entries are null
        Return If(count, 0)
    End Function

    Public Function GetTotal() As Decimal
        ' Multiply album price by count of that album to get 
        ' the current price for each of those albums in the cart
        ' sum all album price totals to get the cart total
        Dim total? = (
         From cartItems In storeDB.Carts
         Where cartItems.CartId = ShoppingCartId
         Select CType(cartItems.Count, Integer?) * cartItems.Album.Price).Sum()
        Return If(total, Decimal.Zero)
    End Function

    Public Function CreateOrder(ByVal order As Order) As Integer
        Dim orderTotal = 0D

        Dim cartItems = GetCartItems()

        ' Iterate over the items in the cart, adding the order details for each
        For Each item In cartItems
            Dim orderDetail = New OrderDetail With
                              {.AlbumId = item.AlbumId,
                               .OrderId = order.OrderId,
                               .UnitPrice = item.Album.Price,
                               .Quantity = item.Count}

            ' Set the order total of the shopping cart
            orderTotal += (item.Count * item.Album.Price)

            storeDB.OrderDetails.Add(orderDetail)

        Next item

        ' Set the order's total to the orderTotal count
        order.Total = orderTotal

        ' Save the order
        storeDB.SaveChanges()

        ' Empty the shopping cart
        EmptyCart()

        ' Return the OrderId as the confirmation number
        Return order.OrderId
    End Function

    ' We're using HttpContextBase to allow access to cookies.
    Public Function GetCartId(ByVal context As HttpContextBase) As String
        If context.Session(CartSessionKey) Is Nothing Then
            If Not String.IsNullOrWhiteSpace(context.User.Identity.Name) Then
                context.Session(CartSessionKey) = context.User.Identity.Name
            Else
                ' Generate a new random GUID using System.Guid class
                Dim tempCartId = Guid.NewGuid()

                ' Send tempCartId back to client as a cookie
                context.Session(CartSessionKey) = tempCartId.ToString()
            End If
        End If

        Return context.Session(CartSessionKey).ToString()
    End Function

    ' When a user has logged in, migrate their shopping cart to
    ' be associated with their username
    Public Sub MigrateCart(ByVal userName As String)
        Dim shoppingCart = storeDB.Carts.Where(Function(c) c.CartId = ShoppingCartId)

        For Each item In shoppingCart
            item.CartId = userName
        Next item
        storeDB.SaveChanges()
    End Sub
End Class