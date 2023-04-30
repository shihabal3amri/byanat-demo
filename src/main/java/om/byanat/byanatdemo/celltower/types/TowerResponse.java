package om.byanat.byanatdemo.celltower.types;

import com.fasterxml.jackson.annotation.JsonAlias;

public class TowerResponse {
    private int towerId;
    private String operator;
    private String address;
    private double height;
    private String towerType;
    private double latitude;
    private double longitude;
    private String technology;

    public int getTowerId() {
        return towerId;
    }

    public void setTowerId(int towerId) {
        this.towerId = towerId;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getTowerType() {
        return towerType;
    }

    public void setTowerType(String towerType) {
        this.towerType = towerType;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    @JsonAlias("tower_id")
    public void setTowerIdAlias(int towerId) {
        this.towerId = towerId;
    }

    @JsonAlias("tower_type")
    public void setTowerTypeAlias(String towerType) {
        this.towerType = towerType;
    }
}
