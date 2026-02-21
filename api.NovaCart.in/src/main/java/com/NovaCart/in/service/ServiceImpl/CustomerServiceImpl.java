package com.NovaCart.in.service.ServiceImpl;

import com.NovaCart.in.dto.CustomerDto;
import com.NovaCart.in.entity.CustomersEntity;
import com.NovaCart.in.repository.CustomerRepository;
import com.NovaCart.in.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {


    private  final CustomerRepository customerRepository;

    private final ModelMapper modelMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        CustomersEntity customersEntity=modelMapper.map(customerDto,CustomersEntity.class);
        CustomersEntity savedUser=customerRepository.save(customersEntity);
        return modelMapper.map(savedUser,CustomerDto.class);
    }
}
