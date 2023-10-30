package org.java.event;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {

    private String title;
    private LocalDate date;

    private int maxPlace;

    private int bookedPlace;


    public Evento(String title, LocalDate date, int maxPlace) throws IllegalArgumentException {

        if (date.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La data inserita non è valida");
        }

        if (maxPlace <= 0  ) {
            throw new IllegalArgumentException("Il numero di posti deve essere maggiore di 0");
        }
        this.title = title;
        this.date = date;
        this.maxPlace = maxPlace;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getMaxPlace() {
        return maxPlace;
    }

    public int getBookedPlace() {
        return bookedPlace;
    }

    public void BookPlace(int booked) {
        if (date.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("L'evento è gia passato");
        }

        if (bookedPlace + booked > maxPlace ) {
            throw new IllegalArgumentException("Non ci sono posti da prenotare");
        }
        bookedPlace += booked ;
        System.out.println("attualmente sono stati prenotati: " +bookedPlace + " Rimangono ancora disponibili: " + (maxPlace - bookedPlace));


    }

    public void removePlace(int booked) {
        if (date.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("L'evento è gia passato");
        }

        if (bookedPlace < booked ) {
            throw new IllegalArgumentException("Non ci sono tutti questi posti prenotati");
        }

        bookedPlace -= booked;

        System.out.println("attualmente sono stati prenotati: " +bookedPlace + " Rimangono ancora disponibili: " + (maxPlace - bookedPlace));

    }

    public String formattingData () {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return date.format(formatter);
    }

    @Override
    public String toString() {
        return "Evento: " + formattingData() + getTitle() ;

    }
}
