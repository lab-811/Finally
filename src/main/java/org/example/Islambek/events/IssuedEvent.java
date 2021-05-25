package org.example.Islambek.events;

import org.springframework.context.ApplicationEvent;

public class IssuedEvent extends ApplicationEvent {

    private Long userId;
    private Long bookId;

    public IssuedEvent(Object source, Long userId, Long bookId) {
        super(source);
        this.userId = userId;
        this.bookId = bookId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
}
