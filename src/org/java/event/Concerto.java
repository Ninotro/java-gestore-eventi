package org.java.event;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento {
    LocalTime time;
    BigDecimal price;


    public Concerto(String title, LocalDate date, int maxPlace , int ora, int minuti,BigDecimal price) throws IllegalArgumentException {
        super(title, date, maxPlace);
        this.time = LocalTime.of(ora,minuti);
        this.price= price;

    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        DecimalFormat priceFormatter = new DecimalFormat("##.##€");

        String formatterData = getDate().format(dateFormatter);
        String formatterTime=  timeFormatter.format(time);
        String formatterPrice = priceFormatter.format(price);

        return formatterData + "-" + formatterTime + "-" + getTitle() + "-" + formatterPrice;
    }
}
