package com.example.deparments.services;

import com.example.deparments.entities.Policy;

import java.util.List;
import java.util.Optional;

public interface IPolicyService {
    List<Policy> getPolicies();
    Optional<Policy> getPolicyById(Long id);
    Optional<Policy> getPolicyByName(String name);
    Policy savePolicy(Policy policy);
    Policy updatePolicy(Policy policy);
    void deletePolicy(Long id);
}
