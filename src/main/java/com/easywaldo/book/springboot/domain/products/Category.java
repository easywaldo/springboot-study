package com.easywaldo.book.springboot.domain.products;

import lombok.Builder;
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

    @Column(name = "parent_no")
    private Integer ParentNo;

    @Column(name = "depth")
    private  Integer DepthNo;

    @Builder
    public Category(String name, Integer parentNo, Integer depthNo) {
        this.Name = name;
        this.ParentNo = parentNo;
        this.DepthNo = depthNo;
    }
}
