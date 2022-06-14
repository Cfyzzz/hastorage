package ru.nedovizin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nedovizin.model.Category;
import ru.nedovizin.model.CategoryRepository;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryRepository categoryRepository;
    private static final Logger log = LoggerFactory.getLogger(CategoryController.class);


    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @PostMapping("/{token}")
    public void putToStorage(@PathVariable(value = "token") String token, @RequestBody List<Category> categories) {
        log.info("SaveAll by token " + token);
        categoryRepository.saveAll(categories);
    }

    @GetMapping("/{token}")
    public List<Category> findAllCategories(@PathVariable(value = "token") String token) {
        return categoryRepository.findAllByToken(token);
    }
}
