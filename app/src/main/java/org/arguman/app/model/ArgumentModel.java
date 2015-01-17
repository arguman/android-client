package org.arguman.app.model;

import java.util.ArrayList;

public class ArgumentModel {

    private int                        id
                                      ,because          = 0
                                      ,but              = 0
                                      ,however          = 0;
    private long                       timestamp;
    private String                     title;
    private ArrayList<ContentionModel> contentionList;
    private UserModel                  lastSender;

    public ArgumentModel() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBecause() {
        if (contentionList.size() > 0)
            for (int i = 0; i < contentionList.size(); i++)
                if (contentionList.get(i).getType().equals("cunku"))
                    because++;
        return because;
    }

    public int getBut() {
        if (contentionList.size() > 0)
            for (int i = 0; i < contentionList.size(); i++)
                if (contentionList.get(i).getType().equals("ama"))
                    but++;
        return but;
    }

    public int getHowever() {
        if (contentionList.size() > 0)
            for (int i = 0; i < contentionList.size(); i++)
                if (contentionList.get(i).getType().equals("ancak"))
                    however++;
        return however;
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

    public ArrayList<ContentionModel> getContentionList() {
        return contentionList;
    }

    public void setContentionList(ArrayList<ContentionModel> contentionList) {
        this.contentionList = contentionList;
    }

    public UserModel getLastSender() {
        return contentionList.get(contentionList.size() - 1).getSender();
    }

}
