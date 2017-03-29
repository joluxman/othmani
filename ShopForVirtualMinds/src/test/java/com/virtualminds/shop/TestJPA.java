package com.virtualminds.shop;

/**
 * Created by jocopernicus on 3/17/2017.
 */
import com.virtualminds.shop.entities.Product;
import com.virtualminds.shop.service.IAdminCategoryService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;
public class TestJPA {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"WEB-INF/spring/applicationContext.xml"});
    @Before
    public void setUp() throws Exception {

    }

    /*@Test
    public void testCategories(){
        try{
            IAdminCategoryService shopService = (IAdminCategoryService) context.getBean("shopService");
            List<Category> list1 = shopService.listCategories();
            shopService.addCategory(new Category("Categornom1","description 1",null,"image1.jpg"));
            shopService.addCategory(new Category("Catego nom2","description 2",null,"image2.jpg"));
            shopService.addCategory(new Category("Catego nom3","description 3",null,"image3.jpg"));
            List<Category> list2 = shopService.listCategories();
            assertTrue(list1.size()+3 == list2.size());
        }catch(Exception e){
            assertTrue(e.getMessage(),false);
        }
    }*/

    @Test
    public void testProducts(){
        try{
            IAdminCategoryService shopService = (IAdminCategoryService) context.getBean("shopService");
            List<Product> list1 = shopService.listProducts();
            shopService.addProduct(new Product("Categornom1", "description 1", 3.0d, true,5),100L);
            shopService.addProduct(new Product("Categornom2", "description 2", 3.4d, true,7),101L);
            shopService.addProduct(new Product("Categornom3", "description 3", 3.0d, true,8),102L);
            List<Product> list2 = shopService.listProducts();
            assertTrue(list1.size()+3 == list2.size());
        }catch(Exception e){
            assertTrue(e.getMessage(),false);
        }
    }
}
