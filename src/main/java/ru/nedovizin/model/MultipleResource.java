package ru.nedovizin.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class MultipleResource implements Serializable {
    public String status;
    public String description;
    public Answer answer = null;

    public void setAnswer(List<Category> categories) {
        answer = new Answer(categories);
    }

    public static class Answer {
         public List<Category> categories = null;

         public Answer(List<Category> categories) {
             this.categories = categories;
         }
    }
}
