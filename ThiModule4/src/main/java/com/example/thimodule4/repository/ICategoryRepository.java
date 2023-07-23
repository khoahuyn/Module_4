package com.example.thimodule4.repository;

import com.example.thimodule4.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category,Integer> {
}
