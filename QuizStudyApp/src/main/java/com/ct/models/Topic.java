package com.ct.models;

import java.util.Objects;

public class Topic {

    private Long id;
    private String topic;

    public Topic(Long id, String topic) {
        this.id = id;
        this.topic = topic;
    }

    public Topic(String topic) {
        this.topic = topic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Topic topic1 = (Topic) o;
        return Objects.equals(id, topic1.id) && Objects.equals(topic, topic1.topic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, topic);
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", topic='" + topic + '\'' +
                '}';
    }
}
