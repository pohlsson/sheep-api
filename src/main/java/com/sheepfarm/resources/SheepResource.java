package com.sheepfarm.resources;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import com.sheepfarm.api.Sheep;
import com.sheepfarm.database.SheepDao;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/sheep")
@Produces(APPLICATION_JSON)

public class SheepResource {

    private SheepDao dao;

    public SheepResource(SheepDao dao) {
        this.dao = dao;
    }

    @PUT
    public void createSheep(Sheep sheep) {
        dao.insertSheep(sheep);
    }
}