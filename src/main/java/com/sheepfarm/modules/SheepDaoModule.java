package com.sheepfarm.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import com.sheepfarm.AppConfiguration;
import com.sheepfarm.database.SheepDao;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.setup.Environment;

public class SheepDaoModule extends AbstractModule {

    @Provides
    @Named("sheepDao")
    public SheepDao provideSheepDao(Environment environment,
        AppConfiguration configuration) {
        final JdbiFactory factory = new JdbiFactory();
        return factory.build(environment, configuration.getDataSourceFactory(), "postgresql").onDemand(SheepDao.class);
    }
}
