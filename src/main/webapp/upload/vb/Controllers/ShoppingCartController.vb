Public Class ShoppingCartController
    Inherits Controller
    Private storeDB As New MusicStoreEntities

    '
    ' GET: /ShoppingCart/

    Public Function Index() As ActionResult
        Dim cart = ShoppingCart.GetCart(Me.HttpContext)

        ' Set up our ViewModel
        Dim viewModel = New ShoppingCartViewModel With
                        {.CartItems = cart.GetCartItems(),
                         .CartTotal = cart.GetTotal()}

        ' Return the view
        Return View(viewModel)
    End Function

    '
    ' GET: /Store/AddToCart/5

    Public Function AddToCart(ByVal id As Integer) As ActionResult

        ' Retrieve the album from the database
        Dim addedAlbum = storeDB.Albums.Single(Function(album) album.AlbumId = id)

        ' Add it to the shopping cart
        Dim cart = ShoppingCart.GetCart(Me.HttpContext)

        cart.AddToCart(addedAlbum)

        ' Go back to the main store page for more shopping
        Return RedirectToAction("Index")
    End Function

    '
    ' AJAX: /ShoppingCart/RemoveFromCart/5

    <HttpPost()>
    Public Function RemoveFromCart(ByVal id As Integer) As ActionResult
        ' Remove the item from the cart
        Dim cart = ShoppingCart.GetCart(Me.HttpContext)

        ' Get the name of the album to display confirmation
        Dim albumName = storeDB.Carts.Single(Function(item) item.RecordId = id).Album.Title

        ' Remove from cart
        Dim itemCount = cart.RemoveFromCart(id)

        ' Display the confirmation message
        Dim results = New ShoppingCartRemoveViewModel With
                      {.Message = Server.HtmlEncode(albumName) & " has been removed from your shopping cart.",
                       .CartTotal = cart.GetTotal(),
                       .CartCount = cart.GetCount(),
                       .ItemCount = itemCount,
                       .DeleteId = id}

        Return Json(results)
    End Function

    '
    ' GET: /ShoppingCart/CartSummary

    <ChildActionOnly()>
    Public Function CartSummary() As ActionResult
        Dim cart = ShoppingCart.GetCart(Me.HttpContext)

        ViewData("CartCount") = cart.GetCount()

        Return PartialView("CartSummary")
    End Function
End Class