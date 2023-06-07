package com.smallbiz.hkexapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.smallbiz.hkexapi.entity.Announcement;

public interface AnnouncementRepository extends PagingAndSortingRepository<Announcement, Integer> {

	Page<Announcement> findAllByInstrumentCode(String instrumentCode, Pageable pageable);
	
	Page<Announcement> findAllByInstrumentCodeAndType(String instrumentCode, String type, Pageable pageable);
	
}
