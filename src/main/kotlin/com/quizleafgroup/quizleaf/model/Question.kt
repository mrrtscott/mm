package com.quizleafgroup.quizleaf.model

import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


class Question {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var quesId = 0
    private var title: String? = null
    private var optionA: String? = null
    private var optionB: String? = null
    private var optionC: String? = null
    private var ans = 0
    private var chose = 0


    constructor(quesId: Int, title: String, optionA: String, optionB: String, optionC: String, ans: Int, chose:Int){
        this.quesId = quesId
        this.title = title
        this.optionA = optionA
        this.optionB = optionB
        this.optionC = optionC
        this.ans = ans
        this.chose = chose

    }


    fun getQuesId(): Int {
        return quesId
    }

    fun setQuesId(quesId: Int) {
        this.quesId = quesId
    }

    fun getTitle(): String? {
        return title
    }

    fun setTitle(title: String) {
        this.title = title
    }

    fun getOptionA(): String? {
        return optionA
    }

    fun setOptionA(optionA: String) {
        this.optionA = optionA
    }

    fun getOptionB(): String? {
        return optionB
    }

    fun setOptionB(optionB: String) {
        this.optionB = optionB
    }

    fun getOptionC(): String? {
        return optionC
    }

    fun setOptionC(optionC: String) {
        this.optionC = optionC
    }

    fun getAns(): Int {
        return ans
    }

    fun setAns(ans: Int) {
        this.ans = ans
    }

    fun getChose(): Int {
        return chose
    }

    fun setChose(choosed: Int) {
        this.chose = choosed
    }


    override fun toString(): String {
        return "Question [quesId=" + quesId.toString() + ", title=" + title.toString() + ", optionA=" + optionA.toString() + ", optionB=" + optionB.toString() + ", optionC=" + optionC.toString() + ", ans=" + ans.toString() + ", chose=" + chose.toString() + "]"
    }











}