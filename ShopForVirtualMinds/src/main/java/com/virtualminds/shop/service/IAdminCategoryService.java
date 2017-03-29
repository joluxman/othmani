package com.virtualminds.shop.service;

import com.virtualminds.shop.entities.*;

/**
 * Created by jocopernicus on 3/17/2017.
 */
public interface IAdminCategoryService extends IAdminProductService{
    Long addCategory(Category c);
    void deleteCategory(Long idCat);
    void updateCategory(Category c);
    void addUser(User u);
    void assignRole(Role r, Long idUser);
}
