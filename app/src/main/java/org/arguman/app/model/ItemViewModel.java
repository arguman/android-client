package org.arguman.app.model;

public class ItemViewModel {

    private int    id
                  ,because
                  ,but
                  ,however;
    private long   timestamp;

    private String title
                  ,last_sender;

    public ItemViewModel() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBecause() {
        return because;
    }

    public void setBecause(int because) {
        this.because = because;
    }

    public int getBut() {
        return but;
    }

    public void setBut(int but) {
        this.but = but;
    }

    public int getHowever() {
        return however;
    }

    public void setHowever(int however) {
        this.however = however;
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

    public String getLast_sender() {
        return last_sender;
    }

    public void setLast_sender(String last_sender) {
        this.last_sender = last_sender;
    }

}
