package com.nttdata.bcp1.mscustomer.service;

import com.nttdata.bcp1.mscustomer.model.Customer;
import com.nttdata.bcp1.mscustomer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    @Qualifier("wcLoadBalanced")
    private WebClient.Builder webClientBuilder;

    @Override
    public Mono<Customer> createCust(Customer c) {
        return customerRepository.save(c);
    }

    @Override
    public Mono<Customer> findByCustId(String id) {
        return customerRepository.findById(id);
    }

    @Override
    public Flux<Customer> findAllCust() {
        return customerRepository.findAll();
    }

    @Override
    public Mono<Customer> updateCust(Customer c) {
        return customerRepository.save(c);
    }

    @Override
    public Mono<Void> deleteCust(String id) {
        return customerRepository.deleteById(id);
    }

}
