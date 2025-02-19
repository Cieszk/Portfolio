package pl.cieszk.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.cieszk.portfolio.model.Media;

import java.util.List;

@Repository
public interface MediaRepository extends JpaRepository<Media, Long> {
    boolean existsByUrl(String url);

    List<Media> getAllByProject_Id(Long id);
}
