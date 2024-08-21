package com.example.frontendcommunityapp.Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public abstract class Services {

    private final SimpleIntegerProperty id;

    private final SimpleStringProperty name;

    public Services(int id, String name) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
    }

    public int getId() {
        return id.get();
    }


    public String getName() {
        return name.get();
    }

}


