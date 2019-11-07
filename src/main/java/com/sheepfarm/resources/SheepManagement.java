package com.sheepfarm.resources;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import com.google.inject.Inject;
import com.sheepfarm.api.Sheep;
import com.sheepfarm.database.SheepDao;
import javax.inject.Named;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/sheep")
@Produces(APPLICATION_JSON)

public class SheepManagement {

    @Inject @Named("sheepDao")
    private SheepDao dao;

    @PUT
    public void createSheep(Sheep sheep) {
        this.dao.insertSheep(sheep);
    }

    @POST
    public void updateSheepHappiness(Sheep sheep) {
        this.dao.updateSheepHappiness(sheep.getOwner(), sheep.getHappiness());
    }

    @GET
    public Sheep getSheepByOwner(@QueryParam("owner") String owner) {
        System.out.println(owner);
        return this.dao.selectSheepByOwner(owner);
    }

    @DELETE
    public void deleteSheepByOwner(@QueryParam("owner") String owner) {
        this.dao.deleteSheepByOwner(owner);
    }
}