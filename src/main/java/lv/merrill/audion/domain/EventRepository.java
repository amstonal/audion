package lv.merrill.audion.domain;

import java.util.List;

public interface EventRepository {

    List<Event> findForCampaign();
}
