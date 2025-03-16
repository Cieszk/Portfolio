package pl.cieszk.portfolio.features.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.cieszk.portfolio.features.project.model.Project;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    @Query("SELECT DISTINCT p FROM Project p LEFT JOIN FETCH p.technologies LEFT JOIN FETCH p.screenshots")
    List<Project> findAllWithRelationships();
}
