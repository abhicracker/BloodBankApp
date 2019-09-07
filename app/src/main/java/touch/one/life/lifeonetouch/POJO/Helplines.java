package touch.one.life.lifeonetouch.POJO;

import java.util.List;

public class Helplines {

    String status,name,description,contact;
    List<Helplines> data;

    public Helplines(String status, String name, String description, String contact) {
        this.status = status;
        this.name = name;
        this.description = description;
        this.contact = contact;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public List<Helplines> getData() {
        return data;
    }

    public void setData(List<Helplines> data) {
        this.data = data;
    }
}
