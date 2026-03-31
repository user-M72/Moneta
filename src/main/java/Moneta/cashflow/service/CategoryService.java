package Moneta.cashflow.service;

import Moneta.cashflow.dto.category.CategoryReqDto;
import Moneta.cashflow.dto.category.CategoryResDto;

import java.util.List;
import java.util.UUID;

public interface CategoryService {

    List<CategoryResDto> get();

    CategoryResDto getById(UUID id);

    CategoryResDto create(CategoryReqDto dto);

    CategoryResDto update(UUID id, CategoryReqDto dto);

    void delete(UUID id);
}
