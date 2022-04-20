package com.lab.emtlab.web;

import com.lab.emtlab.model.enumerations.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
/*@CrossOrigin(origins = "http://localhost:3000")*/
@CrossOrigin(origins = "*")
@RequestMapping("/api/categories")
public class CategoryRestController {

//    @GetMapping
//    public List<Category> findAll() {
//        return List.of(Category.values());
//    }
    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        return new ResponseEntity<List<Category>>(Arrays.asList(Category.values()), HttpStatus.OK);
    }
}
