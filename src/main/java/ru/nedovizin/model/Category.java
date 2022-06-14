package ru.nedovizin.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Data
@Entity
public class Category {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EmbeddedId
    private CategoryId categoryId;
    private int priority;
    private String period;
    private String type;
    private int color;
    private String categoryName;
    private int exposed;
    private int reserved;
    private int planned;

    public Category() {
        categoryId = new CategoryId();
    }

    public Category(CategoryId categoryId, int priority, String period, String type, int color, String categoryName, int exposed, int reserved, int planned) {
        this.categoryId = categoryId;
        this.priority = priority;
        this.period = period;
        this.type = type;
        this.color = color;
        this.categoryName = categoryName;
        this.exposed = exposed;
        this.reserved = reserved;
        this.planned = planned;
    }

    public Category(long id, String token, int priority, String period, String type, int color, String categoryName, int exposed, int reserved, int planned) {
        this.categoryId.setToken(token);
        this.categoryId.setId(id);
        this.priority = priority;
        this.period = period;
        this.type = type;
        this.color = color;
        this.categoryName = categoryName;
        this.exposed = exposed;
        this.reserved = reserved;
        this.planned = planned;
    }

    public void setId(long id) {
        categoryId.setId(id);
    }

    public long getId() {
        return categoryId.getId();
    }

    public void setToken(String token) {
        categoryId.setToken(token);
    }

    public String getToken() {
        return categoryId.getToken();
    }


    @Setter
    @Getter
    @Embeddable
    static class CategoryId implements Serializable {
        @Column(nullable = false, updatable=false)
        long id;
        @Column(length = 40, nullable = false, updatable=false)
        String token;

        public CategoryId(long id, String token) {
            this.id = id;
            this.token = token;
        }

        public CategoryId() {
        }
    }
}
