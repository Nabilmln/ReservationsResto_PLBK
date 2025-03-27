package model;

public class Customer {
    private String nama;
    private String email;

    public Customer(String nama, String email) {
        this.nama = nama;
        this.email = email;
    }

    public String getName() { return nama; }
    public String getEmail() { return email; }
}