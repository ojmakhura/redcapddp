package bw.ub.ehealth.redcapddp.vo;

import java.util.List;

public class EventList {
    private List<Event> events;

    public EventList() {
    }

    public EventList(List<Event> events) {
        this.events = events;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
