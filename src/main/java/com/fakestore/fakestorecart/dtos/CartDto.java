package com.fakestore.fakestorecart.dtos;

import com.fakestore.fakestorecart.models.ProductDetails;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CartDto {
    private Long id;
    private Long userId;
    private Date date;
    private ProductDetails[] products;
}
