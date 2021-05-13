package com.quizleafgroup.quizleaf.model

import org.springframework.stereotype.Component

@Component
class QuestionForm {

    private var questions: List<Question?>? = null

    fun getQuestions(): List<Question?>? {
        return questions
    }

    fun setQuestions(questions: List<Question?>?) {
        this.questions = questions
    }

}