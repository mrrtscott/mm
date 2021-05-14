package com.quizleafgroup.quizleaf.service

import com.quizleafgroup.quizleaf.model.Question
import com.quizleafgroup.quizleaf.model.QuestionForm
import com.quizleafgroup.quizleaf.model.Results
import com.quizleafgroup.quizleaf.repository.QuestionRepo
import com.quizleafgroup.quizleaf.repository.ResultRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import java.util.*


@Service
class QuizService {

    @Autowired
    var question: Question? = null

    @Autowired
    var qForm: QuestionForm? = null

    @Autowired
    var qRepo: QuestionRepo? = null

    @Autowired
    var result: Results? = null

    @Autowired
    var rRepo: ResultRepo? = null


    fun getQuestions(): QuestionForm? {
        val allQues = qRepo!!.findAll()
        val qList: MutableList<Question?> = ArrayList()
        val random = Random()
        for (i in 0..4) {
            val rand: Int = random.nextInt(allQues.size)
            qList.add(allQues[rand])
            allQues.removeAt(rand)
        }
        qForm!!.setQuestions(qList)
        return qForm
    }


    fun getResult(qForm: QuestionForm): Int {
        var correct = 0
        for (q in qForm.getQuestions()!!) if (q!!.getAns() === q!!.getChose()) correct++
        return correct
    }

    fun saveScore(result: Results) {
        val saveResult = Results()
        saveResult.setUsername(result.getUsername())
        saveResult.setTotalCorrect(result.getTotalCorrect())
        rRepo!!.save<Results>(saveResult)
    }

    fun getTopScore(): List<Results?>? {
        return rRepo!!.findAll(Sort.by(Sort.Direction.DESC, "totalCorrect"))
    }


}