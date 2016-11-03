package com.feel.webCrawler;

/**
 * Created by admin-pc on 2016/11/3.
 */
public class RuleException extends RuntimeException {
    public RuleException() {
        super();

    }

    public RuleException(String message, Throwable cause) {
        super(message, cause);
    }

    public RuleException(String message) {
        super(message);
    }

    public RuleException(Throwable cause) {
        super(cause);
    }
}
