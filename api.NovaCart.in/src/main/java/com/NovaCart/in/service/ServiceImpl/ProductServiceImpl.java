package com.NovaCart.in.service.ServiceImpl;

import com.NovaCart.in.dto.ProductDto;
import com.NovaCart.in.entity.ProductEntity;
import com.NovaCart.in.repository.ProductRepository;
import com.NovaCart.in.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ModelMapper modelMapper;
    private  final ProductRepository productRepository;

    public ProductServiceImpl(ModelMapper modelMapper, ProductRepository productRepository) {
        this.modelMapper = modelMapper;
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        ProductEntity product=modelMapper.map(productDto,ProductEntity.class);
        ProductEntity savedProduct=productRepository.save(product);
        return modelMapper.map(savedProduct,ProductDto.class);
    }
}
