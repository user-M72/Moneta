package Moneta.cashflow.mapper;

import Moneta.cashflow.dto.category.CategoryReqDto;
import Moneta.cashflow.dto.category.CategoryResDto;
import Moneta.cashflow.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {

    CategoryResDto toDto(Category category);

    Category toEntity(CategoryReqDto dto);
}
