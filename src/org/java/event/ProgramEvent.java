package org.java.event;

import java.util.ArrayList;
import java.util.List;

public class ProgramEvent {

    private String titolo;
    private List <Evento> eventi;

    public ProgramEvent(String titolo) {
        this.titolo = titolo;
        this.eventi = new ArrayList<>();
    }

    public void addEvents(Evento evento) {
        eventi.add(evento);
    }

    public List <Evento> searchEvents(String data) {
        List <Evento> listSearch = new ArrayList<>();

        for (Evento singleEvent : eventi) {
            if (singleEvent.getDate().equals(data)) {
                listSearch.add(singleEvent);
            }
        }

        return listSearch;
    }

    public int numeroEventi() {
        return eventi.size();

    }

    public void clearEventi() {
        eventi.clear();
    }
}


