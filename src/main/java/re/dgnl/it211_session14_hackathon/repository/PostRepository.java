package re.dgnl.it211_session14_hackathon.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import re.dgnl.it211_session14_hackathon.model.entity.Post;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findByIdAndIsDeletedFalse(Long id);
    Page<Post> findByIsDeletedFalse(Pageable pageable);
}