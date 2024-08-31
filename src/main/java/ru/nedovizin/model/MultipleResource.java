package ru.nedovizin.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class MultipleResource implements Serializable {
    public String status;
    public String description;
    public Answer answer = null;

    public void setAnswer(List<CategoryDTO> categories) {
        answer = new Answer(categories);
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static class Answer {
         public List<CategoryDTO> categories = null;

         public Answer(List<CategoryDTO> categories) {
             this.categories = categories;
         }
    }
}
