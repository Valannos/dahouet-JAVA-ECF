/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afpa.dahouet.model;

import java.sql.Time;

/**
 *
 * @author Valannos
 */
public class Participation {
    
    private int id;
    private Time tpsReg;
    private int scrReg;
    private Regate regate;
    private Voilier voilier;
    private Concurrent skipper;
    private CodeResultat codeResultat;

    public Participation(int id, Regate regate, Voilier voilier, Concurrent skipper) {
        this.id = id;
        this.regate = regate;
        this.voilier = voilier;
        this.skipper = skipper;
        
    }

    public Participation(int id, Time tpsReg, int scrReg, Regate regate, Voilier voilier, Concurrent skipper, CodeResultat codeResultat) {
        this.id = id;
        this.tpsReg = tpsReg;
        this.scrReg = scrReg;
        this.regate = regate;
        this.voilier = voilier;
        this.skipper = skipper;
        this.codeResultat = codeResultat;
    }
    
    
    
    
    
    
    
    
    
    
}
