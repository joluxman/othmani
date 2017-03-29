package com.virtualminds.shop.dao;

import com.virtualminds.shop.entities.*;

import java.util.List;

/**
 * Created by jocopernicus on 3/17/2017.
 */
public interface IShopDAO {
    Long addCategory(Category c);
    List<Category> listCategories();
    Category getCategory(Long idCat);
    void deleteCategory(Long idCat);
    void updateCategory(Category c);

    Long addproduct(Product p, Long idCat);
    List<Product> listProducts();
    List<Product> productsByKeyword(String kw);
    List<Product> productsByCategory(Long idCat);
    List<Product> productsSelected();
    Product getProduct(Long idProd);
    void deleteProduct(Long idProd);
    void updateProduct(Product p);

    void addUser(User u);
    void assignRole(Role r, Long idUser);
    Order saveOrder(ShoppingCart sc, Customer c);
}
