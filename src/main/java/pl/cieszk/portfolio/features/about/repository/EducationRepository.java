package pl.cieszk.portfolio.features.about.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.cieszk.portfolio.features.about.model.Education;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {
}
