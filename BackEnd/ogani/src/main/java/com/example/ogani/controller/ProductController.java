package com.example.ogani.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ogani.entity.Product;
import com.example.ogani.model.request.CreateProductRequest;
import com.example.ogani.model.response.MessageResponse;
import com.example.ogani.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/product")
@CrossOrigin(origins = "*",maxAge = 3600)
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/")
    @Operation(summary="Obtenir la liste des produits")
    public ResponseEntity<List<Product>> getList(){
        List<Product> list = productService.getList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/newest/{number}")
    @Operation(summary="Obtenir la liste des produits les plus récents limités à la quantité = nombre")
    public ResponseEntity<List<Product>> getListNewst(@PathVariable int number){
        List<Product> list =productService.getListNewst(number);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/price")
    @Operation(summary="")
    public ResponseEntity<List<Product>> getListByPrice(){
        List<Product> list = productService.getListByPrice();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/related/{id}")
    @Operation(summary="Sélectionnez au hasard 4 produits en utilisantcategory_id")
    public ResponseEntity<List<Product>> getListRelatedProduct(@PathVariable long id){
        List<Product> list = productService.findRelatedProduct(id);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/category/{id}")
    @Operation(summary="Récupérer la liste des produits par identifiant de catégorie")
    public ResponseEntity<List<Product>> getListProductByCategory(@PathVariable long id){
        List<Product> list =  productService.getListProductByCategory(id);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/range")
    @Operation(summary="Récupérer une liste de produits aux prix du min au max")
    public ResponseEntity<List<Product>> getListProductByPriceRange(@RequestParam("id") long id,@RequestParam("min") int min, @RequestParam("max") int max){
        List<Product> list = productService.getListByPriceRange(id, min, max);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    @Operation(summary="Obtenir le produit par identifiant")
    public ResponseEntity<Product> getProduct(@PathVariable long id){
        Product product = productService.getProduct(id);

        return ResponseEntity.ok(product);
    }

    @GetMapping("/search")
    @Operation(summary="Rechercher des produits par mot-clé")
    public ResponseEntity<List<Product>> searchProduct(@RequestParam("keyword") String keyword){
        List<Product> list = productService.searchProduct(keyword);
        return ResponseEntity.ok(list);
    }

    @PostMapping("/create")
    @Operation(summary="Créer un nouveau produit")
    public ResponseEntity<Product> createProduct(@RequestBody CreateProductRequest request){
        Product product = productService.createProduct(request);

        return ResponseEntity.ok(product);
    }

    @PutMapping("/update/{id}")
    @Operation(summary="Rechercher un produit par identifiant et le mettre à jour")
    public ResponseEntity<Product> updateProduct(@PathVariable long id,@RequestBody CreateProductRequest request){
        Product product = productService.updateProduct(id, request);

        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary="Supprimer le produit par identifiant")
    public ResponseEntity<?> deleteProduct(@PathVariable long id){
        productService.deleteProduct(id);

        return ResponseEntity.ok(new MessageResponse("Product is delete"));
    }


}
