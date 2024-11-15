package org.example.university_phd.service;

import org.example.university_phd.dto.UniversityDTO;
import org.example.university_phd.model.University;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UniversityService {

    long countUniversities();
    Page<UniversityDTO> pageUniversitiesMatchingAll(UniversityDTO universityDto, Pageable pageable);
    UniversityDTO createUniversity(UniversityDTO universityDto);
    UniversityDTO getUniversity(String id);
    void deleteUniversity(String id);
    void saveAllUniversities(List<UniversityDTO> universitiesDto);
    Page<UniversityDTO> getUniversities(Pageable pageable);

}
