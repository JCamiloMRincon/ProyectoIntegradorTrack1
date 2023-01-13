package com.example.deparments.controllers;

import com.example.deparments.entities.Policy;
import com.example.deparments.entities.PolicyType;
import com.example.deparments.exceptions.ResourceNotFoundException;
import com.example.deparments.services.IPolicyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RequestMapping("/politicas/tipos")
public class PolicyTypeController {

    @Autowired
    private IPolicyTypeService policyTypeService;

    @GetMapping
    public ResponseEntity<List<PolicyType>> getPolicyTypes() {
        List<PolicyType> policyTypes = policyTypeService.getPolicyTypes();
        return ResponseEntity.ok( policyTypes );
    }

    @GetMapping("/{id}")
    public ResponseEntity<PolicyType> getPolicyTypeById(@PathVariable("id") Long id)
            throws ResourceNotFoundException {
        Optional<PolicyType> policyType = policyTypeService.getPolicyTypeById(id);
        if ( policyType.isPresent() ) {
            return ResponseEntity.ok( policyType.get() );
        } else {
            throw new ResourceNotFoundException("The policy type was not found");
        }
    }

    @GetMapping("/descripcion")
    public ResponseEntity<PolicyType> getPolicyTypeByDescription(@RequestParam String description)
            throws ResourceNotFoundException {
        Optional<PolicyType> policyType = policyTypeService.getPolicyTypeByDescription(description);
        if ( policyType.isPresent() ) {
            return ResponseEntity.ok( policyType.get() );
        } else {
            throw new ResourceNotFoundException("There is not any policy type with the specified description");
        }
    }
    @PostMapping
    public ResponseEntity<PolicyType> savePolicyType(@RequestBody PolicyType policyType) {
        return ResponseEntity.ok( policyTypeService.savePolicyType(policyType) );
    }

    @PutMapping
    public ResponseEntity<PolicyType> updatePolicyType(@RequestBody PolicyType policyType)
            throws ResourceNotFoundException {
        Optional<PolicyType> searchedPolicyType = policyTypeService.getPolicyTypeById( policyType.getId() );
        if ( searchedPolicyType.isPresent() ) {
            return ResponseEntity.ok( policyTypeService.updatePolicyType(policyType) );
        } else {
            throw new ResourceNotFoundException("The policy type was not found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePolicyType(@PathVariable("id") Long id)
            throws ResourceNotFoundException {
        Optional<PolicyType> searchedPolicyType = policyTypeService.getPolicyTypeById(id);
        if ( searchedPolicyType.isPresent() ) {
            policyTypeService.deletePolicyType(id);
            return ResponseEntity.ok("The policy type with ID: " + id + " was deleted successfully");
        } else {
            throw new ResourceNotFoundException("The policy type was not found");
        }
    }

}
