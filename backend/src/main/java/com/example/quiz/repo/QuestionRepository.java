package com.example.quiz.repo;

import com.example.quiz.model.Question;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    // Eager-load options for standard fetch
    @Override
    @EntityGraph(attributePaths = "options")
    List<Question> findAll();

    // Efficient random pick with options eagerly loaded (use this if you prefer)
    @Query("select distinct q from Question q left join fetch q.options order by function('rand')")
    List<Question> findRandomWithOptions(@Param("limit") int limit);
}
