package org.example.university_phd.repo;

import org.example.university_phd.model.University;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UniversityRepository extends MongoRepository<University, String> {

    Optional<University> getByName(String universityName);
    List<University> findByType(String type);
    List<University> findByNameContaining(String universityName);
    @Query("{ 'type': ?0, 'numberOfStudents': {$gte: ?1}}")
    List<University> findUniversitiesByTypeAndNumberOfStudentsGreaterThan(String type, int numberOfStudents);
    @Query("{ 'departments': {$in: ?0}}")
    List<University> findUniversitiesByDepartments(String[] departments);
    Page<University> findByNameAndDepartmentsContaining(String name, String department, Pageable pageable);
    Slice<University> findByNameAndBuildingNumber(String name, int buildingNumber, Pageable pageable);

}
