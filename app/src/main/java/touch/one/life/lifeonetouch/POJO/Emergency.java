package touch.one.life.lifeonetouch.POJO;

import java.util.List;

public class Emergency {

    String status,name,description,phone;
    List<Emergency> data;

    public Emergency(String status, String name, String description, String phone) {
        this.status = status;
        this.name = name;
        this.description = description;
        this.phone = phone;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Emergency> getData() {
        return data;
    }

    public void setData(List<Emergency> data) {
        this.data = data;
    }
}
