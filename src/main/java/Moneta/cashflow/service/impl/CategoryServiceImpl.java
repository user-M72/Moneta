package Moneta.cashflow.service.impl;

import Moneta.cashflow.dto.category.CategoryReqDto;
import Moneta.cashflow.dto.category.CategoryResDto;
import Moneta.cashflow.mapper.CategoryMapper;
import Moneta.cashflow.repository.CategoryRepository;
import Moneta.cashflow.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;
    private final CategoryMapper mapper;

    @Override
    public List<CategoryResDto> get() {
        return List.of();
    }

    @Override
    public CategoryResDto getById(UUID id) {
        return null;
    }

    @Override
    public CategoryResDto create(CategoryReqDto dto) {
        return null;
    }

    @Override
    public CategoryResDto update(UUID id, CategoryReqDto dto) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
