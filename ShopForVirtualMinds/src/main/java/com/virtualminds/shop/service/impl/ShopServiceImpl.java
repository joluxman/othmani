package com.virtualminds.shop.service.impl;

import com.virtualminds.shop.dao.IShopDAO;
import com.virtualminds.shop.entities.*;
import com.virtualminds.shop.service.IAdminCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jocopernicus on 3/17/2017.
 */
@Service("shopService")
@Transactional
public class ShopServiceImpl implements IAdminCategoryService {

    @Autowired
    IShopDAO shopDAO;

    //private IShopDAO shopDAO;

  /*  public void setShopDAO(IShopDAO shopDAO) {
        this.shopDAO = shopDAO;
    }*/

    @Override
    public Long addCategory(Category c) {
        return shopDAO.addCategory(c);
    }

    @Override
    public void deleteCategory(Long idCat) {
        shopDAO.deleteCategory(idCat);
    }

    @Override
    public void updateCategory(Category c) {
        shopDAO.updateCategory(c);
    }

    @Override
    public void addUser(User u) {
        shopDAO.addUser(u);
    }

    @Override
    public void assignRole(Role r, Long idUser) {
        shopDAO.assignRole(r,idUser);
    }

    @Override
    public Long addProduct(Product p, Long idCat) {
        return shopDAO.addproduct(p,idCat);
    }

    @Override
    public void deleteProduct(Long idProd) {
        shopDAO.deleteProduct(idProd);
    }

    @Override
    public void updateProduct(Product p) {
        shopDAO.updateProduct(p);
    }

    @Override
    public List<Category> listCategories() {
        return shopDAO.listCategories();
    }

    @Override
    public Category getCategory(Long idCat) {
        return shopDAO.getCategory(idCat);
    }

    @Override
    public List<Product> listProducts() {
        return shopDAO.listProducts();
    }

    @Override
    public List<Product> productsByKeyword(String kw) {
        return shopDAO.productsByKeyword(kw);
    }

    @Override
    public List<Product> productsByCategory(Long idCat) {
        return shopDAO.productsByCategory(idCat);
    }

    @Override
    public List<Product> productsSelected() {
        return shopDAO.productsSelected();
    }

    @Override
    public Product getProduct(Long idProd) {
        return shopDAO.getProduct(idProd);
    }

    @Override
    public Order saveOrder(ShoppingCart sc, Customer c) {
        return shopDAO.saveOrder(sc,c);
    }
}
