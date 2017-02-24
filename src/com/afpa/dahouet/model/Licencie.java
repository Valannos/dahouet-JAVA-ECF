/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afpa.dahouet.model;

import com.afpa.dahouet.MismatchYearsException;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Afpa
 */
public class Licencie extends Personne {

    private int numLicence;
    private double pointsFFV;
    private int anneeLicence;

    public double calculPoints(Date date, double newPts) throws MismatchYearsException {

        double total = this.pointsFFV;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        if (cal.get(Calendar.YEAR) != this.anneeLicence) {

            throw new MismatchYearsException("L\' année courante ne correspond pas à celle de la licence");

        } else {

            total += newPts;

        }

        return total;
    }

    public Licencie(int numLicence, double pointsFFV, int anneeLicence, String name, String firstname, String email, int anneeNaissance) {
        super(name, firstname, email, anneeNaissance);
        this.numLicence = numLicence;
        this.pointsFFV = pointsFFV;
        this.anneeLicence = anneeLicence;
    }

    @Override
    public String toString() {

        return "Licencie{" + "numLicence=" + numLicence + ", pointsFFV=" + pointsFFV + ", anneeLicence=" + anneeLicence + ", " + super.toString();
    }

}
