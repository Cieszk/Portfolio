package pl.cieszk.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.cieszk.portfolio.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
