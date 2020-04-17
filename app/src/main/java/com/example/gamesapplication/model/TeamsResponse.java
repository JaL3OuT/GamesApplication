
package com.example.gamesapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TeamsResponse {

    @SerializedName("data")
    @Expose
    private List<DataTeams> data = null;
    @SerializedName("meta")
    @Expose
    private Meta meta;

    public List<DataTeams> getData() {
        return data;
    }

    public void setData(List<DataTeams> data) {
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

}
