package ru.nedovizin.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "category")
public class CategoryDTO {

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

    public CategoryDTO() {
        categoryId = new CategoryId();
    }

    public CategoryDTO(CategoryId categoryId, int priority, String period, String type, int color, String categoryName, int exposed, int reserved, int planned) {
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

    public CategoryDTO(long id, String token, int priority, String period, String type, int color, String categoryName, int exposed, int reserved, int planned) {
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

    public int getPriority() {
        return priority;
    }

    public String getPeriod() {
        return period;
    }

    public String getType() {
        return type;
    }

    public int getColor() {
        return color;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public int getExposed() {
        return exposed;
    }

    public int getReserved() {
        return reserved;
    }

    public int getPlanned() {
        return planned;
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

        public void setToken(String token) {
            this.token = token;
        }

        public void setId(long id) {
            this.id = id;
        }

        public long getId() {
            return id;
        }

        public String getToken() {
            return token;
        }
    }
}
