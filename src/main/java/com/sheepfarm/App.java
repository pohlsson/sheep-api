package com.sheepfarm;

import com.sheepfarm.database.SheepDao;
import com.sheepfarm.resources.Login;
import com.sheepfarm.resources.SheepResource;
import io.dropwizard.Application;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.setup.Environment;
import org.jdbi.v3.core.Jdbi;

public class App extends Application<AppConfiguration> {

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }

    @Override
    public String getName() {
        return "sheep-api";
    }

    @Override
    public void run(AppConfiguration configuration, Environment environment) {
        final JdbiFactory factory = new JdbiFactory();
        final Jdbi jdbi = factory.build(environment, configuration.getDataSourceFactory(), "postgresql");
        environment.jersey().register(new Login(jdbi.onDemand(SheepDao.class)));
        environment.jersey().register(new SheepResource(jdbi.onDemand(SheepDao.class)));
    }
}
