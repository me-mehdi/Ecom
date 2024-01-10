package com.example.ogani.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ogani.entity.Category;
import com.example.ogani.model.request.CreateCategoryRequest;
import com.example.ogani.model.response.MessageResponse;
import com.example.ogani.service.CategoryService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/category")
@CrossOrigin(origins = "*",maxAge = 3600)
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    @Operation(summary="Obtenez la liste des catégories")
    public ResponseEntity<?> getListCategory(){
        List<Category> categories = categoryService.findAll();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/enabled")
    @Operation(summary="Obtenez la liste des catégories activées")
    public ResponseEntity<List<Category>> getListEnabled(){
        List<Category> categories = categoryService.getListEnabled();
        return ResponseEntity.ok(categories);
    }


    @PostMapping("/create")
    @Operation(summary="Tạo mới danh mục")
    public ResponseEntity<?> createCategory(@Valid @RequestBody CreateCategoryRequest request){
        Category category = categoryService.createCategory(request);

        return ResponseEntity.ok(category);
    }

    @PutMapping("/update/{id}")
    @Operation(summary="Recherchez la catégorie par identifiant et mettez-la à jour")
    public ResponseEntity<?> updateCategory(@PathVariable long id, @Valid @RequestBody CreateCategoryRequest request){
        Category category = categoryService.updateCategory(id, request);
        return ResponseEntity.ok(category);
    }

    @PutMapping("/enable/{id}")
    @Operation(summary="Activer la catégorie par identifiant")
    public ResponseEntity<?> enabled(@PathVariable long id){
        categoryService.enableCategory(id);
        return ResponseEntity.ok(new MessageResponse("Mise à jour réussie"));
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary="Supprimer la catégorie par identifiant")
    public ResponseEntity<?> delete(@PathVariable long id){
        categoryService.deleteCategory(id);
        return ResponseEntity.ok(new MessageResponse("Supprimé avec succès"));
    }


}
