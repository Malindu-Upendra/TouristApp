package com.example.dashboard;

import java.io.Serializable;

public class FeedbackInsert implements Serializable {

    private String feedback;
    private String key;

    public void setKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
