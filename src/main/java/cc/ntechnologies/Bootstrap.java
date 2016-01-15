package cc.ntechnologies;

import com.googlecode.objectify.ObjectifyService;
import cc.ntechnologies.entities.*;

public class Bootstrap {

    protected void init() {
        registerEntities();
    }

    private void registerEntities() {
        ObjectifyService.register(Conference.class);
        ObjectifyService.register(News.class);
        ObjectifyService.register(Organizer.class);
        ObjectifyService.register(Partner.class);
        ObjectifyService.register(Room.class);
        ObjectifyService.register(Speaker.class);
    }
}
