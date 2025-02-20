package pl.cieszk.portfolio.features.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.cieszk.portfolio.features.project.model.Technology;

import java.util.List;
import java.util.Optional;

@Repository
public interface TechnologyRepository extends JpaRepository<Technology, Long> {
    boolean existsByName(String name);

    List<Technology> findByProjects_Id(Long projectId);

    Optional<Technology> findByName(String name);
}
