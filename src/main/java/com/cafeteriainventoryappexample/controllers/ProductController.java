package com.cafeteriainventoryappexample.controllers;

import com.cafeteriainventoryappexample.models.Product;
import com.cafeteriainventoryappexample.models.ProductClass;
import com.cafeteriainventoryappexample.models.data.CountSheetDao;
import com.cafeteriainventoryappexample.models.data.ProductClassDao;
import com.cafeteriainventoryappexample.models.data.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ProductClassDao productClassDao;

    @Autowired
    private CountSheetDao countSheetDao;


    public ProductController() {
    }

    @RequestMapping("/")
    public String index(Model model) {

        model.addAttribute("title", "Cafeteria Inventory");
//        model.addAttribute("product", productDao.findAll());
//        model.addAttribute("allCurrentCountSheets", countSheetDao.findAllByOrderByInvDateDesc());
//        model.addAttribute("currentDate", CountSheet.getCurrentDate());

        return "index";
    }

    @RequestMapping("/hello")
    public String hello(Model model) {

        model.addAttribute("title", "Cafeteria Inventory");
        return "hello";
    }


    @RequestMapping("/product")
    public String showProducts(Model model) {

        model.addAttribute("title", "All Products");
        List<Product> products = (List<Product>) productDao.findAll();
        model.addAttribute("products", products);
        return "product/products";
    }


    @RequestMapping(value="/addProduct", method = RequestMethod.GET)
    public String addProductForm(Model model) {
        model.addAttribute("title", "Add Product");
        model.addAttribute(new Product());
        model.addAttribute("productClassList", productClassDao.findAll());

        return "product/addProduct";
    }


    @RequestMapping(value="/addProduct", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute @Valid Product newProduct,
                             BindingResult bindingResult, @RequestParam int productClassId, Model model) {
        // Method to handle post addProduct
        model.addAttribute("productClassList", productClassDao.findAll());
        ProductClass prcl = productClassDao.findOne(productClassId);
        newProduct.setProductClass(prcl);

        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Add Product");
            System.out.println("Something went wrong");
            return "product/addProduct";
        }

        productDao.save(newProduct);
        return "redirect:/product";
    }

    @RequestMapping(value = "/removeProduct", method = RequestMethod.GET)
    public String removeProductForm(Model model) {
        model.addAttribute("products", productDao.findAll());
        model.addAttribute("title", "Remove Product");
        return "product/remove";
    }


    @RequestMapping(value = "/removeProduct", method = RequestMethod.POST)
    public String removeProduct(@RequestParam (required = false) int[] productIds) {

        if (productIds != null) {
            for (int productId : productIds) {
                productDao.deleteById(productId);
            }
        }

        return "redirect:/product";
    }


}
