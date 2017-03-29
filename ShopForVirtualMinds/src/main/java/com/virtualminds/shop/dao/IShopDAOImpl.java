package com.virtualminds.shop.dao;

import com.virtualminds.shop.entities.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

/**
 * Created by jocopernicus on 3/17/2017.
 */
@Repository("shopDAO")
public class IShopDAOImpl implements IShopDAO {
    @PersistenceContext
    EntityManager em;

    @Override
    public Long addCategory(Category c) {
        em.persist(c);
        return c.getIdCategory();
    }

    @Override
    public List<Category> listCategories() {
        Query sqlQry = em.createQuery("SELECT c FROM Category c");
        return sqlQry.getResultList();
    }

    @Override
    public Category getCategory(Long idCat) {
        return em.find(Category.class, idCat);
    }

    @Override
    public void deleteCategory(Long idCat) {
        Category c = em.find(Category.class, idCat);
        em.remove(c);
    }

    @Override
    public void updateCategory(Category c) {
        em.merge(c);
    }

    @Override
    public Long addproduct(Product p, Long idCat) {
        Category c = getCategory(idCat);
        p.setCategory(c);
        em.persist(p);
        return p.getIdProduct();
    }

    @Override
    public List<Product> listProducts() {
        Query sqlQry = em.createQuery("SELECT p FROM Product p");
        return sqlQry.getResultList();
    }

    @Override
    public List<Product> productsByKeyword(String kw) {
        Query sqlQry = em.createQuery("SELECT p FROM Product p WHERE p.name LIKE :x OR p.description LIKE :x");
        sqlQry.setParameter("x","%"+kw+"%");
        return sqlQry.getResultList();
    }

    @Override
    public List<Product> productsByCategory(Long idCat) {
        Query sqlQry = em.createQuery("SELECT p FROM Product p WHERE p.category.idCategory = :x ");
        sqlQry.setParameter("x",idCat);
        return sqlQry.getResultList();
    }

    @Override
    public List<Product> productsSelected() {
        Query sqlQry = em.createQuery("SELECT p FROM Product p WHERE p.selected = true ");
        return sqlQry.getResultList();
    }

    @Override
    public Product getProduct(Long idProd) {
        return em.find(Product.class, idProd);
    }

    @Override
    public void deleteProduct(Long idProd) {
        Product p = em.find(Product.class, idProd);
        em.remove(p);
    }

    @Override
    public void updateProduct(Product p) {
        em.merge(p);
    }

    @Override
    public void addUser(User u) {
        em.persist(u);
    }

    @Override
    public void assignRole(Role r, Long idUser) {
        User u = em.find(User.class, idUser);
        // Assign the role to the user as follows since the relationship is not bidirectional
        u.getRoles().add(r);
        em.persist(r);
    }

    @Override
    public Order saveOrder(ShoppingCart sc, Customer c) {
        em.persist(c);
        Order order = new Order();
        order.setDateOrder(new Date());
        order.setOrderLines(sc.getItems());
        for(OrderLine ol:sc.getItems()){
            em.persist(ol);
        }
        em.persist(order);
        return order;
    }
}
