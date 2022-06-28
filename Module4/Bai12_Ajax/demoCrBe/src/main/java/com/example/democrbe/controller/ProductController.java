package com.example.democrbe.controller;

import com.example.democrbe.model.Product;
import com.example.democrbe.service.ProductService;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private HttpSession httpSession;

    @GetMapping
    public ResponseEntity<Iterable> findAll(Pageable pageable , @CookieValue(value = "counter" , defaultValue = "0") Long counter , HttpServletResponse response){
        System.out.println("Controller");
        counter++;
        Cookie cookie = new Cookie("counter" , counter.toString());
        cookie.setMaxAge(30);
        response.addCookie(cookie);
        return new ResponseEntity<>(productService.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        return new ResponseEntity<>(productService.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity add(@RequestBody Product product) {
        productService.save(product);
        httpSession.setAttribute("product" , product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("viewSession")
    public ResponseEntity viewSession() {
        Product product = (Product) httpSession.getAttribute("product");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody Product product, @PathVariable Long id) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        product.setId(productOptional.get().getId());
        productService.save(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id){
        Optional<Product> productOptional = productService.findById(id);
        if(!productOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        productService.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
