package touch.one.life.lifeonetouch.POJO;

import java.util.List;

public class BloodBanks {

  String name,lat,lon,contact,address,status;

    List<BloodBanks> data;

    public BloodBanks(String name, String lat, String lon, String contact, String address, String status) {
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.contact = contact;
        this.address = address;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<BloodBanks> getData() {
        return data;
    }

    public void setData(List<BloodBanks> data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
