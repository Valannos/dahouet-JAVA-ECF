/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afpa.dahouet.model;

import java.util.Date;

/**
 *
 * @author Valannos
 */
public class Regate {
    
    private String id;
    private Date date;
    private double distance;
    private Challenge challenge;

    public Regate(String id, Date date, double distance, Challenge challenge) {
        this.id = id;
        this.date = date;
        this.distance = distance;
        this.challenge = challenge;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }


    
    
    
    
    
}
