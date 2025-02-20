package pl.cieszk.portfolio.features.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.cieszk.portfolio.features.project.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
