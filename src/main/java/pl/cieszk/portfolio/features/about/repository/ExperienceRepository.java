package pl.cieszk.portfolio.features.about.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.cieszk.portfolio.features.about.model.Experience;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {
}
