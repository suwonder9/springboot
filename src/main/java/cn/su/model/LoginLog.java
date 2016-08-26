package cn.su.model;

import java.util.Date;

public class LoginLog {
    private String loggername;

    private Date time;

    public String getLoggername() {
        return loggername;
    }

    public void setLoggername(String loggername) {
        this.loggername = loggername == null ? null : loggername.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}