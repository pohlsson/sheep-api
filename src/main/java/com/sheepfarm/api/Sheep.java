package com.sheepfarm.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sheep {

    private String name;

    private String owner;

    private int happiness;

    public Sheep() {

    }

    public Sheep(String name, String owner, int happiness) {
        this.name = name;
        this.owner = owner;
        this.happiness = happiness;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public String getOwner() {
        return owner;
    }

    @JsonProperty
    public int getHappiness() {
        return happiness;
    }

    @JsonProperty
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty
    public void setOwner(String owner) {
        this.owner = owner;
    }

    @JsonProperty
    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

}
