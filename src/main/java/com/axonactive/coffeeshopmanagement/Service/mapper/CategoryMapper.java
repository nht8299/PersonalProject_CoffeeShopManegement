package com.axonactive.coffeeshopmanagement.service.mapper;

import com.axonactive.coffeeshopmanagement.service.dto.CategoryDto;
import com.axonactive.coffeeshopmanagement.entities.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDto toDto(Category category);
    List<CategoryDto> toDtos(List<Category>categories);
}
