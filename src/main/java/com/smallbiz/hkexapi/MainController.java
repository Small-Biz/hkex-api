package com.smallbiz.hkexapi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.smallbiz.hkexapi.entity.Announcement;
import com.smallbiz.hkexapi.entity.CompanyProfile;
import com.smallbiz.hkexapi.repository.AnnouncementRepository;
import com.smallbiz.hkexapi.service.CompanyProfileService;
import com.smallbiz.hkexapi.utility.FormatUtility;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "*")
@RestController	// This means that this class is a Controller
@RequestMapping(path="/hkex") // This means URL's start with /demo (after Application path)
@Slf4j
public class MainController {
	@Autowired // This means to get the bean called userRepository
			   // Which is auto-generated by Spring, we will use it to handle the data
	private UserRepository userRepository;
	
	@Autowired
	private AnnouncementRepository announcementRepository;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private CompanyProfileService companyProfileService;
	
	@GetMapping(path="hello")
	public @ResponseBody String helloWorld() {
		emailService.sendEmail();
		return "Hello Wordl! Success...";
	}
	
	@PostMapping(path="/add") // Map ONLY POST Requests
	public @ResponseBody String addNewUser (@RequestParam String name
			, @RequestParam String email) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		User n = new User();
		n.setName(name);
		n.setEmail(email);
		userRepository.save(n);
		return "Saved";
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}
	

	@GetMapping(path="/getAnnouncements")
	public @ResponseBody ResponseEntity<Map<String, Object>> getAllAnnouncements(
			@RequestParam String instrumentCode,
			@RequestParam(defaultValue = "10") int numPerPage,
			@RequestParam(defaultValue = "0") int page
			) {
		
		if( numPerPage > 100 ){
			return null;
		}		
		
		try {
			List<Announcement> announcements = new ArrayList<Announcement>();
			// This returns a JSON or XML with the users
			Pageable pageable = PageRequest.of(page, numPerPage, Sort.by("uploadDate").descending().and(Sort.by("uploadTime").descending()));
			
			
			Page<Announcement> pageAnnouncement = announcementRepository.findAllByInstrumentCodeAndType(instrumentCode, "", pageable);
			announcements = pageAnnouncement.getContent();
			Map<String, Object> response = new HashMap<>();
			response.put("announcements", announcements);
			response.put("currentPage", pageAnnouncement.getNumber());
			response.put("numPerPage", numPerPage);
			response.put("totalItems", pageAnnouncement.getTotalElements());
			response.put("totalPages", pageAnnouncement.getTotalPages());
			return new ResponseEntity<>(response, HttpStatus.OK);
			
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	

	@GetMapping(path="/getAllAnnouncements")
	public @ResponseBody Iterable<Announcement> getAllAnnouncements() {
		
		return announcementRepository.findAll();
	}
	
	@GetMapping(path="/companyProfile")
	public @ResponseBody CompanyProfile getCompanyProfile(@RequestParam String instrumentCode) {
		log.info("info companyProfile");
		return companyProfileService.getCompanyProfiles(FormatUtility.fullInstrumentCode(instrumentCode));
	}
}
