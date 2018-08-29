package com.model;

public class PingAnalyticResponse {

    private String url;
    private Float min;
    private Float max;
    private Float avg;
    private Float stddev;

    public Float getMin() {
        return min;
    }

    public void setMin(Float min) {
        this.min = min;
    }

    public Float getMax() {
        return max;
    }

    public void setMax(Float max) {
        this.max = max;
    }

    public Float getAvg() {
        return avg;
    }

    public void setAvg(Float avg) {
        this.avg = avg;
    }

    public Float getStddev() {
        return stddev;
    }

    public void setStddev(Float stddev) {
        this.stddev = stddev;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
