package ru.nedovizin.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nedovizin.model.CategoryDTO;
import ru.nedovizin.model.CategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public void saveAll(List<CategoryDTO> categories) {
        for (CategoryDTO categoryDTO : categories) {
            categoryRepository.save(categoryDTO);
        }
    }

    public List<CategoryDTO> findAllByToken(String token) {
        return categoryRepository.findAllByToken(token);
    }
}
