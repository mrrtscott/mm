package com.quizleafgroup.quizleaf.repository

import com.quizleafgroup.quizleaf.model.Question
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface QuestionRepo :JpaRepository<Question, Int> {



    @Query("SELECT p FROM Question p WHERE (p.groupSet) = (:groupSet)")
    fun findByGroup(@Param("groupSet") groupSet: Int): List<Question?>?

}