package springboot.studyjava.entity;

public class UserName {
//    @Name (min=3 ,max=5 , message ="charcacter 3 ")
    private  String name;
    private  String address;
//    @Email (message = "email vailed ")
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
