package com.fakestore.fakestorecart.controllers;

import com.fakestore.fakestorecart.models.Cart;
import com.fakestore.fakestorecart.services.FakeStoreCartService;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
public class CartController {
    private FakeStoreCartService fakeStoreCartService;

    public CartController(FakeStoreCartService fakeStoreCartService) {
        this.fakeStoreCartService = fakeStoreCartService;
    }

    @GetMapping("/carts/{id}")
    public Cart getASingleCart(@PathVariable("id") Long id) {
        return this.fakeStoreCartService.getASingleCart(id);
    }

    @GetMapping("/carts")
    public List<Cart> getAllCarts() {
        return fakeStoreCartService.getAllCarts();
    }

    @GetMapping("/carts?")
    public List<Cart> getInDateRange(@RequestParam Date startdate, @RequestParam Date enddate) {
        return this.fakeStoreCartService.getInDateRange(startdate, enddate);
    }

    @GetMapping("/carts/user/{id}")
    public List<Cart> getUserCart(@PathVariable("id") Long id) {
        return fakeStoreCartService.getUserCart(id);
    }

    @PostMapping("/carts")
    public Cart addCart(@RequestBody Cart cart) {
        return this.fakeStoreCartService.addCart(cart);
    }

    @PutMapping("/carts/{id}")
    public Cart updateCart(Cart cart, Long id) {
        return this.fakeStoreCartService.updateCart(cart, id);
    }

    @DeleteMapping("/carts/{id}")
    public Cart deleteCart(@PathVariable("id") Long id) {
        return this.fakeStoreCartService.deleteCart(id);
    }
}
