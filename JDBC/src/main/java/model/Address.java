package model;

import util.Validator;

import java.util.Scanner;

public class Address {
    private int id;
    private String city;
    private String district;
    private String subDistrict;
    private String postalCode;
    private Double deliveryFee;
    private Scanner scanner = new Scanner(System.in);
    public Address() {
    }

    public Address(int id, String city, String district, String subDistrict, String postalCode, Double deliveryFee) {
        this.id = id;
        this.city = city;
        this.district = district;
        this.subDistrict = subDistrict;
        this.postalCode = postalCode;
        this.deliveryFee = deliveryFee;
    }

    public Address(String city, String district, String subDistrict, String postalCode, Double deliveryFee) {
        this.city = city;
        this.district = district;
        this.subDistrict = subDistrict;
        this.postalCode = postalCode;
        this.deliveryFee = deliveryFee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getSubDistrict() {
        return subDistrict;
    }

    public void setSubDistrict(String subDistrict) {
        this.subDistrict = subDistrict;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Double getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(Double deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public Address input(){
        System.out.print("Enter city: ");
        city = scanner.nextLine();
        System.out.print("Enter district: ");
        district = scanner.nextLine();
        System.out.print("Enter sub-district: ");
        subDistrict = scanner.nextLine();
        System.out.print("Enter postal code: ");
        postalCode = Validator.getInstance().validatePostalCode();
        deliveryFee = Validator.getInstance().checkPostalCode(postalCode);
        if(deliveryFee == 0.0){
            System.out.print("Enter delivery fee: ");
            deliveryFee = scanner.nextDouble();
            scanner.nextLine();
        }
        return new Address(city, district, subDistrict, postalCode, deliveryFee);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", subDistrict='" + subDistrict + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", deliveryFee='" + deliveryFee + '\'' +
                '}';
    }

//    public void display(){
//        System.out.printf("%s - %s - %s %10s %12.2f", subDistrict, district, city, postalCode, deliveryFee);
//    }
}
