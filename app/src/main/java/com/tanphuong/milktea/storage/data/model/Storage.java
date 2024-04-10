package com.tanphuong.milktea.storage.data.model;

import java.io.Serializable;

public class Storage implements Serializable {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;





    public Storage(){

    }

    public Storage(String id) {
        this.id = id;
    }
}
