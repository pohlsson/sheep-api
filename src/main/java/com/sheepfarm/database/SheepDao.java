package com.sheepfarm.database;

import com.sheepfarm.api.Sheep;
import java.util.List;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

public interface SheepDao {

    @SqlQuery("select * from sheep where owner = :owner")
    @RegisterBeanMapper(Sheep.class)
    List<Sheep> selectSheepByOwner(@Bind("owner") String owner);

    @SqlUpdate("INSERT INTO sheep(name, owner, happiness) VALUES (:name, :owner, :happiness)")
    void insertSheep(@BindBean Sheep sheep);
}
