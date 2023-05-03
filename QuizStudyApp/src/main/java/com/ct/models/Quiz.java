package com.ct.models;

import java.time.LocalDateTime;
import java.util.Objects;

public class Quiz {

    private Integer quiz_id;
    private String quiz_name;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private Integer topic_id;

    public Quiz(String quiz_name, Integer topic_id) {
        this.quiz_name = quiz_name;
        this.topic_id = topic_id;
    }

    public Quiz(Integer quiz_id, String quiz_name, LocalDateTime created_at, LocalDateTime updated_at, Integer topic_id) {
        this.quiz_id = quiz_id;
        this.quiz_name = quiz_name;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.topic_id = topic_id;
    }

    public String getQuiz_name() {
        return quiz_name;
    }

    public void setQuiz_name(String quiz_name) {
        this.quiz_name = quiz_name;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public Integer getQuiz_id() {
        return quiz_id;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public Integer getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(Integer topic_id) {
        this.topic_id = topic_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quiz quiz = (Quiz) o;
        return Objects.equals(quiz_id, quiz.quiz_id) && Objects.equals(quiz_name, quiz.quiz_name) && Objects.equals(created_at, quiz.created_at) && Objects.equals(updated_at, quiz.updated_at) && Objects.equals(topic_id, quiz.topic_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quiz_id, quiz_name, created_at, updated_at, topic_id);
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "quiz_id=" + quiz_id +
                ", quiz_name='" + quiz_name + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", topic_id=" + topic_id +
                '}';
    }
}
