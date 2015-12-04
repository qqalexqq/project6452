package backend;

import java.util.List;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;

import cc.ntechnologies.entities.Speaker;


@Api(name = "myApi",
version = "v3",
namespace = @ApiNamespace(ownerDomain = "c645gr2.appspot.com",
                           ownerName = "c645gr2.appspot.com",
                           packagePath=""))

public class DataAPI {
	
	
    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "sayHi")
    public MyBean sayHi(@Named("name") String name) {
        MyBean response = new MyBean();
        response.setData("Hi, " + name);

        return response;
    }
    
    @ApiMethod(name = "getAllSpeakers")
    public List<Speaker> allUsers() {
        
        return cc.ntechnologies.dao.SpeakerDao.getAll();
    }
    
}
