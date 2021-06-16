package domain;

public class User {
    public int num;
    public String name;
    public String id;
    public String passward;

    public User(){

    }

    public User(int num, String name, String id, String passward) {
        this.num = num;
        this.name = name;
        this.id = id;
        this.passward = passward;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassward() {
        return passward;
    }

    public void setPassward(String passward) {
        this.passward = passward;
    }

    @Override
    public String toString() {
        return "User{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", passward='" + passward + '\'' +
                '}';
    }
}
