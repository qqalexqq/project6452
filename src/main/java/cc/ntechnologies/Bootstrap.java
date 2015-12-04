package cc.ntechnologies;

import com.googlecode.objectify.ObjectifyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cc.ntechnologies.entities.*;

public class Bootstrap {

    private static final Logger log = LoggerFactory.getLogger(Bootstrap.class);

    protected void init() {
        log.info("Starting app");

        registerEntities();
    }

    private void registerEntities() {
        log.info("Registering entities...");

        ObjectifyService.register(Conference.class);
        ObjectifyService.register(News.class);
        ObjectifyService.register(Organizer.class);
        ObjectifyService.register(Partner.class);
        ObjectifyService.register(Room.class);
        ObjectifyService.register(Speaker.class);
        ObjectifyService.register(User.class);

        log.info("Done registering entities.");
    }
}
