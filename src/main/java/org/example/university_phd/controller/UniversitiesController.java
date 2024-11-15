package org.example.university_phd.controller;

import org.example.university_phd.dto.UniversityDTO;
import org.example.university_phd.model.University;
import org.example.university_phd.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UniversitiesController {

    @Autowired
    private UniversityService universityService;

    @GetMapping("/universities")
    public Page<UniversityDTO> getUniversitiesPage(
            @RequestParam(defaultValue = "0") Integer offset,
            @RequestParam(defaultValue = "10") Integer limit
    ) {
        return universityService.getUniversities(PageRequest.of(offset, limit));
    }

    @PutMapping("/universities/{id}")
    public UniversityDTO putUniversity(@PathVariable String id, @RequestBody UniversityDTO newUniversity) {
        newUniversity.setId(id);
        return universityService.createUniversity(newUniversity);
    }

    @GetMapping("/universities/{id}")
    public UniversityDTO getUniversity(@PathVariable String id) {
        return universityService.getUniversity(id);
    }

    @PostMapping("/universities")
    public UniversityDTO postUniversity(@RequestBody UniversityDTO newUniversity) {
        return universityService.createUniversity(newUniversity);
    }

    @DeleteMapping("/universities/{id}")
    public void deleteUniversity(@PathVariable String id) {
        universityService.deleteUniversity(id);
    }

    @GetMapping("/universities/count")
    public long getUniversityCount() {
        return universityService.countUniversities();
    }



}
