package com.sheepfarm.database;

import com.sheepfarm.api.Sheep;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

public interface SheepDao {

    @SqlQuery("SELECT * FROM sheep WHERE owner = :owner")
    @RegisterBeanMapper(Sheep.class)
    Sheep selectSheepByOwner(@Bind("owner") String owner);

    @SqlUpdate("INSERT INTO sheep(name, owner, happiness) VALUES (:name, :owner, :happiness)")
    void insertSheep(@BindBean Sheep sheep);


    @SqlQuery("UPDATE sheep SET happiness = :happiness WHERE owner = :s.owner")
    @RegisterBeanMapper(Sheep.class)
    Sheep updateSheepHappiness(@BindBean Sheep sheep);

    @SqlUpdate("DELETE FROM sheep WHERE owner = :owner")
    void deleteSheepByOwner(@Bind("owner") String owner);
}
