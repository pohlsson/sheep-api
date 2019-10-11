package com.sheepfarm;

import com.hubspot.dropwizard.guice.GuiceBundle;
import com.sheepfarm.modules.SheepDaoModule;
import com.sheepfarm.resources.Login;
import com.sheepfarm.resources.SheepManagement;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class App extends Application<AppConfiguration> {

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }

    @Override
    public String getName() {
        return "sheep-api";
    }

    @Override
    public void initialize(Bootstrap<AppConfiguration> bootstrap) {
        GuiceBundle<AppConfiguration> guiceBundle = GuiceBundle.<AppConfiguration>newBuilder()
            .addModule(new SheepDaoModule())
            .setConfigClass(AppConfiguration.class)
            .enableAutoConfig(getClass().getPackage().getName())
            .build();
        bootstrap.addBundle(guiceBundle);
    }

    @Override
    public void run(AppConfiguration configuration, Environment environment) {

        environment.jersey().register(new Login());
        environment.jersey().register(new SheepManagement());
    }
}
