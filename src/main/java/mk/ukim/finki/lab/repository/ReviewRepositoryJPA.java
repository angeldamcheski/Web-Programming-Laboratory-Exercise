package mk.ukim.finki.lab.repository;

import mk.ukim.finki.lab.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReviewRepositoryJPA extends JpaRepository<Review, Long> {
    //void reviewFromTo(LocalDateTime from, LocalDateTime to);
    @Query("SELECT r FROM Review r WHERE r.timestamp BETWEEN :from AND :to")
    List<Review>findReviewsInRange(@Param("from")LocalDateTime from,  @Param("to")LocalDateTime to);
    @Override
    void deleteById(Long aLong);

    List<Review> findReviewByDescriptionContaining(String description);
}
