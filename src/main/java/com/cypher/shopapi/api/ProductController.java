package com.cypher.shopapi.api;

import com.cypher.shopapi.entity.ProductInfo;
import com.cypher.shopapi.entity.User;
import com.cypher.shopapi.service.CategoryService;
import com.cypher.shopapi.service.ProductService;
import com.cypher.shopapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created By Ruchir Sachdeva on 3/10/2018.
 */
@CrossOrigin
@RestController
public class ProductController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;

    /**
     * Show All Categories
     */

    @GetMapping("/product")
    public Page<ProductInfo> findAll(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                     @RequestParam(value = "size", defaultValue = "3") Integer size) {
        PageRequest request = PageRequest.of(page - 1, size);
        return productService.findAll(request);
    }

    @GetMapping("/product/seller")
    public Page<ProductInfo> findAllBySeller(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                     @RequestParam(value = "size", defaultValue = "3") Integer size,
                                            Authentication authentication) {
        PageRequest request = PageRequest.of(page - 1, size);

        return productService.findBySellerEmail(authentication.getName(), request);
    }

    @GetMapping("/product/{productId}")
    public ProductInfo showOne(@PathVariable("productId") String productId) {

        ProductInfo productInfo = productService.findOne(productId);

//        // Product is not available
//        if (productInfo.getProductStatus().equals(ProductStatusEnum.DOWN.getCode())) {
//            productInfo = null;
//        }

        return productInfo;
    }

    @PostMapping("/seller/product/new")
    public ResponseEntity create(@Valid @RequestBody ProductInfo product,
                                 BindingResult bindingResult, Authentication authentication) {
        ProductInfo productIdExists = productService.findOne(product.getProductId());
        if (productIdExists != null) {
            bindingResult
                    .rejectValue("productId", "error.product",
                            "There is already a product with the code provided");
        }
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult);
        }

        product.setSeller(userService.findOne(authentication.getName()));
        return ResponseEntity.ok(productService.save(product));
    }

    @PutMapping("/seller/product/{id}/edit")
    public ResponseEntity edit(@PathVariable("id") String productId,
                               @Valid @RequestBody ProductInfo product,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult);
        }
        if (!productId.equals(product.getProductId())) {
            return ResponseEntity.badRequest().body("Id Not Matched");
        }

        return ResponseEntity.ok(productService.update(product));
    }

    @DeleteMapping("/seller/product/{id}/delete")
    public ResponseEntity delete(@PathVariable("id") String productId) {
        productService.delete(productId);
        return ResponseEntity.ok().build();
    }

}
