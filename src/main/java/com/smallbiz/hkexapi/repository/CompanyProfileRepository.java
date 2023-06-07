package com.smallbiz.hkexapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.smallbiz.hkexapi.entity.CompanyProfile;

public interface CompanyProfileRepository extends CrudRepository<CompanyProfile, String> {
	
}
