package cn.starteasy.core.common.adminui.backend.domain;

import cn.starteasy.core.common.domain.BaseDomain;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class AdminPersistentToken extends BaseDomain<Long> {

    private static final long serialVersionUID = 1L;

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("d MMMM yyyy");

    private static final int MAX_USER_AGENT_LEN = 255;

    private String series;

    private String tokenValue;

    private LocalDate tokenDate;

    //an IPV6 address max length is 39 characters
    private String ipAddress;

    private String userAgent;

    private Long userId;

    private String userLogin;

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getTokenValue() {
        return tokenValue;
    }

    public void setTokenValue(String tokenValue) {
        this.tokenValue = tokenValue;
    }

    public LocalDate getTokenDate() {
        return tokenDate;
    }

    public void setTokenDate(LocalDate tokenDate) {
        this.tokenDate = tokenDate;
    }

    @JsonGetter
    public String getFormattedTokenDate() {
        return DATE_TIME_FORMATTER.format(this.tokenDate);
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        if (userAgent.length() >= MAX_USER_AGENT_LEN) {
            this.userAgent = userAgent.substring(0, MAX_USER_AGENT_LEN - 1);
        } else {
            this.userAgent = userAgent;
        }
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AdminPersistentToken that = (AdminPersistentToken) o;

        if (!series.equals(that.series)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return series.hashCode();
    }

    @Override
    public String toString() {
        return "PersistentToken{" +
            "series='" + series + '\'' +
            ", tokenValue='" + tokenValue + '\'' +
            ", tokenDate=" + tokenDate +
            ", ipAddress='" + ipAddress + '\'' +
            ", userAgent='" + userAgent + '\'' +
            "}";
    }
}
