package com.fakestore.fakestorecart.services;

import com.fakestore.fakestorecart.dtos.CartDto;
import com.fakestore.fakestorecart.models.Cart;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreCartService implements CartService {
    private RestTemplate restTemplate = new RestTemplate();

    public Cart getASingleCart(Long id) {
        CartDto cartDto = restTemplate.getForObject(
          "https://fakestoreapi.com/carts/" + id,
          CartDto.class
        );

        Cart cart = new Cart();
        cart.setDate(cartDto.getDate());
        cart.setId(cartDto.getId());
        cart.setUserId(cart.getUserId());
        cart.setProducts(cartDto.getProducts());

        return cart;
    }

    public List<Cart> getAllCarts() {
        CartDto[] cartDtos = restTemplate.getForObject(
                "https://fakestoreapi.com/carts",
                CartDto[].class
        );

        List<Cart> carts = new ArrayList<>();
        for (CartDto cartDto : cartDtos) {

            Cart cart = new Cart();
            cart.setDate(cartDto.getDate());
            cart.setId(cartDto.getId());
            cart.setUserId(cartDto.getUserId());
            cart.setProducts(cartDto.getProducts());
            carts.add(cart);
        }

        return carts;
    }

    public List<Cart> getInDateRange(Date startdate, Date enddate) {
        List<Cart> carts = new ArrayList<>();
        CartDto[] cartDtos = restTemplate.getForObject(
                "https://fakestoreapi.com/carts?startdate=" + startdate + "&enddate=" + enddate,
                CartDto[].class
        );

        for (CartDto cartDto : cartDtos) {
            Cart cart = new Cart();
            cart.setDate(cartDto.getDate());
            cart.setId(cartDto.getId());
            cart.setUserId(cartDto.getUserId());
            cart.setProducts(cartDto.getProducts());

            carts.add(cart);
        }
        return carts;
    }
    public List<Cart> getUserCart(Long id) {
        List<Cart> userCart = new ArrayList<>();

        CartDto[] cartDtos = restTemplate.getForObject(
                "https://fakestoreapi.com/carts/user/" + id,
                CartDto[].class
        );

        for (CartDto cartDto : cartDtos) {
            Cart cart = new Cart();
            cart.setUserId(cartDto.getUserId());
            cart.setId(cartDto.getId());
            cart.setDate(cartDto.getDate());
            cart.setProducts(cartDto.getProducts());

            userCart.add(cart);
        }

        return userCart;
    }

    public Cart addCart(Cart cart) {
        CartDto cartDto = new CartDto();
        cartDto.setId(cart.getId());
        cartDto.setDate(cart.getDate());
        cartDto.setUserId(cart.getUserId());
        cartDto.setProducts(cart.getProducts());

        restTemplate.postForObject(
                "https://fakestoreapi.com/carts",
                cartDto,
                CartDto.class
        );

        return cart;
    }

    public Cart updateCart(Cart cart, Long id) {
        CartDto cartDto = new CartDto();
        cartDto.setId(id);
        cartDto.setDate(cart.getDate());
        cartDto.setUserId(cart.getUserId());
        cartDto.setProducts(cart.getProducts());

        restTemplate.put(
                "https://fakestoreapi.com/carts/" + id,
                cartDto
        );
        return cart;
    }
    public Cart deleteCart(Long id) {
        Cart cart = getASingleCart(id);
        restTemplate.delete("https://fakestoreapi.com/carts/" + id);

        return cart;
    }
}
