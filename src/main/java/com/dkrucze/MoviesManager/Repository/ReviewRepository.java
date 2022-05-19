package com.dkrucze.MoviesManager.Repository;

import com.dkrucze.MoviesManager.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {
}
