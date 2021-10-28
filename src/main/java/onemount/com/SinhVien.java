package onemount.com;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.*;

import static java.lang.Math.round;

public class SinhVien implements Comparable<SinhVien>, Serializable {
    private int id;
    private static final String GMAIL_PATTERN = "^[\\w]+@gmail.com";
    private static final String OUTLOOK_PATTERN = "^[\\w]+@outlook.com";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getReport() {
        return report;
    }

    public void setReport(int report) {
        this.report = report;
    }

    public int getApp() {
        return app;
    }

    public void setApp(int app) {
        this.app = app;
    }

    public double getLt() {
        return lt;
    }

    public void setLt(double lt) {
        this.lt = lt;
    }

    private String name;
    private String email;
    private int bonus;
    private int report;
    private int app;
    public double lt;

    public SinhVien(int id, String name, String email, int bonus, int report, int app, double lt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.bonus = bonus;
        this.report = report;
        this.app = app;
        this.lt = lt;
    }

    public SinhVien() {
    }

    public static double tongDiem(SinhVien sv) {
        double tongDiem;
        double bonus = sv.bonus;
        double report = sv.report;
        double app = sv.app;
        tongDiem = ( ( 10* sv.bonus ) / 100 ) + ( ( 30* sv.report ) / 100 ) + ( ( 15 * sv.app ) / 100 )
                + ( ( 45 * sv.lt ) / 100 );
        return SinhVien.round(tongDiem, 1);

    }

    public boolean isGmailFormat(){

        return this.email.matches(GMAIL_PATTERN);
    }

    public boolean isOutlookFormat(){

        return this.email.matches(OUTLOOK_PATTERN);
    }

    public void addDataToArrayList(String[] splidedData) {
//        System.out
        this.id = Integer.parseInt(splidedData[0]);
        this.name = splidedData[1];
        this.email = splidedData[2];
        this.bonus = Integer.parseInt(splidedData[3]);
        this.report = Integer.parseInt(splidedData[4]);
        this.app = Integer.parseInt(splidedData[5]);
        this.lt = Double.parseDouble(splidedData[6]);

    }

    public String toString() {
        String VC = "Mã số SV : " + this.id + " - Tên SV: " + this.name
                + " - Email : " + this.email + " - Bonus : " + this.bonus
                + " - Report : " + this.report + " - App : " + this.app + " - LT : " + this.lt;
        return VC;
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    @Override
    public int compareTo(SinhVien o) {
        if(this.lt<o.lt)
            return -1;
        else if(o.lt<this.lt)
            return 1;
        return 0;
    }


}

