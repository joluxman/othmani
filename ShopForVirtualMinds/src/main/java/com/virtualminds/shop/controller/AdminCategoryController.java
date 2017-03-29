package com.virtualminds.shop.controller;

import com.virtualminds.shop.entities.Category;
import com.virtualminds.shop.service.IAdminCategoryService;
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
import sun.misc.IOUtils;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * Created by jocopernicus on 3/18/2017.
 */
@Controller
@RequestMapping(value = "/adminCat")
public class AdminCategoryController implements HandlerExceptionResolver{
    @Autowired IAdminCategoryService shopService;

    @RequestMapping(value="/index", method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("category",new Category());
        model.addAttribute("categories",shopService.listCategories());
        return "categories";
    }

    @RequestMapping(value="/saveCat")
    public String saveCat(@Valid Category cat, BindingResult bindingResult, Model model, MultipartFile file)throws IOException{
        if(bindingResult.hasErrors()){
            model.addAttribute("categories",shopService.listCategories());
            return "categories";
        }
        if(!file.isEmpty()){
            BufferedImage bi = ImageIO.read(file.getInputStream());
            cat.setPhoto(file.getBytes());
            cat.setPhotoName(file.getOriginalFilename());
        }
        if(cat.getIdCategory()!=null){
            if(file.isEmpty()){
                Category c = shopService.getCategory(cat.getIdCategory());
                cat.setPhoto(cat.getPhoto());
            }
            shopService.updateCategory(cat);
        }else
        shopService.addCategory(cat);
        model.addAttribute("category",new Category());
        model.addAttribute("categories",shopService.listCategories());
        return "categories";
    }

    @RequestMapping(value="photoCat",produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] photoCat(Long idCat)throws IOException{
        Category cat =  shopService.getCategory(idCat);
        return org.apache.commons.io.IOUtils.toByteArray(new ByteArrayInputStream(cat.getPhoto()));
    }

    @RequestMapping(value="/deleteCat")
    public String deleteCat(Long idCat, Model model){
        shopService.deleteCategory(idCat);
        model.addAttribute("category",new Category());
        model.addAttribute("categories",shopService.listCategories());
        return "categories";
    }

    @RequestMapping(value="/editCat")
    public String editCat(Long idCat, Model model){
        Category cat = shopService.getCategory(idCat);
        model.addAttribute("category",cat);
        model.addAttribute("categories",shopService.listCategories());
        return "categories";
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
        mv.addObject("category", new Category());
        mv.addObject("categories",shopService.listCategories());
        mv.addObject("exception",ex.getMessage());
        mv.setViewName("categories");
        return mv;
    }
}
