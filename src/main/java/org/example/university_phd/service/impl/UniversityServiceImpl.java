package org.example.university_phd.service.impl;

import org.example.university_phd.model.University;
import org.example.university_phd.repo.UniversityRepository;
import org.example.university_phd.service.UniversityService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityServiceImpl implements UniversityService {

    private final UniversityRepository universityRepo;

    public UniversityServiceImpl(UniversityRepository universityRepo) {
        this.universityRepo = universityRepo;
    }

    @Override
    public long countUniversities() {
        return universityRepo.count();
    }

    @Override
    public Page<University> pageUniversitiesMatchingAll(University university, Pageable pageable) {
        ExampleMatcher matcher = ExampleMatcher.matchingAll();
        Page<University> universities = universityRepo.findAll(Example.of(university, matcher), pageable);
        return universities;
    }

    @Override
    public University createUniversity(University university) {
        universityRepo.save(university);
        return university;
    }

    @Override
    public University getUniversity(String id) {
        return universityRepo.findById(id).orElseThrow(()->new RuntimeException("university not found"));
    }

    @Override
    public void deleteUniversity(String id) {
        universityRepo.deleteById(id);
    }

    @Override
    public void deleteAllUniversities() {
        universityRepo.deleteAll();
    }

    @Override
    public void saveAllUniversities(List<University> universities) {
        universityRepo.saveAll(universities);
    }
}
