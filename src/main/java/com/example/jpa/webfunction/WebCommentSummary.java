package com.example.jpa.webfunction;

import org.springframework.beans.factory.annotation.Value;

public interface WebCommentSummary {

    String getComment();

    int getUp();

    int getDown();

    default String getVotes() {
        return getUp() + " " + getDown();
    }
}
