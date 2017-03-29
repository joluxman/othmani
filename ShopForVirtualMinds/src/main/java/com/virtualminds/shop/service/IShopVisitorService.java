package com.virtualminds.shop.service;

import com.virtualminds.shop.entities.*;
import java.util.List;

/**
 * Created by jocopernicus on 3/17/2017.
 */
public interface IShopVisitorService {
    List<Category> listCategories();
    Category getCategory(Long idCat);
    List<Product> listProducts();
    List<Product> productsByKeyword(String kw);
    List<Product> productsByCategory(Long idCat);
    List<Product> productsSelected();
    Product getProduct(Long idProd);
    Order saveOrder(ShoppingCart sc, Customer c);
}
