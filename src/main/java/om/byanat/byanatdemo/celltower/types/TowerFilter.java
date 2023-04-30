package om.byanat.byanatdemo.celltower.types;

public class TowerFilter {
    private Integer towerId;
    private String operator;
    private String address;
    private String towerType;
    private Double latitude;
    private Double longitude;
    private String technology;
    private Double height;
    private Double minHeight;
    private Double maxHeight;
    private Double range;

    public TowerFilter(Integer towerId, String operator, String address, String towerType, Double latitude, Double longitude, String technology, Double height, Double minHeight, Double maxHeight, Double range) {
        this.towerId = towerId;
        this.operator = operator;
        this.address = address;
        this.towerType = towerType;
        this.latitude = latitude;
        this.longitude = longitude;
        this.technology = technology;
        this.height = height;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
        this.range = range;
    }


    public Integer getTowerId() {
        return towerId;
    }

    public void setTowerId(Integer towerId) {
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

    public String getTowerType() {
        return towerType;
    }

    public void setTowerType(String towerType) {
        this.towerType = towerType;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getMinHeight() {
        return minHeight;
    }

    public void setMinHeight(Double minHeight) {
        this.minHeight = minHeight;
    }

    public Double getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(Double maxHeight) {
        this.maxHeight = maxHeight;
    }

    public Double getRange() {
        return range;
    }

    public void setRange(Double range) {
        this.range = range;
    }
}
