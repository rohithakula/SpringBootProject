package com.example.Foodorderapp.exceptions;

import java.time.LocalDateTime;

public class ErrorDetails {
    private LocalDateTime localDateTime;
    private String message;
    private String details;

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ErrorDetails)) {
            return false;
        } else {
            ErrorDetails other = (ErrorDetails)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label47: {
                    Object this$localDateTime = this.getLocalDateTime();
                    Object other$localDateTime = other.getLocalDateTime();
                    if (this$localDateTime == null) {
                        if (other$localDateTime == null) {
                            break label47;
                        }
                    } else if (this$localDateTime.equals(other$localDateTime)) {
                        break label47;
                    }

                    return false;
                }

                Object this$message = this.getMessage();
                Object other$message = other.getMessage();
                if (this$message == null) {
                    if (other$message != null) {
                        return false;
                    }
                } else if (!this$message.equals(other$message)) {
                    return false;
                }

                Object this$details = this.getDetails();
                Object other$details = other.getDetails();
                if (this$details == null) {
                    if (other$details != null) {
                        return false;
                    }
                } else if (!this$details.equals(other$details)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ErrorDetails;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $localDateTime = this.getLocalDateTime();
        result = result * 59 + ($localDateTime == null ? 43 : $localDateTime.hashCode());
        Object $message = this.getMessage();
        result = result * 59 + ($message == null ? 43 : $message.hashCode());
        Object $details = this.getDetails();
        result = result * 59 + ($details == null ? 43 : $details.hashCode());
        return result;
    }

    public String toString() {
        return "ErrorDetails(localDateTime=" + this.getLocalDateTime() + ", message=" + this.getMessage() + ", details=" + this.getDetails() + ")";
    }

    public ErrorDetails(final LocalDateTime localDateTime, final String message, final String details) {
        this.localDateTime = localDateTime;
        this.message = message;
        this.details = details;
    }

    public ErrorDetails() {
    }
}

