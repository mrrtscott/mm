package com.quizleafgroup.quizleaf.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.mvc.support.RedirectAttributes


@Controller
class MainController {

    var result: Result
    var qService: QuizService
    var submitted: Boolean

    @ModelAttribute("result")
    fun getResult(){
        return result

    }

    @GetMapping("/")
    fun home(): String? {
        return "index.html"
    }

    @PostMapping("/quiz")
    fun quiz(@RequestParam username: String, m: Model, ra: RedirectAttributes): String? {
        if (username == "") {
            ra.addFlashAttribute("warning", "You must enter your name")
            return "redirect:/"
        }
        submitted = false
        result.setUsername(username)
        val qForm: QuestionForm = qService.getQuestions()
        m.addAttribute("qForm", qForm)
        return "quiz.html"
    }

    @PostMapping("/submit")
    fun submit(@ModelAttribute qForm: QuestionForm?, m: Model?): String? {
        if (!submitted) {
            result.setTotalCorrect(qService.getResult(qForm))
            qService.saveScore(result)
            submitted = true
        }
        return "result.html"
    }

    @GetMapping("/score")
    fun score(m: Model): String? {
        val sList: List<Result> = qService.getTopScore()
        m.addAttribute("sList", sList)
        return "scoreboard.html"
    }
}