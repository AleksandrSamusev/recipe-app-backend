package dev.practice.recipeappback.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "recipes")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    private Long recipeId;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    @Column(name = "category")
    private String category;

    @Column(name = "type")
    private String type;

    @Column(name = "main_ingredient")
    private String mainIngredient;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "prepare_time")
    private String prepareTime;

    @Column(name = "cooking_time")
    private String cookingTime;

    @Column(name = "img_large")
    private String imgLarge;

    @Column(name = "img_medium")
    private String imgMedium;

    @Column(name = "img_small_1")
    private String imgSmall1;

    @Column(name = "img_small_2")
    private String imgSmall2;

    @Column(name = "img_small_3")
    private String imgSmall3;

    @Column(name = "img_small_4")
    private String imgSmall4;

    @ManyToMany
    @JoinTable(
            name = "recipes_ingredients",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private Set<Ingredient> ingredients;

    @ManyToMany
    @JoinTable(
            name = "recipes_nutrients",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "nutrient_id")
    )
    private Set<Nutrient> nutrients;

    @OneToMany(mappedBy = "recipe")
    private Set<Step> steps;
}
