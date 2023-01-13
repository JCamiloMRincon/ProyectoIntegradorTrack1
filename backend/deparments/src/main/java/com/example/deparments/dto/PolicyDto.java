package com.example.deparments.dto;

import java.io.Serializable;

public class PolicyDto implements Serializable {

    private String policyName;
    private String policyType;

    public PolicyDto(String policyName, String policyType) {
        super();
        this.policyName = policyName;
        this.policyType = policyType;
    }

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }
}
