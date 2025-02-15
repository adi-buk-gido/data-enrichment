package com.example.shield.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

@Repository
public class CompanyDao implements ICompanyDao {

    private Map<String, UUID> companyNameToIdMap = new HashMap<>();

    @PostConstruct
    public void init(){
        companyNameToIdMap.put("companyA", UUID.randomUUID());
        companyNameToIdMap.put("companyB", UUID.randomUUID());
        companyNameToIdMap.put("companyC", UUID.randomUUID());    }


    @Override
    public UUID getCompanyId(String companyName) {
        return companyNameToIdMap.get(companyName);
    }

}
