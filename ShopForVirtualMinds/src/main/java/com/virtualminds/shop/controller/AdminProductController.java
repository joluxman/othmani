package com.virtualminds.shop.controller;

import com.virtualminds.shop.entities.Category;
import com.virtualminds.shop.entities.Product;
import com.virtualminds.shop.service.IAdminProductService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by jocopernicus on 3/20/2017.
 */
@Controller
@RequestMapping(value = "/adminProd")
public class AdminProductController implements HandlerExceptionResolver{
    @Autowired
    IAdminProductService shopService;

    @RequestMapping(value="/index", method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("product",new Product());
        model.addAttribute("products",shopService.listProducts());
        model.addAttribute("categories",shopService.listCategories());
        return "products";
    }

    @RequestMapping(value="/saveProd")
    public String saveProd(@Valid Product prod, BindingResult bindingResult, Model model, MultipartFile file)throws IOException {
        if(bindingResult.hasErrors()){
            model.addAttribute("products",shopService.listProducts());
            model.addAttribute("categories",shopService.listCategories());
            return "products";
        }

        //TODO can be improved to avoid duplicated test but just for demo purpose for VirtualMinds
        if(!file.isEmpty()){
            String path = System.getProperty("java.io.tmpdir");
            prod.setPhoto(file.getOriginalFilename());
            Long idProd = null;
            if(prod.getIdProduct()==null){
                idProd = shopService.addProduct(prod,prod.getCategory().getIdCategory());
            }else{
                shopService.updateProduct(prod);
                idProd = prod.getIdProduct();
            }
            file.transferTo(new File(path+"/"+"PROD_"+idProd+"_"+file.getOriginalFilename()));
        }else {
            if(prod.getIdProduct()==null)
                shopService.addProduct(prod, prod.getCategory().getIdCategory());
            else shopService.updateProduct(prod);
        }
        model.addAttribute("product",new Product());
        model.addAttribute("products",shopService.listProducts());
        model.addAttribute("categories",shopService.listCategories());
        return "products";
    }

    @RequestMapping(value="photoProd",produces= MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] photoProd(Long idProd) throws IOException{
        Product p = shopService.getProduct(idProd);
        File f = new File(System.getProperty("java.io.tmpdir")+"/PROD_"+idProd+"_"+p.getPhoto());
        return IOUtils.toByteArray(new FileInputStream(f));
    }

    @RequestMapping(value="/deleteProd")
    public String deleteProd(Long idProd, Model model){
        shopService.deleteProduct(idProd);
        model.addAttribute("product",new Product());
        model.addAttribute("products",shopService.listProducts());
        model.addAttribute("categories",shopService.listCategories());
        return "products";
    }

    @RequestMapping(value="/editProd")
    public String editProd(Long idProd, Model model){
        Product prod = shopService.getProduct(idProd);
        model.addAttribute("product",prod);
        model.addAttribute("products",shopService.listProducts());
        model.addAttribute("categories",shopService.listCategories());
        return "products";
    }

    /**
     * Try to resolve the given exception that got thrown during on handler execution,
     * returning a ModelAndView that represents a specific error page if appropriate.
     * <p>The returned ModelAndView may be {@linkplain ModelAndView#isEmpty() empty}
     * to indicate that the exception has been resolved successfully but that no view
     * should be rendered, for instance by setting a status code.
     *
     * @param request  current HTTP request
     * @param response current HTTP response
     * @param handler  the executed handler, or {@code null} if none chosen at the
     *                 time of the exception (for example, if multipart resolution failed)
     * @param ex       the exception that got thrown during handler execution
     * @return a corresponding ModelAndView to forward to,
     * or {@code null} for default processing
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("product", new Product());
        mv.addObject("products",shopService.listProducts());
        mv.addObject("categories",shopService.listCategories());
        mv.addObject("exception",ex.getMessage());
        mv.setViewName("products");
        return mv;
    }

}
