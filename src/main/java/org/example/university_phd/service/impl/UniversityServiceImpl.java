package org.example.university_phd.service.impl;

import org.example.university_phd.dto.UniversityDTO;
import org.example.university_phd.model.University;
import org.example.university_phd.repo.UniversityRepository;
import org.example.university_phd.service.UniversityService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UniversityServiceImpl implements UniversityService {

    private final UniversityRepository universityRepo;
    private final ModelMapper modelMapper;

    @Autowired
    public UniversityServiceImpl(UniversityRepository universityRepo, ModelMapper modelMapper) {
        this.universityRepo = universityRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public long countUniversities() {
        return universityRepo.count();
    }

    @Override
    public Page<UniversityDTO> pageUniversitiesMatchingAll(UniversityDTO universityDto, Pageable pageable) {
        University university = modelMapper.map(universityDto, University.class);
        ExampleMatcher matcher = ExampleMatcher.matchingAll();
        Page<University> universities = universityRepo.findAll(Example.of(university, matcher), pageable);
        return universities.map(this::convertToDto);
    }

    @Override
    public UniversityDTO createUniversity(UniversityDTO universityDto) {
        University university = modelMapper.map(universityDto, University.class);
        University savedUniversity = universityRepo.save(university);
        return convertToDto(savedUniversity);
    }

    @Override
    public UniversityDTO getUniversity(String id) {
        University university = universityRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("University not found"));
        return convertToDto(university);
    }

    @Override
    public void deleteUniversity(String id) {
        universityRepo.deleteById(id);
    }

    @Override
    public void saveAllUniversities(List<UniversityDTO> universitiesDto) {
        List<University> universities = universitiesDto.stream()
                .map(dto -> modelMapper.map(dto, University.class))
                .collect(Collectors.toList());
        universityRepo.saveAll(universities);
    }

    @Override
    public Page<UniversityDTO> getUniversities(Pageable pageable) {
        Page<University> universities = universityRepo.findAll(pageable);
        return universities.map(this::convertToDto);
    }

    private UniversityDTO convertToDto(University university) {
        UniversityDTO universityDto = modelMapper.map(university, UniversityDTO.class);
        return universityDto;
    }
}
