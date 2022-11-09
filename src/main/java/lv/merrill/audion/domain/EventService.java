package lv.merrill.audion.domain;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EventService {

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    private EventRepository eventRepository;

    public List<Site> regroupBy(List<Location> location) {
        List<Event> events = eventRepository.findForCampaign();
        List<Site> sites = new ArrayList<>();
        for (Location l : location) {
            List<Event> locationEvents = new ArrayList<>();

            for (Event e : events) {
                if (e.nearTo(l.latitude, l.longitude)) {
                    locationEvents.add(e);
                }
            }
            int impressions = (int) locationEvents.stream().filter(event -> "imp".equals(event.type)).count();
            int clicks = (int) locationEvents.stream().filter(event -> "click".equals(event.type)).count();
            Site site = new Site(l.name, l.latitude, l.longitude, impressions, clicks);
            sites.add(site);
        }

        return sites;
    }
}
