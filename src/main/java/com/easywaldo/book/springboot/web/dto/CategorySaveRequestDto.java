package com.easywaldo.book.springboot.web.dto;

import com.easywaldo.book.springboot.domain.products.Category;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.omg.CORBA.INTERNAL;

@Getter
@NoArgsConstructor
public class CategorySaveRequestDto {
    private String name;
    private Integer depthNo;
    private Integer parentNo;

    @Builder
    public CategorySaveRequestDto (
            String name,
            Integer depthNo,
            Integer parentNo) {
        this.name = name;
        this.depthNo = depthNo;
        this.parentNo = parentNo;
    }

    public Category toEntity() {
        return Category.builder()
                .name(name)
                .parentNo(parentNo)
                .depthNo(depthNo)
                .build();
    }

}
