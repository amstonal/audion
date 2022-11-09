package lv.merrill.audion.resource;

import lv.merrill.audion.domain.EventService;
import lv.merrill.audion.domain.Location;
import lv.merrill.audion.domain.Site;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CampaignResource {

    public CampaignResource(EventService eventService) {
        this.eventService = eventService;
    }

    private EventService eventService;

    @GetMapping("/campaign/event")
    public ResponseEntity<List<Site>> events(List<InterrestingPoint> interrestingPoints) {

        List<Location> locations = interrestingPoints.stream().map(InterrestingPoint::asLocation).collect(Collectors.toList());

        List<Site> sites = eventService.regroupBy(locations);

        return ResponseEntity.ok(sites);
    }
}
