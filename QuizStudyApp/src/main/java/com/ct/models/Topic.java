package com.ct.models;

import java.util.Objects;

public class Topic {
    private Integer topic_id;
    private String topic;

    public Topic(String topic) {
        this.topic = topic;
    }

    public Topic(Integer topic_id, String topic) {
        this.topic_id = topic_id;
        this.topic = topic;
    }

    public Integer getTopic_id() {
        return topic_id;
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
        return Objects.equals(topic_id, topic1.topic_id) && Objects.equals(topic, topic1.topic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topic_id, topic);
    }

    @Override
    public String toString() {
        return "Topic{" +
                "topic_id=" + topic_id +
                ", topic='" + topic + '\'' +
                '}';
    }
}
