package touch.one.life.lifeonetouch.POJO;

import java.util.List;

public class Donor {
    String id, name,bg,email,password,gender,age,weight,phone,address,loginStatus,did;
    List<Donor> data;


    public Donor(String id, String name, String bg, String email, String password, String gender, String age, String weight, String phone, String address, String loginStatus, String did) {
        this.id = id;
        this.name = name;
        this.bg = bg;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.age = age;
        this.weight = weight;
        this.phone = phone;
        this.address = address;
        this.loginStatus = loginStatus;
        this.did = did;
    }


    public List<Donor> getData() {
        return data;
    }

    public void setData(List<Donor> data) {
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBg() {
        return bg;
    }

    public void setBg(String bg) {
        this.bg = bg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }
}
