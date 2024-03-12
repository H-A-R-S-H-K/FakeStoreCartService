package com.fakestore.fakestorecart.services;

import com.fakestore.fakestorecart.models.Cart;

import java.util.List;

public interface CartService {
    Cart getASingleCart(Long id);
    List<Cart> getAllCarts();
    List<Cart> getUserCart(Long id);
    Cart addCart(Cart cart);
    Cart updateCart(Cart cart, Long id);
    Cart deleteCart(Long id);
}
