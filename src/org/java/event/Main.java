package org.java.event;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("Inserisca il titolo dell'evento");
            String title = scan.nextLine();
            System.out.println("Inserisca la data dell'evento in formato yyyy-MM-dd");
            LocalDate date = LocalDate.parse(scan.nextLine());
            System.out.println("Inserisca la capienza massima che può contenere l'evento");
            int maxPlace = Integer.parseInt(scan.nextLine());
            Evento evento1 = new Evento(title, date, maxPlace);

            System.out.println("Vuole prenotare? y/n");
            String answer = scan.nextLine();
            if (answer.equalsIgnoreCase("y")) {
                System.out.println("Quante prenotazioni vuole effettuare");
                int bookPlace = Integer.parseInt(scan.nextLine());
                try {
                    evento1.BookPlace(bookPlace);
                } catch (IllegalArgumentException e) {
                    System.out.println("Errore: " + e.getMessage());
                }
            } else {
                System.out.println("La ringraziamo per aver inserito l'evento");
            }

            System.out.println("Vuole disdire dei posti? y/n");
            String answer2 = scan.nextLine();

            if (answer2.equalsIgnoreCase("y")) {
                System.out.println("Quante prenotazioni vuole disdire");
                int removePlace = Integer.parseInt(scan.nextLine());
                try {
                    evento1.removePlace(removePlace);
                } catch (IllegalArgumentException e) {
                    System.out.println("Errore: " + e.getMessage());
                }
            }
        } catch (DateTimeException e) {
            System.out.println("Errore: Formato data non valido");
        } catch (NumberFormatException e) {
            System.out.println("Errore: Formato numero non valido");
        } finally {
            scan.close();
        }

        Concerto concerto1 = new Concerto("Vasco Rossi", LocalDate.parse("2023-12-15"), 2000, 20, 30, new BigDecimal("20.30"));
        System.out.println(concerto1);
    }
    }
