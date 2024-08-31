package ru.nedovizin.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Categories implements Serializable {
    public List<CategoryDTO> categories;

    public List<CategoryDTO> getCategories() {
        return categories;
    }
}
