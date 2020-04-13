package com.easywaldo.book.springboot.domain.products;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name="category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_no")
    private Integer id;

    @Column(name = "category_name")
    private String Name;
}
