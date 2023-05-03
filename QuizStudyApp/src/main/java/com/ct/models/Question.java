package com.ct.models;

import java.util.Objects;

public class Question {
    private Integer question_id;
    private Integer quiz_id;
    private String question_text;
    private Integer question_type;

    public Question(Integer quiz_id, String question_text, Integer question_type) {
        this.question_text = question_text;
        this.quiz_id = quiz_id;
        this.question_type = question_type;
    }

    public Question(Integer question_id, Integer quiz_id, String question_text, Integer question_type) {
        this.question_id = question_id;
        this.quiz_id = quiz_id;
        this.question_text = question_text;
        this.question_type = question_type;
    }

    public Integer getQuestion_id() {
        return question_id;
    }

    public Integer getQuiz_id() {
        return quiz_id;
    }

    public String getQuestion_text() {
        return question_text;
    }

    public Integer getQuestion_type() {
        return question_type;
    }

    public void setQuiz_id(Integer quiz_id) {
        this.quiz_id = quiz_id;
    }

    public void setQuestion_text(String question_text) {
        this.question_text = question_text;
    }

    public void setQuestion_type(Integer question_type) {
        this.question_type = question_type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(question_id, question.question_id) && Objects.equals(quiz_id, question.quiz_id) && Objects.equals(question_text, question.question_text) && Objects.equals(question_type, question.question_type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question_id, quiz_id, question_text, question_type);
    }

    @Override
    public String toString() {
        return "Question{" +
                "question_id=" + question_id +
                ", quiz_id=" + quiz_id +
                ", question_text='" + question_text + '\'' +
                ", question_type=" + question_type +
                '}';
    }
}
