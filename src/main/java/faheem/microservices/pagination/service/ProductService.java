package faheem.microservices.pagination.service;

import faheem.microservices.pagination.entity.Product;
import faheem.microservices.pagination.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public void removeProduct(Integer productId){
        log.info("ProductService.removeProduct() method is called with productId : {}",productId);
        log.info("deleting product with product id : {}",productId);
        if(productRepository.findById(productId).isPresent()) {
            log.info("product found with id : {}",productId);
            productRepository.deleteById(productId);
            log.info("product deleted successfully");
        }else{
            log.error("product not found with product id : {}",productId);
            throw new NoSuchElementException("product not found exception");

        }
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public List<Product> getProductsWithSorting(String sortByField){
        return productRepository.findAll(Sort.by(Sort.Direction.ASC,sortByField));
    }
                                                            //offset means pageNumber. e.g show first 5 elements on pageNumber 0
    public Page<Product> findProductsWithPagination(int offset, int pageSize){//pageSize = number of products per page
        Page<Product> page = productRepository.findAll(PageRequest.of(offset,pageSize)); // e.g(0,5)
        return page;
    }

    public Page<Product> paginationWithSorting(int offset, int pageSize,String sortingField){
        Page<Product> page = productRepository.findAll(PageRequest.of(offset,pageSize).withSort(Sort.by(sortingField)));
        return page;
    }


}
