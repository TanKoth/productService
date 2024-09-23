package org.productservice.service.productService;

import org.productservice.exception.ProductNotFoundException;
import org.productservice.model.Category;
import org.productservice.model.Product;
import org.productservice.repository.CategoryRepository;
import org.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ProductServiceDBImpl implements ProductService{
    private static final Logger logger = Logger.getLogger(ProductServiceDBImpl.class.getName());

    private ProductRepository productRepository;

    private CategoryRepository categoryRepository;

    public ProductServiceDBImpl(ProductRepository productRepository, CategoryRepository categoryRepository){

        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product createProduct(Product product) {
        Category toBeInProduct = getCategoryToBeInProduct(product);
        product.setCategory(toBeInProduct);

        Product savedProduct = productRepository.save(product);
        System.out.println("Printed successfully");

        return savedProduct;
    }

    private Category getCategoryToBeInProduct(Product product) {
        String cateoryName = product.getCategory().getName();
        Optional<Category> categoryOptional = categoryRepository.findByName(cateoryName);
        Category toBeInProduct = null;

        if(categoryOptional.isEmpty()){
            Category toSaveCategory = new Category();
            toSaveCategory.setName(cateoryName);


            toBeInProduct = categoryRepository.save(toSaveCategory);
        }else{
            toBeInProduct = categoryOptional.get();
        }
        return toBeInProduct;
    }

    @Override
    public List<Product> getAllProducts() {
        return  productRepository.findAll();
    }

    @Override
    public Product findById(Long id) throws ProductNotFoundException {
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty()){
            //logger.log(Level.INFO, "Product not found with specific id");
            throw new ProductNotFoundException("Product not found with specific id");
        }
       /* if (product.get().isDeleted()) {
            logger.log(Level.INFO, "Product is deleted");
            throw new ProductNotFoundException("Product is deleted");
        }*/
        Product productInfo = product.get();

        return productInfo;
    }

    @Override
    public Product partialUpdateProduct(Long productId, Product product)throws ProductNotFoundException{

        Optional<Product> productOptional = productRepository.findById(productId);
        if(productOptional.isEmpty()){
            throw new ProductNotFoundException("Product not found with specific id");
        }
        Product producToUpdate = productOptional.get();
        if(product.getDescription() != null){
            producToUpdate.setDescription(product.getDescription());
        }
        if(product.getTitle() != null){
            producToUpdate.setTitle(product.getTitle());
        }
        if(product.getPrice() != null){
            producToUpdate.setPrice(product.getPrice());
        }
        if(product.getCategory() != null){
            Category toBeInProduct = getCategoryToBeInProduct(product);
            producToUpdate.setCategory(toBeInProduct);
        }
        return productRepository.save(producToUpdate);
    }

    @Override
    public Product deleteProduct(Long id) throws ProductNotFoundException {

        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty()){
            throw new ProductNotFoundException("Product not found with specific id");
        }
        Product productToDelete = product.get();;
        //productToDelete.setDeleted(true);
        //productRepository.save(productToDelete);
        productRepository.delete(productToDelete);

        return productToDelete;
    }
}
