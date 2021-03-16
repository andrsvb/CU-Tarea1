package com.example.tarea1;

import com.google.gson.annotations.SerializedName;

class Repo {

    @SerializedName("id")
    private String id;
    @SerializedName("node_id")
    private String node_id;
    @SerializedName("name")
    private String name;
    @SerializedName("html_url")
    private String html_url;

    public Repo(String id, String node_id, String name, String html_url) {
        this.id = id;
        this.node_id = node_id;
        this.name = name;
        this.html_url = html_url;
    }

    @Override
    public String toString(){
        return ("\n name: " + this.name + "\n id: " + this.id + "\n url: " + this.html_url + "\n");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNode_id() {
        return node_id;
    }

    public void setNode_id(String node_id) {
        this.node_id = node_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }
}
