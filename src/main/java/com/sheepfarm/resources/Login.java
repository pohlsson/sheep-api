package com.sheepfarm.resources;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import com.sheepfarm.api.Sheep;
import com.sheepfarm.api.UserData;
import com.sheepfarm.database.SheepDao;
import java.util.Collections;
import java.util.List;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/login")
@Produces(APPLICATION_JSON)
public class Login {

    private SheepDao dao;

    public Login(SheepDao dao) {
        this.dao = dao;
    }

    @PUT
    public List<Sheep> authenticate(UserData userData) {
        if(userIsAuthenticated(userData)) {
            return dao.selectSheepByOwner(userData.getUsername());
        }
        return Collections.emptyList();
    }

    private boolean userIsAuthenticated(UserData userData) {
        return true;
    }
}
