package org.productservice.repository;

import org.productservice.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Override
    Category save(Category category);

    @Override
   void delete(Category category);

    Optional<Category> findByName(String name);

    Optional<Category> findById(Long id);

    @Override
    List<Category> findAll();
}