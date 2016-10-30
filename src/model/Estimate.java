package model;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by younghan on 2016. 7. 14..
 */
public class Estimate {
    private String code;
    private String kind;
    private String name;
    private String password;
    private String phone;
    private String email;
    private String postcode;
    private String address;
    private String addressDetail;
    private String size;
    private String price;
    private String floor;
    private GregorianCalendar date;
    private List<String> filePath;
    private String text;

    public Estimate(){};

    public Estimate(String kind, String name, String password, String phone, String email, String postcode,
                    String address, String addressDetail, String size, String price, String floor,
                    GregorianCalendar date, List<String> filePath, String text)
    {
        this.code = null;
        this.kind = kind;
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.postcode = postcode;
        this.address = address;
        this.addressDetail = addressDetail;
        this.size = size;
        this.price = price;
        this.floor = floor;
        this.date = date;
        this.filePath = filePath;
        this.text = text;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public void setFilePath(List<String> filePath) {
        this.filePath = filePath;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getKind() {
        return kind;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getAddress() {
        return address;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public String getSize() {
        return size;
    }

    public String getPrice() {
        return price;
    }

    public String getFloor() {
        return floor;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public List<String> getFilePath() {
        return filePath;
    }

    public String getText() {
        return text;
    }

    public String getCode(){ return code;}

    public void setCode(String code) { this.code = code;}

}
