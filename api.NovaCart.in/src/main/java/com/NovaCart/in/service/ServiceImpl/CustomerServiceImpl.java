package com.NovaCart.in.service.ServiceImpl;

import com.NovaCart.in.dto.CustomerDto;
import com.NovaCart.in.entity.CustomersEntity;
import com.NovaCart.in.exceptions.ResourceAlreadyExistException;
import com.NovaCart.in.repository.CustomerRepository;
import com.NovaCart.in.service.CustomerService;
import com.NovaCart.in.utils.CustomerStatus;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;

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
        customerRepository.findActiveCustomerByEmail(customerDto.getEmail())
                .ifPresent(existing -> {
                    throw new ResourceAlreadyExistException("Email already exists");
                });
        CustomersEntity customersEntity=modelMapper.map(customerDto,CustomersEntity.class);
        if(customersEntity.getCustomerStatus()==null){
            customersEntity.setCustomerStatus(CustomerStatus.ACTIVE);
        }
        CustomersEntity savedUser=customerRepository.save(customersEntity);
        return modelMapper.map(savedUser,CustomerDto.class);
    }
}
