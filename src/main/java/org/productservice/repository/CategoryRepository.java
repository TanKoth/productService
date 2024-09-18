package org.productservice.repository;

import org.productservice.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Override
    Category save(Category category);

    @Override
    void delete(Category category);

    Optional<Category> findByName(Long id);
}
