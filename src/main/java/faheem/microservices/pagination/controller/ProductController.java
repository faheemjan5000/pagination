package faheem.microservices.pagination.controller;

import faheem.microservices.pagination.entity.Product;
import faheem.microservices.pagination.model.ApiResponse;
import faheem.microservices.pagination.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @DeleteMapping("/remove/{productId}")
    public void removeProduct(@PathVariable Integer productId){
        log.info("ProductController.removeProduct() method is called with product id : {}",productId);
        productService.removeProduct(productId);
        log.info("end of method removeProduct() in controller!");
    }

    @GetMapping("/all")
    public ApiResponse<List<Product>> getAllProducts(){
        List<Product> allProducts = productService.getAllProducts();
        return new ApiResponse<>(allProducts.size(),allProducts);
    }

    @GetMapping("/sortedProducts/{sortField}")
    public ApiResponse<List<Product>> getProductsWithSorting(@PathVariable String sortField){
        List<Product> sortedProducts =  productService.getProductsWithSorting(sortField);
        return new ApiResponse<>(sortedProducts.size(),sortedProducts);
    }

    @GetMapping("/pagination/{offset}/{pageSize}")
    public ApiResponse<Page<Product>> getProductsWithPagination(@PathVariable("offset") int offset,@PathVariable("pageSize") int pageSize){
        Page<Product> pageOfProducts = productService.findProductsWithPagination(offset,pageSize);
        return new ApiResponse<>(pageOfProducts.getSize(),pageOfProducts);
    }

    @GetMapping("/paginationWithSorting/{offset}/{pageSize}/{field}")
    public ApiResponse<Page<Product>> getProductsWithPaginationAndSorting(@PathVariable("offset") int offset,
                                                                          @PathVariable("pageSize") int pageSize,
                                                                           @PathVariable("field")String field){
        Page<Product> pageOfProducts = productService.paginationWithSorting(offset,pageSize,field);
        return new ApiResponse<>(pageOfProducts.getSize(),pageOfProducts);
    }
}
