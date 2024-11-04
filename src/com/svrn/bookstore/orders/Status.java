package com.svrn.bookstore.orders;

public enum Status {
    OPENED("Order has been opened") {
        public String getStatusDescription() {
            return "Opened";
        }
    },
    CLOSED("Order has been closed") {
        public String getStatusDescription() {
            return "Closed";
        }
    },
    COMPLETED("Order has been completed") {
        public String getStatusDescription() {
            return "Completed";
        }
    };

    Status(String message) {
        this.MESSAGE = message;
    }

    private final String MESSAGE;

    public String getMessage() {
        return MESSAGE;
    }

    public abstract String getStatusDescription();
}
