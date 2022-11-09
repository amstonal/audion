package lv.merrill.audion.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;


public class EventServiceTest {

    private EventService eventService;

    private final EventRepository eventRepository = mock(EventRepository.class);

    @BeforeEach
    public void before(){
        eventService = new EventService(eventRepository);
    }

    @Test
    public void regroup_by_events_sites_and_by_event_type(){
        BDDMockito.given(eventRepository.findForCampaign()).willReturn(events());

        List<Site> regroupedEvents = eventService.regroupBy(List.of(new Location("chatelet", "48.86", "12.35"),
                new Location("Arc de triomphe", "48.86", "16.35")));

        assertThat(regroupedEvents).containsExactlyInAnyOrder(new Site("chatelet", "48.86", "12.35", 2, 1),
                new Site("Arc de triomphe", "48.86", "16.35", 1, 0));
    }

    private static List<Event> events() {
        return List.of(
                  new Event("48.86234563456456", "12.354563457843563", "imp")
                , new Event("48.86345456456067", "12.353456456345634", "imp")
                , new Event("48.86435634564345", "12.353657745634563", "click")
                , new Event("48.86345787895334", "16.353456453645642", "imp")
                , new Event("48.89111120713999", "2.2328462923715444", "click")
                , new Event("48.89111120713999", "2.4204737962258305", "click")
                , new Event("48.85038737901075", "2.3560000045456453", "click")
                , new Event("48.86339618816508", "2.4214870126092594", "imp"));
    }

}
