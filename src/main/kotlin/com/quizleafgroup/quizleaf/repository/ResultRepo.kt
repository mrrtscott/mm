package com.quizleafgroup.quizleaf.repository

import com.quizleafgroup.quizleaf.model.Results
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ResultRepo: JpaRepository<Results, Int> {

}