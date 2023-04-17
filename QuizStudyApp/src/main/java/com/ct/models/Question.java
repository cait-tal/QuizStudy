package com.ct.models;

import java.util.Objects;

public class Question {

    private Long id;
    private String text;
    // Can have between 2 - 6 options
    private Options options;
    private String answer;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String option5;
    private Topic topic;


    public Question(Long id, String text, Options options, String answer, String option1, String option2, String option3, String option4, String option5, Topic topic) {
        this.id = id;
        this.text = text;
        this.options = options;
        this.answer = answer;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.option5 = option5;
        this.topic = topic;
    }

    public Question(String text, Options options, String answer, String option1, String option2, String option3, String option4, String option5, Topic topic) {
        this.text = text;
        this.options = options;
        this.answer = answer;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.option5 = option5;
        this.topic = topic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Options getOptions() {
        return options;
    }

    public void setOptions(Options options) {
        this.options = options;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getOption5() {
        return option5;
    }

    public void setOption5(String option5) {
        this.option5 = option5;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(id, question.id) && Objects.equals(text, question.text) && options == question.options && Objects.equals(answer, question.answer) && Objects.equals(option1, question.option1) && Objects.equals(option2, question.option2) && Objects.equals(option3, question.option3) && Objects.equals(option4, question.option4) && Objects.equals(option5, question.option5) && Objects.equals(topic, question.topic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, options, answer, option1, option2, option3, option4, option5, topic);
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", options=" + options +
                ", answer='" + answer + '\'' +
                ", option1='" + option1 + '\'' +
                ", option2='" + option2 + '\'' +
                ", option3='" + option3 + '\'' +
                ", option4='" + option4 + '\'' +
                ", option5='" + option5 + '\'' +
                ", topic=" + topic +
                '}';
    }
}
