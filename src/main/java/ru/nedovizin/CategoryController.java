package ru.nedovizin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nedovizin.model.Category;
import ru.nedovizin.model.CategoryRepository;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping("/{token}")
    public void putToStorage(@PathVariable(value = "token") String token, @Validated @RequestBody List<Category> categories) {
        categoryRepository.saveAll(categories);
    }

    @GetMapping("/{token}")
    public List<Category> findAllCategories(@PathVariable(value = "token") String token) {
        return categoryRepository.findAllByToken(token);
    }
}
