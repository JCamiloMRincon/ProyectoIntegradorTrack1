package com.example.deparments.services;

import com.example.deparments.entities.PolicyType;

import java.util.List;
import java.util.Optional;
public interface IPolicyTypeService {
    List<PolicyType> getPolicyTypes();
    Optional<PolicyType> getPolicyTypeById(Long id);
    Optional<PolicyType> getPolicyTypeByDescription(String description);
    PolicyType savePolicyType(PolicyType policyType);
    PolicyType updatePolicyType(PolicyType policyType);
    void deletePolicyType(Long id);
}
