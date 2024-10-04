package org.productservice.repository;

import org.productservice.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
     Product save(Product product);

    @Override
    void delete(Product product);

    List<Product> findAll();

    Optional<Product> findById(Long id);

    List<Product> findByTitleContaining(String query);

    Page<Product> findAllByTitleContainingAndCategory_Id(String title, Long CategoryId, Pageable pageable);
}
