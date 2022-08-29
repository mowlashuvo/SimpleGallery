package com.example.appinionsimplegalleryapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Social implements Serializable
{

    @SerializedName("instagram_username")
    @Expose
    private String instagramUsername;
    @SerializedName("portfolio_url")
    @Expose
    private String portfolioUrl;
    @SerializedName("twitter_username")
    @Expose
    private String twitterUsername;
    @SerializedName("paypal_email")
    @Expose
    private Object paypalEmail;
    private final static long serialVersionUID = 6297266660988617952L;

    public String getInstagramUsername() {
        return instagramUsername;
    }

    public void setInstagramUsername(String instagramUsername) {
        this.instagramUsername = instagramUsername;
    }

    public String getPortfolioUrl() {
        return portfolioUrl;
    }

    public void setPortfolioUrl(String portfolioUrl) {
        this.portfolioUrl = portfolioUrl;
    }

    public String getTwitterUsername() {
        return twitterUsername;
    }

    public void setTwitterUsername(String twitterUsername) {
        this.twitterUsername = twitterUsername;
    }

    public Object getPaypalEmail() {
        return paypalEmail;
    }

    public void setPaypalEmail(Object paypalEmail) {
        this.paypalEmail = paypalEmail;
    }

}
