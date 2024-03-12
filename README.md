# FakeStoreCartService

1) getAllCarts() := GET method to return all carts from "https://fakestoreapi.com/carts"
2) getASingleCart(id) := GET method to return cart with id from "https://fakestoreapi.com/carts/{id}"
3) getInDateRange(startdate, enddate) := GET method to return carts in range between startdate and enddate taken fro url as query from "https://fakestoreapi.com/carts?startdate={startdate}&enddate={enddate}"
4) getUserCart(id) := GET method to return all carts of user with id from "https://fakestoreapi.com/carts/user/{id}"
5) addCart(cart) := POST method to add cart to all carts from "https://fakestoreapi.com/carts"
6) updateCart(cart, id) := PUT method to update card with id with Request body details from "https://fakestoreapi.com/carts/{id}"
7) deleteCart(id) := DELETE method to delete card with id from "https://fakestoreapi.com/carts/{id}"
