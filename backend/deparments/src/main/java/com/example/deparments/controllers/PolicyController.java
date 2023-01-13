package com.example.deparments.controllers;

import com.example.deparments.dto.PolicyDto;
import com.example.deparments.entities.City;
import com.example.deparments.entities.Country;
import com.example.deparments.entities.Policy;
import com.example.deparments.entities.PolicyType;
import com.example.deparments.exceptions.ResourceNotFoundException;
import com.example.deparments.services.IPolicyService;
import com.example.deparments.services.IPolicyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RequestMapping("/politicas")
public class PolicyController {

    @Autowired
    private IPolicyService policyService;
    @Autowired
    private IPolicyTypeService policyTypeService;

    @GetMapping
    public ResponseEntity<List<Policy>> getPolicies() {
        List<Policy> policies = policyService.getPolicies();
        return ResponseEntity.ok( policies );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Policy> getPolicyById(@PathVariable("id") Long id)
            throws ResourceNotFoundException {
        Optional<Policy> policy = policyService.getPolicyById(id);
        if ( policy.isPresent() ) {
            return ResponseEntity.ok( policy.get() );
        } else {
            throw new ResourceNotFoundException("The policy was not found");
        }
    }

    @GetMapping("/nombre")
    public ResponseEntity<Policy> getPolicyByName(@RequestParam String name)
            throws ResourceNotFoundException {
        Optional<Policy> policy = policyService.getPolicyByName(name);
        if ( policy.isPresent() ) {
            return ResponseEntity.ok( policy.get() );
        } else {
            throw new ResourceNotFoundException("There is not any policy with the specified name");
        }
    }

    @PostMapping
    public ResponseEntity<Policy> savePolicy(@RequestBody PolicyDto policyDto)
            throws ResourceNotFoundException {
        String policyName = policyDto.getPolicyName();
        String policyType = policyDto.getPolicyType();
        Optional<PolicyType> policyTypeByName = policyTypeService.getPolicyTypeByDescription(policyType);

        if ( policyTypeByName.isPresent() ) {
            Policy policyToBeAdded = new Policy(policyName, policyTypeByName.get());
            return ResponseEntity.ok( policyService.savePolicy(policyToBeAdded) );
        } else {
            throw new ResourceNotFoundException("The policy type does not exist in the DB. Please try again");
        }
    }

    @PutMapping
    public ResponseEntity<Policy> updatePolicy(@RequestBody Policy policy)
            throws ResourceNotFoundException {
        Optional<Policy> searchedPolicy = policyService.getPolicyById( policy.getId() );
        if ( searchedPolicy.isPresent() ) {
            return ResponseEntity.ok( policyService.updatePolicy(policy) );
        } else {
            throw new ResourceNotFoundException("The policy was not found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePolicy(@PathVariable("id") Long id)
            throws ResourceNotFoundException {
        Optional<Policy> searchedPolicy = policyService.getPolicyById(id);
        if ( searchedPolicy.isPresent() ) {
            policyService.deletePolicy(id);
            return ResponseEntity.ok("The policy with ID: " + id + " was deleted successfully");
        } else {
            throw new ResourceNotFoundException("The policy was not found");
        }
    }

}
