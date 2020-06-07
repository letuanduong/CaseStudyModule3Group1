package service.account;

// private hàm tạo mặc định;
//public hàm tạo có tham số username và password
public class Account {
    private String username;
    private String password;

    private Account(){}

    public Account(String username, String password){
        this.username = username;
        this.password = password;
    }
}
