package org.fightteam.join.samples.filter.security;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
public class JacksonOAuth2Exception {
    private String errorCode;

    private String description;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
