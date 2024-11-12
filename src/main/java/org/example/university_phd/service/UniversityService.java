package org.example.university_phd.service;

import org.example.university_phd.model.University;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UniversityService {

    long countUniversities();
    Page<University> pageUniversitiesMatchingAll(University university, Pageable pageable);
    University createUniversity(University university);
    University getUniversity(String id);
    void deleteUniversity(String id);
    void deleteAllUniversities();
    void saveAllUniversities(List<University> universities);
    Page<University> getUniversities(Pageable pageable);

}
