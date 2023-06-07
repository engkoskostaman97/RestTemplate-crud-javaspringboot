package springboot.studyjava.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class UserName {
    @Size(min=3 ,max=10 , message ="minimal charcacter 3  maxsimal 10")
    private  String name;
    @Size(min=10 , message = "addres minimal 10 character ")
    private  String address;
    @Email(message="email vailed checkin inputan ")
    private  String email ;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
