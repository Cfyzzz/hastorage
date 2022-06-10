package ru.nedovizin.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Category {
    private long id;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long uid;
    private int priority;
    private String period;
    private String type;
    private int color;
    private String categoryName;
    private int exposed;
    private int reserved;
    private int planned;
    private String token;
}
