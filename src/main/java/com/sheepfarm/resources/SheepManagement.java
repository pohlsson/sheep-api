package com.sheepfarm.resources;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import com.google.inject.Inject;
import com.sheepfarm.api.Sheep;
import com.sheepfarm.database.SheepDao;
import javax.inject.Named;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/sheep")
@Produces(APPLICATION_JSON)

public class SheepManagement {

    @Inject @Named("sheepDao")
    private SheepDao dao;

    public SheepManagement() {
    }

    @PUT
    public void createSheep(Sheep sheep) {
        this.dao.insertSheep(sheep);
    }
}