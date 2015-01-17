package org.arguman.app.model;

import java.util.ArrayList;

public class ContentionModel {

    private int                     id;
    private long                    timestamp;
    private String                  title
                                   ,content
                                   ,resource;
    private UserModel               sender;
    private ArrayList<UserModel>    supporterList;
    private ArrayList<SafsataModel> safsataList;
    private ContentionTypeModel     type;
    private ContentionModel         parent;

    public ContentionModel() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public UserModel getSender() {
        return sender;
    }

    public void setSender(UserModel sender) {
        this.sender = sender;
    }

    public ArrayList<UserModel> getSupporterList() {
        return supporterList;
    }

    public void setSupporterList(ArrayList<UserModel> supporterList) {
        this.supporterList = supporterList;
    }

    public ArrayList<SafsataModel> getSafsataList() {
        return safsataList;
    }

    public void setSafsataList(ArrayList<SafsataModel> safsataList) {
        this.safsataList = safsataList;
    }

    public ContentionTypeModel getType() {
        return type;
    }

    public void setType(ContentionTypeModel type) {
        this.type = type;
    }

    public ContentionModel getParent() {
        return parent;
    }

    public void setParent(ContentionModel parent) {
        this.parent = parent;
    }

}
