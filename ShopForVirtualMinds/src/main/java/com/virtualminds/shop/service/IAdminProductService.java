package com.virtualminds.shop.service;

import com.virtualminds.shop.entities.Product;

/**
 * Created by jocopernicus on 3/17/2017.
 */
public interface IAdminProductService extends IShopVisitorService{
    Long addProduct(Product p, Long idCat);
    void deleteProduct(Long idProd);
    void updateProduct(Product p);
}
