package com.example.deparments.services;

import com.example.deparments.entities.Policy;
import com.example.deparments.repositories.IPolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolicyServiceImp implements IPolicyService {

    @Autowired
    private IPolicyRepository policyRepository;


    @Override
    public List<Policy> getPolicies() {
        return policyRepository.findAll();
    }

    @Override
    public Optional<Policy> getPolicyById(Long id) {
        return policyRepository.findById(id);
    }

    @Override
    public Optional<Policy> getPolicyByName(String name) {
        return policyRepository.findByNombre(name);
    }

    @Override
    public Policy savePolicy(Policy policy) {
        return policyRepository.save(policy);
    }

    @Override
    public Policy updatePolicy(Policy policy) {
        return policyRepository.save(policy);
    }

    @Override
    public void deletePolicy(Long id) {
        policyRepository.deleteById(id);
    }
}
