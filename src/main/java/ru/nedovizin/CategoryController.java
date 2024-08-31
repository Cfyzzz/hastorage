package ru.nedovizin;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.nedovizin.model.Categories;
import ru.nedovizin.model.MultipleResource;
import ru.nedovizin.services.CategoryService;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    private static final Logger log = LoggerFactory.getLogger(CategoryController.class);


//    public CategoryController(CategoryRepository categoryRepository) {
//        this.categoryRepository = categoryRepository;
//    }

    @PostMapping("/{token}")
    public MultipleResource putToStorage(@PathVariable(value = "token") String token, @RequestBody Categories categories) {
        log.info("Save all categories by token ".concat(token));
        categoryService.saveAll(categories.getCategories());
        MultipleResource result = new MultipleResource();
        result.setStatus("Ok");
        result.setDescription("Категории получены");
        return result;
    }

    @GetMapping("/{token}")
    public MultipleResource findAllCategories(@PathVariable(value = "token") String token) {
        log.info("Find all categories by token ".concat(token));
        MultipleResource result = new MultipleResource();
        result.setAnswer(categoryService.findAllByToken(token));
        result.setStatus("Ok");
        result.setDescription("Категории отправлены");
        return result;
    }
}
