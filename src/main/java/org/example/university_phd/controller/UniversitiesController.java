package org.example.university_phd.controller;

import org.example.university_phd.model.University;
import org.example.university_phd.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UniversitiesController {

    @Autowired
    private UniversityService universityService;

    @GetMapping("/universities")
    public Page<University> getUniversitiesPage(
            @RequestParam(defaultValue = "0") Integer offset,
            @RequestParam(defaultValue = "10") Integer limit
    ) {
        return universityService.getUniversities(PageRequest.of(offset, limit));
    }

}
