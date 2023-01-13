package com.example.deparments.services;

import com.example.deparments.entities.PolicyType;
import com.example.deparments.repositories.IPolicyTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolicyTypeServiceImp implements IPolicyTypeService {

    @Autowired
    private IPolicyTypeRepository policyTypeRepository;

    @Override
    public List<PolicyType> getPolicyTypes() {
        return policyTypeRepository.findAll();
    }

    @Override
    public Optional<PolicyType> getPolicyTypeById(Long id) {
        return policyTypeRepository.findById(id);
    }

    @Override
    public Optional<PolicyType> getPolicyTypeByDescription(String description) {
        return policyTypeRepository.findByDescripcion(description);
    }

    @Override
    public PolicyType savePolicyType(PolicyType policyType) {
        return policyTypeRepository.save(policyType);
    }

    @Override
    public PolicyType updatePolicyType(PolicyType policyType) {
        return policyTypeRepository.save(policyType);
    }

    @Override
    public void deletePolicyType(Long id) {
        policyTypeRepository.deleteById(id);
    }
}
