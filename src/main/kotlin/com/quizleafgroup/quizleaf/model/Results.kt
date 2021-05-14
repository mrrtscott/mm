package com.quizleafgroup.quizleaf.model

import org.springframework.stereotype.Component
import javax.persistence.*


@Component
@Entity
@Table(name = "results")
class Results {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id = 0
    private var username: String
    private var totalCorrect = 0


    constructor(id: Int, username: String, totalCorrect: Int){
        this.id = id
        this.username = username
        this.totalCorrect = totalCorrect

    }

    constructor()

    fun getId(): Int {
        return id
    }

    fun setId(id: Int) {
        this.id = id
    }

    fun getUsername(): String? {
        return username
    }

    fun setUsername(username: String?) {
        this.username = username
    }

    fun getTotalCorrect(): Int {
        return totalCorrect
    }

    fun setTotalCorrect(totalCorrect: Int) {
        this.totalCorrect = totalCorrect
    }


}