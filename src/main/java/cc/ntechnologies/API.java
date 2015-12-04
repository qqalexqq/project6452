package cc.ntechnologies;

import java.util.List;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import cc.ntechnologies.entities.Speaker;
import cc.ntechnologies.dao.SpeakerDao;

@Api(name="api", version = "v3", namespace = @ApiNamespace(ownerDomain="project645-2.appspot.com", ownerName="ntech", packagePath=""))
public class API {
    private SpeakerDao speakerDao = new SpeakerDao();

    @ApiMethod(name = "getAllSpeakers")
    public List<Speaker> allUsers() {
        return speakerDao.getAll();
    }

    @ApiMethod(name="insertTestSpeaker")
    public Speaker insertTestSpeaker() {
        return speakerDao.save(new Speaker("John", "Smith", "Some of those speaking guys we have."));
    }
}
