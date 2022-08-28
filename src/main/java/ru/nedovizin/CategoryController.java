package ru.nedovizin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import ru.nedovizin.model.Categories;
import ru.nedovizin.model.CategoryRepository;
import ru.nedovizin.model.MultipleResource;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryRepository categoryRepository;
    private static final Logger log = LoggerFactory.getLogger(CategoryController.class);


    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @PostMapping("/{token}")
    public MultipleResource putToStorage(@PathVariable(value = "token") String token, @RequestBody Categories categories) {
        log.info("Save all categories by token ".concat(token));
        categoryRepository.saveAll(categories.getCategories());
        MultipleResource result = new MultipleResource();
        result.setStatus("Ok");
        result.setDescription("Категории получены");
        return result;
    }

    @GetMapping("/{token}")
    public MultipleResource findAllCategories(@PathVariable(value = "token") String token) {
        log.info("Find all categories by token ".concat(token));
        MultipleResource result = new MultipleResource();
        result.setAnswer(categoryRepository.findAllByToken(token));
        result.setStatus("Ok");
        result.setDescription("Категории отправлены");
        return result;
    }
}
