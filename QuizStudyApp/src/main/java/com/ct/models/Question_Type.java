package com.ct.models;

import java.util.Objects;

public class Question_Type {

    private Integer type_id;
    private String type;

    public Question_Type(String type) {
        this.type = type;
    }

    public Question_Type(Integer type_id, String type) {
        this.type_id = type_id;
        this.type = type;
    }

    public Integer getType_id() {
        return type_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question_Type that = (Question_Type) o;
        return Objects.equals(type_id, that.type_id) && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type_id, type);
    }

    @Override
    public String toString() {
        return "Question_Type{" +
                "type_id=" + type_id +
                ", type='" + type + '\'' +
                '}';
    }
}
