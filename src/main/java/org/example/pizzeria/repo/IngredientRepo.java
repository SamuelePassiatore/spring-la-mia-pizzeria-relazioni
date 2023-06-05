package org.example.pizzeria.repo;

import org.example.pizzeria.pojo.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepo extends JpaRepository<Ingredient, Integer> {

}
