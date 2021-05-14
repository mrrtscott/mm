package com.quizleafgroup.quizleaf.repository

import com.quizleafgroup.quizleaf.model.Question
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface QuestionRepo :JpaRepository<Question, Int> {



    @Query("SELECT p FROM Question p WHERE LOWER(p.group) = (:group)")
    fun findByGroup(@Param("group") group: Int): List<Question?>?

}