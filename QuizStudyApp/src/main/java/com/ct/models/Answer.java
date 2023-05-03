package com.ct.models;

import java.util.Objects;

public class Answer {
    private Integer answer_id;
    private Integer question_id;
    private String answer_text;
    private Boolean is_correct;

    public Answer(Integer question_id, String answer_text, Boolean is_correct) {
        this.question_id = question_id;
        this.answer_text = answer_text;
        this.is_correct = is_correct;
    }

    public Answer(Integer answer_id, Integer question_id, String answer_text, Boolean is_correct) {
        this.answer_id = answer_id;
        this.question_id = question_id;
        this.answer_text = answer_text;
        this.is_correct = is_correct;
    }

    public Integer getAnswer_id() {
        return answer_id;
    }

    public Integer getQuestion_id() {
        return question_id;
    }

    public String getAnswer_text() {
        return answer_text;
    }

    public Boolean getIs_correct() {
        return is_correct;
    }

    public void setQuestion_id(Integer question_id) {
        this.question_id = question_id;
    }

    public void setAnswer_text(String answer_text) {
        this.answer_text = answer_text;
    }

    public void setIs_correct(Boolean is_correct) {
        this.is_correct = is_correct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return Objects.equals(answer_id, answer.answer_id) && Objects.equals(question_id, answer.question_id) && Objects.equals(answer_text, answer.answer_text) && Objects.equals(is_correct, answer.is_correct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(answer_id, question_id, answer_text, is_correct);
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answer_id=" + answer_id +
                ", question_id=" + question_id +
                ", answer_text='" + answer_text + '\'' +
                ", is_correct=" + is_correct +
                '}';
    }
}
