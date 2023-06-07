package com.smallbiz.hkexapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smallbiz.hkexapi.entity.CompanyProfile;
import com.smallbiz.hkexapi.repository.CompanyProfileRepository;

@Service
public class CompanyProfileService {

	@Autowired
	private CompanyProfileRepository repository;
	
	public CompanyProfile getCompanyProfiles(String instrumentCode) {
		return repository.findById(instrumentCode).orElse(null);
	}
}
