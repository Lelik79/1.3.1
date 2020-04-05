package com.example.a131;

public class Pressure {

    private int upPressure;
    private int downPressure;
    private int pulse;
    private boolean tachycardia;
    private String date;

    public Pressure(int upPressure, int downPressure, int pulse, boolean tachycardia, String date) {
        this.upPressure = upPressure;
        this.downPressure = downPressure;
        this.pulse = pulse;
        this.tachycardia = tachycardia;
        this.date = date;
    }

    @Override
    public String toString() {
        String t;
        t = (tachycardia) ? ", Тахикардия!" : "";
        return "Показатели давления на дату "+date+": "+"верхнее "+upPressure+", нижнее "+downPressure+", пульс "+pulse+""+t;
    }
}